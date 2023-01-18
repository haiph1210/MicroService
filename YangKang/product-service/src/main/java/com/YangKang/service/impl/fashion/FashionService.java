package com.YangKang.service.impl.fashion;

import com.YangKang.entity.Fashion;
import com.YangKang.model.request.fashion.FashionFilter;
import com.YangKang.repository.fashion.FashionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FashionService {
    @Autowired
    private FashionRepository repository;

    public List<Fashion> findAll(FashionFilter filter){
        Specification<Fashion> specification  = com.YangKang.repository.specification.Fashion.buildWhere(filter);
        return repository.findAll( specification);
    }

    public void  create(Fashion fashion){
        repository.save(fashion);
    }
}
