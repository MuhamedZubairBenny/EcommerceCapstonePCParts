package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Security;
import za.ac.cput.factory.SecurityFactory;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class SecurityRepositoryTest {
    private static ISecurityRepository repository = SecurityRepository.getRepository();
    private Security security = SecurityFactory.buildSecurity("adam12", "johnwick", 0, Arrays.asList("admin"), "02/02/2024");

    @Test
    void a_create() {
        Security created = repository.create(security);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        String username = "adam12";
        Security read = repository.read(username);
        assertEquals(read, security);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Security updated = repository.update ( new Security.Builder().copy(security).setPassword("newPassword").build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void e_delete() {

        assertTrue(repository.delete(security.getUsername()));
        System.out.println("Success: Deleted role");
    }

    @Test
    void d_getAll() {
        System.out.println(repository.getAll());
    }
}
