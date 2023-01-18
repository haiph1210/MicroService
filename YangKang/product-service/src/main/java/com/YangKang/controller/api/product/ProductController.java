package com.YangKang.controller.api.product;

import com.YangKang.entity.Product;
import com.YangKang.model.request.product.ProductCreate;
import com.YangKang.model.request.product.ProductFilter;
import com.YangKang.model.request.product.ProductUpdate;
import com.YangKang.model.response.ResponseDTO;
import com.YangKang.service.impl.product.ProductService;
import net.minidev.json.JSONObject;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private ModelMapper mapper;
    @GetMapping
    public List<Product> findAll(ProductFilter filter){
        return   service.findAll(filter);
    }
    @GetMapping("/page")
    public Page<Product> findAll(ProductFilter filter, Pageable pageable){
        return service.findAll(filter,pageable);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseDTO> findByID(@PathVariable Integer id){
        ResponseDTO responseDTO = service.findById(id);
        return ResponseEntity.ok(responseDTO);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<ResponseDTO> findByName(@PathVariable String name){
        ResponseDTO responseDTO = service.findByName(name);
        return ResponseEntity.ok(responseDTO);
    }

//    @PostMapping("/create")
//    public ResponseEntity<Response> create(@RequestBody Product product){
//        service.create(product);
//       return ResponseEntity.status(HttpStatus.OK).body("Create Sussess");
//       RObje
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody Product product){
        product.setId(id);
        service.update(product);
        return ResponseEntity.status(HttpStatus.OK).body("Update Success");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete Susscess");
    }
    @DeleteMapping("deletes/{ids}")
    public ResponseEntity<?> deleteListId(@RequestBody List<Integer> ids){
        service.deleteListId(ids);
        return ResponseEntity.status(HttpStatus.OK).body("Delete list id sucess");
    }

}
