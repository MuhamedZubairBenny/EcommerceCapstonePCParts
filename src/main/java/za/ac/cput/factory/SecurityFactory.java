package za.ac.cput.factory;

import za.ac.cput.domain.Security;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class SecurityFactory {
 public static Security buildSecurity(String username, String password, int failedLoginAttempts, List<String> roles, String accountCreationDate) {
  List<String> dateFormats = Helper.getLocalDateFormats();
  if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password) || roles.isEmpty() || Helper.isNullOrEmpty(accountCreationDate))
   return null;
  Date accountCreationDateTime = Helper.isDateValid(accountCreationDate, dateFormats);
  if (accountCreationDateTime == null) {
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
