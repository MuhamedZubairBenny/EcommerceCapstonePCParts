package za.ac.cput.factory;

import jdk.jfr.Category;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartFactoryTest {

    @Test
    @Order(1)
    void testBuildCartWithValidInput() {
        Contact contact = ContactFactory.buildContact("Mark@gmail.com","0987654321","29 Waterway","Cape Town","Western Province","2604","South Africa");
        Customer customer = CustomerFactory.buildCustomer("001","Mark","Stevens","Qw123",contact);

        Brand brand = BrandFactory.buildBrand("001","Nvidia");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("001","GPU");

        Product product1 = ProductFactory.buildProduct("prod001","GeForce 1080",category,brand,"gaming graphics card",1000.00,5,"20x10x5","3 years", "Picture URL");
        Product product2 = ProductFactory.buildProduct("prod002","GeForce 1060",category,brand,"gaming graphics card",850.00,5,"20x10x5","3 years", "Picture URL");

        CartProductId id1 = new CartProductId("01", product1.getProductId());
        CartProductId id2 = new CartProductId("01", product2.getProductId());

        CartProduct cartProduct1 = new CartProduct.Builder()
                .setId(id1)
                .setCart(CartFactory.buildCart("01", customer, 1850))
                .setProduct(product1)
                .setQuantity(2)
                .build();

        CartProduct cartProduct2 = new CartProduct.Builder()
                .setId(id2)
                .setCart(CartFactory.buildCart("01", customer, 1850))
                .setProduct(product2)
                .setQuantity(1)
                .build();

        List<CartProduct> cartProductList = new ArrayList<>();
        cartProductList.add(cartProduct1);
        cartProductList.add(cartProduct2);
        assertNotNull(cartProductList);
        System.out.println(cartProductList);

        Cart cart = CartFactory.buildCart("01",customer,cartProductList,1850.00);
        assertNotNull(cart);
        System.out.println(cart);
    }
}
//