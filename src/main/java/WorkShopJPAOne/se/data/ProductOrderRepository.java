package WorkShopJPAOne.se.data;

import WorkShopJPAOne.se.entity.ProductOrder;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProductOrderRepository extends CrudRepository<ProductOrder, Integer> {
    List<ProductOrder> findByOrderItemListProductNameContainsIgnoreCase(String name);
    List<ProductOrder> findByCustomerId(int id);
    List<ProductOrder> findByOrderItemListProductId(int id);
    List<ProductOrder> findByOrderDateTimeBetween(LocalDate startdate, LocalDate enddate);
}
