package WorkShopJPAOne.se.data;

import WorkShopJPAOne.se.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

}
