package com.kodilla.hibernate.invoice;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


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
    @JoinColumn(name = "PRODUCTS")
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


}
