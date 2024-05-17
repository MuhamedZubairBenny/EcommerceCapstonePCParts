package za.ac.cput.repository;

import za.ac.cput.domain.Inventory;

import java.util.List;

public interface IinventoryRepository extends IRepository<Inventory, String>{
    List<Inventory> getAll();
}
