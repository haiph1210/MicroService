package com.YangKang.controller.api.accessory;

import com.YangKang.entity.Accessory;
import com.YangKang.service.impl.AccessoryService.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("accessories")
public class AccessoryController {
    @Autowired
    private AccessoryService service;

    @GetMapping()
    public List<Accessory> findAll(){
        return service.findAll();
    }
    @PostMapping()
    public void create(@RequestBody Accessory accessory){
        service.create(accessory);
    }
}
