package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Product;
import za.ac.cput.service.InventoryService;
import za.ac.cput.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/create")
    public Inventory create(@RequestBody Inventory inventory){return inventoryService.create(inventory);}

    @GetMapping("/read/{inventoryId}")
    public Inventory read(@PathVariable String inventoryId){return inventoryService.read(inventoryId);}

    @PostMapping("/update")
    public Inventory update(@RequestBody Inventory inventory){return inventoryService.update(inventory);}

    @DeleteMapping("/delete/{inventoryId}")
    public void delete(@PathVariable String inventoryId){inventoryService.delete(inventoryId);}

    @GetMapping("/getall")
    public List<Inventory> getAll() {return inventoryService.getAll();}
}
