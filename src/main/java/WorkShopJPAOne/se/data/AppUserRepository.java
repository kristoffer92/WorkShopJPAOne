package WorkShopJPAOne.se.data;

import WorkShopJPAOne.se.entity.AppUser;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    Optional<AppUser> findByEmailContainsIgnoreCase(String email);

}
