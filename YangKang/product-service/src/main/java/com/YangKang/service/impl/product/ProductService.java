package com.YangKang.service.impl.product;


import com.YangKang.entity.Fashion;
import com.YangKang.entity.Product;
import com.YangKang.model.request.product.ProductCreate;
import com.YangKang.model.request.product.ProductFilter;
import com.YangKang.model.request.product.ProductUpdate;
import com.YangKang.model.response.AccountDTO;
import com.YangKang.model.response.CategoryDTO;
import com.YangKang.model.response.ProductDTO;
import com.YangKang.model.response.ResponseDTO;
import com.YangKang.repository.product.ProductRepository;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Log4j2
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ModelMapper mapper;
    // tìm tất cả
    public List<Product> findAll(ProductFilter filter) {
        Specification<Product> specification = com.YangKang.repository.specification.Product.buildWhere(filter);
        return  repository.findAll(specification);
    }
    // tạo page
    public Page<Product> findAll(ProductFilter filter, Pageable pageable){
        Specification<Product> specification = com.YangKang.repository.specification.Product.buildWhere(filter);
        return  repository.findAll(specification,pageable);
    }
    // tìm product Id
    public ResponseDTO findById(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        Product product = repository.findById(id).orElse(null);

        ResponseEntity<AccountDTO> response =
                restTemplate.getForEntity("http://localhost:8001/accounts/id/"+ product.getAccountId(), AccountDTO.class);
        AccountDTO accountDTO = response.getBody();
        System.out.println(response.getStatusCode());

        ResponseEntity<CategoryDTO> response2 =
                restTemplate.getForEntity("http://localhost:8003/categories/id/"+ product.getCategoryId(), CategoryDTO.class);
        CategoryDTO categoryDTO = response2.getBody();
        System.out.println(response2.getStatusCode());

        responseDTO.setProductDTO(mapper.map(product, ProductDTO.class));
        responseDTO.setAccountDTO(accountDTO);
        responseDTO.setCategoryDTO(categoryDTO);
    return responseDTO;
    }

    public ResponseDTO findByName(String name){
        ResponseDTO responseDTO = new ResponseDTO();
        Product product =  repository.findByName(name);
        ResponseEntity<AccountDTO> response = restTemplate
                .getForEntity("http://localhost:8001/accounts/id/"+ product.getAccountId(), AccountDTO.class);
        AccountDTO accountDTO = response.getBody();
        System.out.println(response.getStatusCode());
        responseDTO.setProductDTO(mapper.map(product, ProductDTO.class));
        responseDTO.setAccountDTO(accountDTO);
        return responseDTO;
    }

    public void create(Product product){
        repository.save(product);

    }

    public void update(Product product){

        repository.save(product);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public void deleteListId(List<Integer> ids){
        repository.deleteAllById(ids);
    }
}
