package za.ac.cput.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.repository.CartProductRepository;
import za.ac.cput.repository.CartRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartServiceTest {
    @Autowired
    private CartService cartService;
    private static Cart cart;

    @Test
    @Order(1)
    void setUp() {
        Contact contact = ContactFactory.buildContact("zbenny@gmail.com","012 345 6789", "21 Jump Street", "Cape Town", "Western Cape", "7540", "South Africa");
        Customer customer = CustomerFactory.buildCustomer("01","Muhamed Zubair", "Benny", "123", contact);

        ProductCategory category = ProductCategoryFactory.buildProductCategory("02", "CPU");
        Brand brand2 = BrandFactory.buildBrand("101", "AMD");

        // Ensure unique product IDs
        Product product1 = ProductFactory.buildProduct("001", "Ryzen 5 5600X", category, brand2, "Ryzen CPU", 3999.00, 23, "10cm", "2 years", "Ryzen5Products/Ryzen_5_5600.png");
        //Product product2 = ProductFactory.buildProduct("002", "Ryzen 5 5600X", category, brand2, "Ryzen CPU", 3999.00, 23, "10cm", "2 years", "Ryzen5Products/Ryzen_5_5600.png");

        // Create Cart
        cart = CartFactory.buildCart("01", customer, 1850.00);
        assertNotNull(cart);

        CartProductId id1 = new CartProductId("01", product1.getProductId());
        //CartProductId id2 = new CartProductId("01", product2.getProductId());

        // Create CartProducts with the same Cart instance
        CartProduct cartProduct1 = new CartProduct.Builder()
                .setId(id1)
                .setCart(cart)
                .setProduct(product1)
                .setQuantity(2)
                .build();

//        CartProduct cartProduct2 = new CartProduct.Builder()
//                .setId(id2)
//                .setCart(cart)
//                .setProduct(product2)
//                .setQuantity(1)
//                .build();

        List<CartProduct> cartProductList = new ArrayList<>();
        cartProductList.add(cartProduct1);
       //cartProductList.add(cartProduct2);

        cart = new Cart.Builder()
                .setCartId("01")
                .setCustomer(customer)
                .setCartProducts(cartProductList)
                .setTotalPrice(1850.00)
                .build();

        //assertNotNull(cart);
        System.out.println(cart);
    }

    @Test
    @Transactional
    @Order(2)
    void testCreateCart() {
        Cart createdCart = cartService.create(cart);
        //assertNotNull(createdCart);
        System.out.println(createdCart);
    }


//    @Test
//    @Order(3)
//    void testReadCart() {
//        Cart cart = new Cart.Builder().setCartId("01").build();
//        when(cartRepository.findById("01")).thenReturn(Optional.of(cart));
//
//        Cart foundCart = cartService.read("01");
//        assertNotNull(foundCart);
//        assertEquals("01", foundCart.getCartId());
//        verify(cartRepository, times(1)).findById("01");
//    }
//
//    @Test
//    @Order(4)
//    void testUpdateCart() {
//        Cart cart = new Cart.Builder().setCartId("01").build();
//        when(cartRepository.existsById("01")).thenReturn(true);
//        when(cartRepository.save(cart)).thenReturn(cart);
//
//        Cart updatedCart = cartService.update(cart);
//        assertNotNull(updatedCart);
//        assertEquals("01", updatedCart.getCartId());
//        verify(cartRepository, times(1)).save(cart);
//    }
//
//    @Test
//    @Order(5)
//    void testDeleteCart() {
//        doNothing().when(cartRepository).deleteById("01");
//
//        cartService.delete("01");
//        verify(cartRepository, times(1)).deleteById("01");
//    }
//
//    @Test
//    @Order(5)
//    void testGetAllCarts() {
//        List<Cart> carts = new ArrayList<>();
//        carts.add(new Cart.Builder().setCartId("01").build());
//        when(cartRepository.findAll()).thenReturn(carts);
//
//        List<Cart> allCarts = cartService.getAll();
//        assertNotNull(allCarts);
//        assertEquals(1, allCarts.size());
//        assertEquals("01", allCarts.get(0).getCartId());
//        verify(cartRepository, times(1)).findAll();
//    }
//
//    @Test
//    @Order(6)
//    void testAddCartProduct() {
//        CartProduct cartProduct = new CartProduct.Builder().setId(new CartProductId("01", "02")).build();
//        when(cartProductRepository.save(cartProduct)).thenReturn(cartProduct);
//
//        CartProduct addedCartProduct = cartService.addCartProduct(cartProduct);
//        assertNotNull(addedCartProduct);
//        assertEquals(cartProduct.getId(), addedCartProduct.getId());
//        verify(cartProductRepository, times(1)).save(cartProduct);
//    }
//
//    @Test
//    @Order(7)
//    void testGetCartProducts() {
//        Cart cart = new Cart.Builder().setCartId("01").build();
//        List<CartProduct> cartProducts = new ArrayList<>();
//        cartProducts.add(new CartProduct.Builder().setId(new CartProductId("01", "02")).build());
//        when(cartProductRepository.findByCart(cart)).thenReturn(cartProducts);
//
//        List<CartProduct> foundCartProducts = cartService.getCartProducts(cart);
//        assertNotNull(foundCartProducts);
//        assertEquals(1, foundCartProducts.size());
//        assertEquals("01", foundCartProducts.get(0).getId().getCartId());
//        verify(cartProductRepository, times(1)).findByCart(cart);
//    }
}
