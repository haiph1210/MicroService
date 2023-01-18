package com.YangKang.controller;

import com.YangKang.entity.Cart;
import com.YangKang.model.repsonse.ResponseDTO;
import com.YangKang.service.impl.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService service;
    @Autowired
    private ModelMapper mapper;
    @GetMapping()
    public List<Cart> findAll(){
        return service.findAll();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable Integer id){
       ResponseDTO responseDTO = service.findById(id);
        return ResponseEntity.ok(responseDTO);
    }
    @PostMapping()
    public Cart create(@RequestBody Cart cart){
        return service.create(cart);
    }

}
