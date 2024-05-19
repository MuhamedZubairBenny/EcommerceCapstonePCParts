package za.ac.cput.repository;

import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Security;

import java.util.ArrayList;
import java.util.List;
public class SecurityRepository implements ISecurityRepository {
    private static ISecurityRepository repository = null;
    private List<Security> securityList;
    private SecurityRepository(){securityList = new ArrayList<Security>();}

    public static ISecurityRepository getRepository(){
        if(repository == null){
            repository  = new SecurityRepository();
        } return repository;
    }
    @Override
    public Security create(Security security) {
        boolean success = securityList.add(security);
        if(success)
            return security;
        return null;
    }
    @Override
    public Security read(String username) {
        for (Security s : securityList) {
            if (s.getUsername().equals(username))
                return s;
            }
        return null;
    }
    @Override
    public Security update(Security security) {
        Security existingSecurity = read(security.getUsername());
        boolean success = securityList.remove(existingSecurity);
           if (success) {
               if(securityList.add(security))
                   return security;
           }

        return null;
    }
    @Override
    public boolean delete(String username) {
        Security security = read(username);
        boolean success = securityList.remove(security);
        return success;
    }


    @Override
    public List<Security> getAll() {
        return securityList;
    }
}

