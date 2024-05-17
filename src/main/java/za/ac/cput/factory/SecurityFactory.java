package za.ac.cput.factory;

import za.ac.cput.domain.Security;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.List;

public class SecurityFactory {
 public static Security buildSecurity(String username, String password, int failedLoginAttempts, List<String> roles, LocalDate accountCreationDate) {
  if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password) || roles.isEmpty()) {
   return null;
  }
  

  return new Security.Builder()
          .setUsername(username)
          .setPassword(password)
          .setFailedLoginAttempts(failedLoginAttempts)
          .setRoles(roles)
          .setAccountCreationDate(accountCreationDate)
          .build();
 }
}
