package WorkShopJPAOne.se.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ProductOrder {

    private int id;
    private LocalDate orderDateTime;
    private List<OrderItem> orderItemList;
    private AppUser customer;


    public ProductOrder(int id, LocalDate orderDateTime, List<OrderItem> orderItemList, AppUser customer) {
        this.id = id;
        setOrderDateTime(orderDateTime);
        setOrderItemList(orderItemList);
        setCustomer(customer);
    }

    //Getters
    public int getId() {
        return id;
    }

    public LocalDate getOrderDateTime() {
        return orderDateTime;
    }

    public AppUser getCustomer() {
        return customer;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }


    //Setters
    public void setOrderDateTime(LocalDate orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void setCustomer(AppUser customer) {
        this.customer = customer;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrder that = (ProductOrder) o;
        return id == that.id &&
                Objects.equals(orderDateTime, that.orderDateTime) &&
                Objects.equals(orderItemList, that.orderItemList) &&
                Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, orderDateTime, orderItemList, customer);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductOrder: ");
        sb.append("Id: ").append(id);
        sb.append("OrderDateTime: ").append(orderDateTime);
        sb.append("OrderItemList: ").append(orderItemList);
        sb.append("Customer: ").append(customer);
        return sb.toString();
    }


    //Remove, Add Function
    public OrderItem makeAdd(OrderItem orderItem)
    {
        orderItemList.add(orderItem);
        return orderItem;
    }

    public OrderItem makeRemove(OrderItem orderItem)
    {
        orderItemList.remove(orderItem);
        return orderItem;
    }

    public double makeTotalSum()
    {
        double sum = 0;
        for (OrderItem item : orderItemList) {
            sum += item.makePriceCalc();
        }
        return sum;
    }

}


