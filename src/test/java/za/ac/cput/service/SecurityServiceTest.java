package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Security;
import za.ac.cput.factory.SecurityFactory;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class SecurityServiceTest {
    @Autowired
    private SecurityService securityService;
    private static Security security1;
    private static Security security2;

    @Test
    void a_setup(){
        List<String> roles = Arrays.asList("user", "admin");
        String selectedRole1 = roles.get(0);
        security1 = SecurityFactory.buildSecurity("kevineleven","ben10",2,selectedRole1,"20/11/2023");
        assertNotNull(security1);
        System.out.println(security1);

        String selectedRole2 = roles.get(1);
        security2 = SecurityFactory.buildSecurity("benny10","zubiunited",2,selectedRole2 ,"20/11/2023");
        assertNotNull(security2);
        System.out.println(security2);
    }

    @Test
    void b_create(){
        Security created1 = securityService.create(security1);
        assertNotNull(created1);
        System.out.println(created1);
        Security created2 = securityService.create(security2);
        assertNotNull(created2);
        System.out.println(created2);
    }
    @Test
    void c_read(){
        Security read = securityService.read(security1.getUsername());
        assertNotNull(read);
        System.out.println(read);
    }
    @Test
    void d_update(){
        Security newSecurity = new Security.Builder().copy(security1).setPassword("unitedsucks101").build();
        Security updated = securityService.update(newSecurity);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void e_delete(){
        securityService.delete(security1.getUsername());
    }
    @Test
    void f_getAll(){
        System.out.println(securityService.getAll());
    }



}
