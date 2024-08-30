package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Product;
import za.ac.cput.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private ProductService productService;
    @Autowired
    ProductController(ProductService productService) {this.productService = productService;}
    @PostMapping("/create")
    public Product create(@RequestBody Product product){return productService.create(product);}

    @GetMapping("/read/{productId}")
    public Product read(@PathVariable String productId){return productService.read(productId);}

    @PostMapping("/update")
    public Product update(@RequestBody Product product){return productService.update(product);}

    @DeleteMapping("/delete/{productId}")
    public void delete(@PathVariable String productId){productService.delete(productId);}

    @GetMapping("/getall")
    public List<Product> getAll(){return productService.getAll();}

    @GetMapping("/search/{searchString}")
    public List<Product> searchProductsByName(@PathVariable String searchString){return productService.searchProductsByName(searchString);}

    @GetMapping("/category/{searchString}")
    public List<Product> searchProductsByCategory(@PathVariable String searchString){return productService.searchProductsByCategory(searchString);}

    @GetMapping("/searchById/{searchString}")
    public List<Product> searchProductsById(@PathVariable String searchString){return productService.searchProductsById(searchString);}

    }

