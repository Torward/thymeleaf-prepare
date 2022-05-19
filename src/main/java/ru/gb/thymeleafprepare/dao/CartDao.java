package ru.gb.thymeleafprepare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.thymeleafprepare.entity.Cart;
import ru.gb.thymeleafprepare.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CartDao extends JpaRepository<Cart, Long>{
}
