package WorkShopJPAOne.se.data;

import WorkShopJPAOne.se.entity.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class AppUserRepositoryTest {


    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    TestEntityManager em;

    private int id;
    private String name = "TestFirst";
    private String lastName = "TestLast";
    private String email = "Email";
    private AppUser appUser;


    @BeforeEach
    public void makeBeforeEachTest()
    {
        appUser = new AppUser(0,"TestF","TestL","EmailTest");
        em.persistAndFlush(appUser);
    }

    @Test
    public void makeFindById()
    {
        appUserRepository.findById(1);
    }

    @Test
    public void makeFindByEmail()
    {
        Optional<AppUser> user;
        user = appUserRepository.findByEmailContainsIgnoreCase("EmailTest");
        assertTrue(user.isPresent());
        assertEquals(appUser, user.get());
    }
}
