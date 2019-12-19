package WorkShopJPAOne.se.entity;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        setName(name);
        setPrice(price);
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product: ");
        sb.append("ID: ").append(getId()).append('\n');
        sb.append("Name: ").append(getName()).append('\n');
        sb.append("Price: ").append(getPrice()).append('\n');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                price == product.price &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, price);
    }
}

