package WorkShopJPAOne.se.data;

import WorkShopJPAOne.se.entity.ProductOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductOrderRepository extends CrudRepository<ProductOrder, Integer> {
    List<ProductOrder> findByOrderItemListProductNameContainsIgnoreCase(String name);
}
