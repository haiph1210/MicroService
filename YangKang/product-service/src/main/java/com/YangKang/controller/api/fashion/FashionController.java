package com.YangKang.controller.api.fashion;

import com.YangKang.entity.Fashion;
import com.YangKang.model.request.fashion.FashionFilter;
import com.YangKang.repository.fashion.FashionRepository;
import com.YangKang.service.impl.fashion.FashionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/fashions")
public class FashionController {
    @Autowired
    private FashionService service;
    @GetMapping()
    public List<Fashion> findAll(FashionFilter filter){
        return service.findAll(filter);
    }
    @PostMapping()

    public ResponseEntity<Fashion> create(@RequestBody Fashion fashion){
        service.create(fashion);
        return ResponseEntity.ok(fashion);
    }
}
