package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.User;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.UserFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class UserServiceTest {
    @Autowired
    private UserService userService;
    private static User user;
    @Test
    void a_setup(){
        //Build Customer
        user = UserFactory.buildUser("Matthew", "McGregor", "mc@gmail.com", "1234");
        assertNotNull(user);
        System.out.println(user);
    }

    @Test
    void b_saveUser() {
        User created = userService.saveUser(user);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void c_findByEmail() {
    }

    @Test
    void d_findById() {
    }

    @Test
    void e_loadUserByUsername() {
    }
}