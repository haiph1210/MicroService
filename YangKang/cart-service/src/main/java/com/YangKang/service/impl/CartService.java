package com.YangKang.service.impl;

import com.YangKang.entity.Cart;
import com.YangKang.fegin.proxy.ProductProxy;
import com.YangKang.model.repsonse.CartDTO;
import com.YangKang.model.repsonse.ProductDTO;
import com.YangKang.model.repsonse.ResponseDTO;
import com.YangKang.repository.CartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductProxy proxy;



    public List<Cart> findAll(){
        return repository.findAll();
    }

    public ResponseDTO findById(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        Cart cart = repository.findById(id).orElse(null);
        ResponseEntity<ProductDTO> response = proxy.findById(cart.getProductId());
        ProductDTO productDTO =response.getBody();
//        ResponseEntity<ProductDTO> response =
//                restTemplate.getForEntity("http://localhost:8002/products"  , ProductDTO.class);

        System.out.println(response.getStatusCode());

        responseDTO.setCartDTO(mapper.map(cart, CartDTO.class   ));
        responseDTO.setProductDTO(productDTO);
        return  responseDTO;
    }
    public Cart create(Cart cart){
        return repository.save(cart);
    }
}
