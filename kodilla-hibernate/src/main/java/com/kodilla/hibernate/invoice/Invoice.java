package com.kodilla.hibernate.invoice;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "INVOICES")

public class Invoice {

    private int id;
    private String number;
    private List<Item> items = new ArrayList<>();


    public Invoice() {
    }

    public Invoice(String number, List<Item> items) {

        this.number = number;
        this.items = items;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Primary
    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Item> getItems() {
        return items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "number='" + number + '\'' +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return getId() == invoice.getId() && Objects.equals(getNumber(), invoice.getNumber()) && Objects.equals(getItems(), invoice.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumber(), getItems());
    }
}
