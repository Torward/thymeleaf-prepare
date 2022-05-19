package ru.gb.thymeleafprepare.controllers;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.thymeleafprepare.entity.Product;
import ru.gb.thymeleafprepare.service.CartService;
import ru.gb.thymeleafprepare.service.ProductService;


@Controller
@NoArgsConstructor
@RequestMapping(value = "/cart")
public class CartController {

    private CartService cartService;
    private ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("products", cartService.findAllInCart());
        return "cart";
    }

    @GetMapping
    public String addToCart(Model model, @RequestParam(name = "id", required = false) Long id) {
        Product savedProduct;
        if (id != null) {
            savedProduct = productService.findById(id);
            cartService.addProduct(savedProduct);
        }
        return "redirect:/cart/all";

    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        cartService.deleteById(id);
        return "redirect:/product/all";
    }
}
