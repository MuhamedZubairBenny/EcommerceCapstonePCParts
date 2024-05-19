package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Security;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class SecurityFactoryTest {
    @Test
    void buildSecurityThatPasses(){
        List<String> roles = Arrays.asList("user", "admin");
        LocalDate accountCreationDate = LocalDate.of(2022, 5, 17);
        String selectedRole = roles.get(1);
        Security s = SecurityFactory.buildSecurity("username", "runner", 0, selectedRole, "02/02/2024");
        assertNotNull(s);
        System.out.println(s);
    }

    @Test
    void buildSecurity_nullDate() {
        List<String> roles = Arrays.asList("user", "admin");
        String selectedRole = roles.get(2);
        Security s = SecurityFactory.buildSecurity("Bob", "runner", 0, selectedRole, "22/03-2024");
        assertNotNull(s);
        System.out.println(s);
    }


}

