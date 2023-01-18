package com.YangKang.controller;

import com.YangKang.entity.Category;
import com.YangKang.model.response.ResponseObject;
import com.YangKang.repository.CategoryRepository;
import com.YangKang.service.impl.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private CategoryService service;
    @Autowired
    private CategoryRepository repository;

    @Autowired
    private ModelMapper mapper;

    @GetMapping()
    public List<Category> findAll() {
        return service.findAll();
    }

    @GetMapping("/page")
    public Page<Category> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseObject> findById(@PathVariable Integer id) {
        Optional<Category> category = Optional.ofNullable(service.findById(id));
        return category.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok", "Query Success", category)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("false", "Cannot find id :" + id, "")
                );
    }
//@GetMapping("/id/{id}")
//public ResponseEntity<Category> findById(@PathVariable Integer id){
//    Category account = service.findById(id);
//    return ResponseEntity.ok(account);
//}

//        @GetMapping("/name/{name}")
//    public Category findByName(@PathVariable String name){
//        return service.findByName(name);
//    }
    @GetMapping("/manufacturer/{manufacturer}")
    public Category findByManufacturer(@PathVariable String manufacturer) {
        return service.findByManufacturer(manufacturer);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> create(@RequestBody Category category) {
        List<Category> categories = service.findByCategoryName(category.getName().trim());
        if (categories.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("Failed", "Category name already taken", "")
            );
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Create Success", service.create(category))
            );
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> update(@PathVariable Integer id, @RequestBody Category category) {
        category.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "update success", service.update(category))
        );
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Integer id) {
        boolean exist = repository.existsById(id);
        if (exist) {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete successfully", "")
            );
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("fail", "Cannot find Category Id to delete", "")
            );
        }

    }

    @DeleteMapping("deleteList/{ids}")
    public void deleteListId(@PathVariable List<Integer> ids) {
        service.deleteListId(ids);
    }


}
