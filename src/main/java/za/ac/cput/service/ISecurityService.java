package za.ac.cput.service;

import za.ac.cput.domain.Security;

import java.util.List;

public interface ISecurityService extends IService<Security,String> {
    List<Security> getAll();
}
