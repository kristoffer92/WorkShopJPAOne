package WorkShopJPAOne.se.data;

import WorkShopJPAOne.se.entity.AppUser;
import WorkShopJPAOne.se.entity.OrderItem;
import WorkShopJPAOne.se.entity.Product;
import WorkShopJPAOne.se.entity.ProductOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ProductOrderRepositoryTest {
    //private List<OrderItem> orderItemList = new ArrayList<>();
    private LocalDate date;
    private AppUser customer;
    private Product testProductOne;
    private Product testProductTwo;
    private ProductOrder productOrder;
    private OrderItem orderItem;
    private OrderItem orderItemTwo;

    ProductOrderRepository productOrderRepository;
    private TestEntityManager em;

    @Autowired
    public ProductOrderRepositoryTest(ProductOrderRepository productOrderRepository, TestEntityManager em) {
        this.productOrderRepository = productOrderRepository;
        this.em = em;
    }

    @BeforeEach
    public void makeBeforeEachTest()
    {
        customer = em.persistAndFlush(new AppUser(0,"First","Last","Email"));

        testProductOne = em.persistAndFlush(new Product(0,"TestP",5));
        testProductTwo = em.persistAndFlush(new Product(0, "TestP", 5));

        //orderItemList.add(orderItem);
        //orderItemList.add(orderItemTwo);

        date = LocalDate.parse("2019-12-18");
        productOrder= new ProductOrder(0,date,new ArrayList<>(),customer);

        orderItem = new OrderItem(0,5,testProductOne, null);
        orderItemTwo = new OrderItem(0, 5, testProductTwo, null);
        productOrder.makeAdd(orderItem);
        productOrder.makeAdd(orderItemTwo);

        em.persistAndFlush(productOrder);
    }

    @Test
    public void productOrder_successfully_created()
    {
        assertTrue(productOrder.getOrderItemList().contains(orderItem));
        assertTrue(orderItem.getProductOrder().equals(productOrder));
    }

    @Test
    public void findByName()
    {
        List<ProductOrder> pOrderListTest = new ArrayList<>();
        pOrderListTest = productOrderRepository.findByOrderItemListProductNameContainsIgnoreCase("TestP");
        assertTrue(pOrderListTest.contains(productOrder));
    }

}
