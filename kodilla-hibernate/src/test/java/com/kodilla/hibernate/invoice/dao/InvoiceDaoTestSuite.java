package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import com.kodilla.jdbc.DbManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest

public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;

    DbManager dbManager;


    @Test
    void testInvoiceDaoSave() throws SQLException {

        //Given
        try {
            dbManager = DbManager.getInstance();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Product bread = new Product("Bread");
        Product butter = new Product("Butter");
        Product milk = new Product("Milk");

        Item firstItem = new Item(bread, new BigDecimal(5), 3);
        Item secondItem = new Item(butter, new BigDecimal(12), 1);


        List<Item> itemList = new ArrayList<>();
        itemList.add(firstItem);
        itemList.add(secondItem);

        Invoice invoice = new Invoice("Nr001/2021", itemList);
        Connection connection = dbManager.getConnection();


        //When

        invoiceDao.save(invoice);

        ResultSet resultSet = connection.createStatement().executeQuery("select " +
                "* from INVOICES");


        int rows = 0;
        String receivedInvoiceNumber = "";
        Set<String> invoiceNumbersSet = new HashSet<>();

        while (resultSet.next()) {
            receivedInvoiceNumber = resultSet.getString("number");
            invoiceNumbersSet.add(receivedInvoiceNumber);
            rows++;
        }


        //Then
        assertEquals(1, rows);
        assertEquals("Nr001/2021", receivedInvoiceNumber);
        assertTrue(1 == invoiceNumbersSet.size());


        // Cleanup
        invoiceDao.deleteAll();
        connection.close();
    }
}
