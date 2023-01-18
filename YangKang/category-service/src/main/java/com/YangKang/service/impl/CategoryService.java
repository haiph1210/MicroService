package com.YangKang.service.impl;

import com.YangKang.entity.Category;
import com.YangKang.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ModelMapper mapper;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Page<Category> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Category findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

//    public Category findByName(String name){
//        return repository.findByName(name);
//    }

    public Category findByManufacturer(String manufacturer) {
        return repository.findByManufacturer(manufacturer);
    }

    public Category create(Category category) {
        return repository.save(category);
    }

    public Category update(Category category) {
        return repository.save(category);
    }

    public void delete(Integer id) {
         repository.deleteById(id);
    }

    public void deleteListId(List<Integer> ids) {
        repository.deleteAllById(ids);
    }

    public List<Category> findByCategoryName(String name) {
        return repository.findByName(name);
    }


}
