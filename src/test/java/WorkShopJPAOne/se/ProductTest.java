package WorkShopJPAOne.se;

import WorkShopJPAOne.se.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {

    Product product = new Product(1, "Test", 10);

    @Test
    public void makeGettersTest()
    {
        assertEquals(1, product.getId());
        assertEquals("Test", product.getName());
        assertEquals(10, product.getPrice());
    }

    @Test
    public void makeSettersTest()
    {
        String name = "Test";
        product.setName(product.getName());
        String nameTest = product.getName();
        assertEquals(name, nameTest);

        int price = 10;
        product.setPrice(product.getPrice());
        int priceTest = product.getPrice();
        assertEquals(price, priceTest);
    }

    @Test
    public void makeToStringTest()
    {
        String result = product.toString();
        assertTrue(result.contains("1"));
        assertTrue(result.contains(product.getName()));
        assertTrue(result.contains("1"));
    }

    @Test
    public void makeEqualsHasCodeTest()
    {
        Product productTwo = new Product(1, "Test", 10);
        assertTrue(product.equals(productTwo));
        assertEquals(productTwo.hashCode(), product.hashCode());
    }
}
