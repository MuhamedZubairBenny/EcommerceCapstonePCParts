package za.ac.cput.repository;

import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class InventoryRepository implements IinventoryRepository {
    private static IinventoryRepository repository = null;
    private List<Inventory> inventoryList;
    private InventoryRepository(){inventoryList = new ArrayList<Inventory>();}

    public static IinventoryRepository getRepository(){
        if(repository == null){
            repository = new InventoryRepository();
        }
        return repository;
    }

    @Override
    public Inventory create(Inventory inventory){
        boolean success = inventoryList.add(inventory);
        if(success){
            return inventory;
        }
        return null;
    }

    @Override
    public Inventory read(String id){
        for(Inventory i : inventoryList){
            if(i.getInventoryId().equals(id))
                return i;
        }
        return null;
    }

    @Override
    public Inventory update(Inventory inventory){
        Inventory inventoryOld = read(inventory.getInventoryId());

        boolean success = inventoryList.remove(inventoryOld);
        if(success){
            if(inventoryList.add(inventoryOld))
                return inventory;
        }
        return null;
    }

    @Override
    public boolean delete(String s){
        Inventory itemToDelete = read(s);
        boolean success = inventoryList.remove(itemToDelete);
            return success;

    }

    @Override
    public List<Inventory> getAll(){
        return inventoryList;
    }
}
