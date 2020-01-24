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

import static org.junit.jupiter.api.Assertions.*;


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
        customer = new AppUser(0,"TestFirst","TestLast","TestEmail");

        testProductOne = new Product(0,"TestP",5);
        testProductTwo = new Product(0, "TestP", 10);

        orderItem = new OrderItem(0,1, testProductOne, productOrder);
        orderItemTwo = new OrderItem(0,5, testProductTwo, productOrder);

        orderItemList.add(orderItem);
        orderItemList.add(orderItemTwo);

        productOrder = new ProductOrder(1,date,orderItemList,customer);
        productOrderTwo = new ProductOrder(1, date,orderItemList,customer);
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
    public void makeTotalSum_QuantityTimesPriceFromProducts_Expect_55()
    {
        assertEquals(55, productOrder.makeTotalSum());
    }



    //TestingAdd
    @Test
    public void makeAdd_AddingOrderItem_ThatDoesntExist_Expect_True()
    {
        productOrder.makeRemove(orderItem);
        assertTrue(productOrder.makeAdd(orderItem));
    }

    @Test
    public void makeAdd_AddingOrderItem_ThatAlreadyExists_Expect_False()
    {
        productOrder.makeAdd(orderItem);
        assertFalse(productOrder.makeAdd(orderItem));
    }

    @Test
    public void makeAdd_AddingOrderItem_ThatIsNull_ThrowException()
    {
        assertThrows(IllegalArgumentException.class, () -> {productOrder.makeRemove(null);});
    }



    //TestingRemove
    @Test
    public void makeRemove_RemovingOrderItem_ThatExists_Expect_True()
    {
        productOrder.makeAdd(orderItem);
        assertTrue(productOrder.makeRemove(orderItem));
    }

    @Test
    public void makeRemove_RemovingOrderItem_ThatDoesntExist_Expect_False()
    {
        productOrder.makeRemove(orderItem);
        assertFalse(productOrder.makeRemove(orderItem));
    }

    @Test
    public void makeRemove_RemovingOrderItem_ThatIsNull_ThrowException()
    {
        assertThrows(IllegalArgumentException.class, () -> {productOrder.makeRemove(null);});
    }

}
