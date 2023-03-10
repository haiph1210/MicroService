package com.YangKang.repository;

import com.YangKang.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> findByProductId(Integer id);
}
