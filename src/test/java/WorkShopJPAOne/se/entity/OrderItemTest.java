package WorkShopJPAOne.se.entity;


import WorkShopJPAOne.se.entity.AppUser;
import WorkShopJPAOne.se.entity.OrderItem;
import WorkShopJPAOne.se.entity.Product;
import WorkShopJPAOne.se.entity.ProductOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class OrderItemTest {
    private List<OrderItem> orderItemList = new ArrayList<>();
    private LocalDate date;
    private AppUser customer;
    private Product testProductOne;
    private Product testProductTwo;
    private ProductOrder productOrder;
    private OrderItem orderItem;
    private OrderItem orderItemTwo;

    @BeforeEach
    public void makeBeforeEachTest()
    {
        date = LocalDate.parse("2019-12-18");
        customer = new AppUser(1,"First","Last","Email");
        productOrder= new ProductOrder(1,date,orderItemList,customer);

        testProductOne = new Product(1,"TestP",5);
        testProductTwo = new Product(1, "TestP", 5);

        orderItem = new OrderItem(1,5,testProductOne, productOrder);
        orderItemTwo = new OrderItem(1, 5, testProductOne, productOrder);
    }

    @AfterEach
    public void makeAfterEachTest()
    {
        customer = null;
        productOrder = null;
        testProductOne = null;
        testProductTwo = null;
        orderItem = null;
        orderItemTwo = null;
    }

    @Test
    public void makeGettersTest()
    {
        assertEquals(1, orderItem.getId());
        assertEquals(5, orderItem.getQuantity());
        assertEquals(testProductOne, orderItem.getProduct());
        assertEquals(productOrder, orderItem.getProductOrder());
    }

    @Test
    public void makeEqualsHasCodeTest()
    {
        assertEquals(orderItem, orderItemTwo);
        assertEquals(orderItem.hashCode(), orderItemTwo.hashCode());
    }

    @Test
    public void makeToStringTest()
    {
        String result = orderItem.toString();
        assertTrue(result.contains("1"));
        assertTrue(result.contains("5"));
        assertTrue(result.contains(String.valueOf(testProductOne)));
        assertTrue(result.contains(String.valueOf(productOrder)));
    }

    @Test
    public void makePriceCalcTest()
    {
        testProductOne.setPrice(100);
        orderItem.setQuantity(5);
        assertEquals(500, orderItem.makePriceCalc());
    }

}
