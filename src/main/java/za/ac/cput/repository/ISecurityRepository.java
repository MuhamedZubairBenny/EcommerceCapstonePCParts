package za.ac.cput.repository;

import za.ac.cput.domain.Brand;
import za.ac.cput.domain.Security;

import java.util.List;

public interface ISecurityRepository extends IRepository<Security, String>{

    List<Security> getAll();

}
