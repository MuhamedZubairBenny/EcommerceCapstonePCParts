package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.service.ProductCategoryService;

import java.util.List;

@RestController
@RequestMapping("api/productCategory")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService categoryService;

    @PostMapping("/create")
    public ProductCategory create(@RequestBody ProductCategory category){return categoryService.create(category);}

    @PostMapping("/read/{id}")
    public ProductCategory read(@PathVariable String categoryId){return categoryService.read(categoryId);}

    @PostMapping("/update")
    public ProductCategory update(@RequestBody ProductCategory category){return categoryService.update(category);}

    @DeleteMapping("/delete/{categoryId}")
    public void delete(@PathVariable String categoryId){categoryService.delete(categoryId);}

    @GetMapping("/getAll")
    public List<ProductCategory> getAll(){return categoryService.getAll();}
}
