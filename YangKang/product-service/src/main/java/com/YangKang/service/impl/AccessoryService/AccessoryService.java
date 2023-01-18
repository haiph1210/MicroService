package com.YangKang.service.impl.AccessoryService;

import com.YangKang.entity.Accessory;
import com.YangKang.repository.accessory.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryService {

    @Autowired
    private AccessoryRepository repository;

    public List<Accessory> findAll(){
        return repository.findAll();
    }

    public void create(Accessory accessory){
        repository.save(accessory);
    }
}

