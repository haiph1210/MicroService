package com.YangKang.fegin.proxy;

import com.YangKang.model.repsonse.ProductDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(name="product-service",url = "localhost:8002")
public interface ProductProxy {
    @RequestMapping(method = RequestMethod.GET, value = "/products/id/{id}", produces = "application/json")
    ResponseEntity<ProductDTO> findById(@PathVariable Integer id);

    @RequestMapping(method = RequestMethod.GET,value = "/products",produces = "application/json")
    List<ProductDTO> findAll();
}
