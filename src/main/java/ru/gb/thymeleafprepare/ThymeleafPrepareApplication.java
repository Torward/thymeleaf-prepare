package ru.gb.thymeleafprepare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.gb.thymeleafprepare.entity.Product;
import ru.gb.thymeleafprepare.entity.enums.Status;
import ru.gb.thymeleafprepare.service.CartService;
import ru.gb.thymeleafprepare.service.ProductService;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
@EnableJpaRepositories("ru.gb.*")
@EntityScan("ru.gb.*")
public class ThymeleafPrepareApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ThymeleafPrepareApplication.class, args);
        ProductService product = context.getBean(ProductService.class);
        CartService cart = context.getBean(CartService.class);
//
//        productService.findAll();
//
//        final Product product = productService.save(Product.builder()
//                        .cost(new BigDecimal(50.0))
//                        .status(Status.ACTIVE)
//                        .title("Test")
//                        .manufactureDate(LocalDate.now())
//                .build());
//
//        System.out.println("До " + productService.findById(product.getId()));
//
//        productService.deleteById(product.getId());
//
//        System.out.println("После " + productService.findById(product.getId()));


    }

}
