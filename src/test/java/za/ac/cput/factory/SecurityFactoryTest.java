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
        Security s = SecurityFactory.buildSecurity("username", "runner", 0, roles, accountCreationDate);
        assertNotNull(s);
    }

    @Test
    void buildSecurity_nullUsername() {
        List<String> roles = Arrays.asList("user", "admin");
        LocalDate accountCreationDate = LocalDate.of(2022, 5, 17);
        Security s = SecurityFactory.buildSecurity("", "runner", 0, roles, accountCreationDate);
        assertNotNull(s);
    }


}

