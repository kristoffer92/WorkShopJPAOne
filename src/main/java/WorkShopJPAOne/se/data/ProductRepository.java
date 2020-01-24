package WorkShopJPAOne.se.data;

import WorkShopJPAOne.se.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByNameContainsIgnoreCase(String name);

}
