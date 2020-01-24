package WorkShopJPAOne.se.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch=FetchType.EAGER)
    private Product product;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch=FetchType.LAZY)
    @JoinColumn(name="productOrder_id")
    private ProductOrder productOrder;


    public OrderItem(int id, int quantity, Product product, ProductOrder productOrder) {
        this.id = id;
        setQuantity(quantity);
        setProduct(product);
        setProductOrder(productOrder);
    }

    public OrderItem() {}


    //Getters
    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    //Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id == orderItem.id &&
                quantity == orderItem.quantity &&
                Objects.equals(product, orderItem.product) &&
                Objects.equals(productOrder, orderItem.productOrder);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, quantity, product, productOrder);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderItem: ");
        sb.append("Id: ").append(id);
        sb.append("Quantity: ").append(quantity);
        sb.append("Product: ").append(product);
        sb.append("ProductOrder: ").append(productOrder);
        return sb.toString();
    }

    public double makePriceCalc()
    {
        double calc = product.getPrice()*quantity;
        return calc;
    }
}
