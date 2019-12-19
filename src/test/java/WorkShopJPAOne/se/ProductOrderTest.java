package WorkShopJPAOne.se;

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


public class ProductOrderTest {
    private List<OrderItem> orderItemList = new ArrayList<>();
    private Product testProductOne;
    private Product testProductTwo;
    private LocalDate date;
    private AppUser customer;
    private ProductOrder productOrder;
    private ProductOrder productOrderTwo;
    private OrderItem orderItem;
    private OrderItem orderItemTwo;

    @BeforeEach
    public void makeBeforeEachTest()
    {
        date = LocalDate.parse("2019-12-18");
        customer = new AppUser(1,"TestFirst","TestLast","TestEmail");
        productOrder = new ProductOrder(1,date,orderItemList,customer);
        productOrderTwo = new ProductOrder(1, date,orderItemList,customer);

        testProductOne = new Product(1,"TestP",5);
        testProductTwo = new Product(2, "TestP", 10);

        orderItem = new OrderItem(1,1, testProductOne, productOrder);
        orderItemTwo = new OrderItem(1,1, testProductOne, productOrder);
    }

    @AfterEach
    public void makeAfterEachTest()
    {
        customer = null;
        productOrder = null;
        productOrderTwo = null;
        testProductOne = null;
        testProductTwo = null;
        orderItem = null;
        orderItemTwo = null;
    }

    @Test
    public void makeTestGetters()
    {
        assertEquals(1, productOrder.getId());
        assertEquals(date, productOrder.getOrderDateTime());
        assertEquals(orderItemList, productOrder.getOrderItemList());
        assertEquals(customer, productOrder.getCustomer());
    }

    @Test
    public void makeToStringTest()
    {
        String result = productOrder.toString();
        assertTrue(result.contains("1"));
        assertTrue(result.contains(String.valueOf(date)));
        assertTrue(result.contains(String.valueOf(orderItemList)));
        assertTrue(result.contains(String.valueOf(customer)));
    }

    @Test
    public void makeEqualsHasCodeTest()
    {
        ProductOrder productOrder = new ProductOrder(1, date,orderItemList,customer);
        assertTrue(productOrder.equals(productOrderTwo));
        assertEquals(productOrderTwo.hashCode(), productOrder.hashCode());
    }

    @Test
    public void makeAddAndRemoveTest()
    {
        productOrder.makeAdd(orderItem);
        productOrder.makeRemove(orderItem);
    }

    @Test
    public void makeTotalSumTest()
    {

    }



}
