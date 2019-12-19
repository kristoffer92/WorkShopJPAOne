package WorkShopJPAOne.se.entity;

import java.util.Objects;

public class OrderItem {
    private int id;
    private int quantity;
    private Product product;
    private ProductOrder productOrder;


    public OrderItem(int id, int quantity, Product product, ProductOrder productOrder) {
        this.id = id;
        setQuantity(quantity);
        setProduct(product);
        setProductOrder(productOrder);
    }


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
