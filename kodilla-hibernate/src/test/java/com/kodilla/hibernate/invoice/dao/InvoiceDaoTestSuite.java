package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    ItemDao itemDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product milk = new Product("milk");
        Product butter = new Product("butter");
        Product bread = new Product("bread");

        Invoice invoice = new Invoice("20211101SW");

        Item item1 = new Item(milk, BigDecimal.valueOf(1.99), 3, invoice);
        Item item2 = new Item(butter, BigDecimal.valueOf(6.99), 2, invoice);
        Item item3 = new Item(bread, BigDecimal.valueOf(4.00), 1, invoice);


        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        //When
        productDao.save(milk);
        productDao.save(butter);
        productDao.save(bread);

        invoiceDao.save(invoice);

        itemDao.save(item1);
        int item1Id = item1.getId();
        itemDao.save(item2);
        int item2Id = item2.getId();
        itemDao.save(item3);
        int item3Id = item3.getId();



        //Then
        assertNotEquals(0, item1Id);
        assertNotEquals(0, item2Id);
        assertNotEquals(0, item3Id);

        //CleanUp
//        try{
//            invoiceDao.deleteAll();
//        } catch (Exception e) {
//            //do nothing
//        }
    }
}
