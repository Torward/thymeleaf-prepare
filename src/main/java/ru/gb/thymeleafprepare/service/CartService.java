package ru.gb.thymeleafprepare.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.thymeleafprepare.dao.CartDao;
import ru.gb.thymeleafprepare.entity.Cart;
import ru.gb.thymeleafprepare.entity.Product;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@NoArgsConstructor
@Slf4j
public class CartService {

    private  CartDao cartDao;
    private ProductService productService;
    @Autowired
    public CartService(CartDao cartDao, ProductService productService) {
        this.cartDao = cartDao;
        this.productService = productService;
    }

    @Transactional
    public Set<Product> findAllInCart() {
        Cart cart = cartDao.findById(1L).get();
        return cart.getProducts();
    }

//    public void addProduct(Product product) {
//        System.out.println("From service = " + product);
//        Cart cart = new Cart();
//        Set<Product> products = cart.getProducts();
//        products.add(product);
//    }
    @Transactional
    public void addProduct(Product product){
        System.out.println("Service: " + product);
        Cart cart = cartDao.findById(1L).get();
        cart.getProducts().add(product);
        System.out.println(cart.getProducts().toString());

    }
    @Transactional
    public void deleteById(Long id) {
        Product product = productService.findById(id);
        Cart cart = cartDao.findById(1L).get();
        cart.getProducts().remove(product);
    }
}