package com.YangKang.repository;

import com.YangKang.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findByName(String name);
//    Category findByName(String name);

    Category findByManufacturer(String manufacturer);// tìm theo nhà sản xuất

}
