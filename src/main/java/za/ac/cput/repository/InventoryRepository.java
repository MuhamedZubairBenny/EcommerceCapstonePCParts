package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.ac.cput.domain.Inventory;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {
    Inventory findByInventoryId(String inventoryId);

}
