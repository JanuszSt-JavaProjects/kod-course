package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest

public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() throws SQLException {

        //Given
        Product bread = new Product("Bread");
        Product butter = new Product("Butter");
        Product milk = new Product("Milk");

        Item firstItem = new Item(bread, new BigDecimal("1.00"), 3);
        Item secondItem = new Item(butter, new BigDecimal("12.00"), 1);


        List<Item> itemList = new ArrayList<>();
        itemList.add(firstItem);
        itemList.add(secondItem);


        invoiceDao.deleteAll();

        Invoice invoice = new Invoice("Nr001/2021", itemList);
        Invoice inv;

        //When
        invoiceDao.save(invoice);
        inv = invoiceDao.findByNumber("Nr001/2021");
        System.out.println("\n");

        System.out.println(inv.getItems());
        System.out.println();
        System.out.println(invoice.getItems());
        System.out.println();

        for (Item it: inv.getItems()
             ) {
            System.out.println(it);
            System.out.println();
            System.out.println(it.getProduct().getClass());
            System.out.println(it.getPrice().getClass());
            System.out.println(it.getValue().getClass());
            System.out.println(it.getProduct().getName());
            System.out.println(it.getProduct().getName().getClass());
            System.out.println();        }

        System.out.println();

        for (Item it: invoice.getItems()
        ) {
            System.out.println(it);
            System.out.println();
            System.out.println(it.getProduct().getClass());
            System.out.println(it.getPrice().getClass());
            System.out.println(it.getValue().getClass());
            System.out.println(it.getProduct().getName());
            System.out.println(it.getProduct().getName().getClass());
            System.out.println();
        }
        System.out.println("\n");


        // 2.
        assertEquals(invoice.getId(), inv.getId());
        assertEquals(invoice.getNumber(), inv.getNumber());
        assertEquals(invoice.getClass(), inv.getClass());



        System.out.println(inv.getItems().size());
        assertEquals(invoice.getItems().size(), inv.getItems().size());

        assertEquals(invoice.getItems().get(0), inv.getItems().get(0));
        assertEquals(invoice.getItems().get(1), inv.getItems().get(1));

        assertEquals(invoice.getItems(), inv.getItems()); // FALSE

        assertEquals(invoice,inv);  // FALSE

        // Cleanup
        invoiceDao.deleteAll();


    }
}
