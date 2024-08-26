package za.ac.cput.service;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;

import java.util.List;

public interface IProductService extends IService<Product, String>{
    List<Product> getAll();
    List<Product> searchProductsByName(String name);
    List<Product> searchProductsByCategory(String category);
}
