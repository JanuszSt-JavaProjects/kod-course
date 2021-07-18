package com.kodilla.hibernate.invoice;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table(name = "ITEMS")
public class Item {

    private int Id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;

    public Item() {
    }

    public Item(Product product, BigDecimal price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        value = price.multiply(BigDecimal.valueOf(quantity));
    }

    @Id
    @Primary
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return Id;
    }

    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.ALL)
    public Product getProduct() {
        return product;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getValue() {
        return value;
    }


    public void setId(int id) {
        Id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;

    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", price=" + price +
                ", quantity=" + quantity +
                ", value=" + value +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getId() == item.getId() && getQuantity() == item.getQuantity() && Objects.equals(getProduct(), item.getProduct()) && Objects.equals(getPrice(), item.getPrice()) && Objects.equals(getValue(), item.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProduct(), getPrice(), getQuantity(), getValue());
    }
}
