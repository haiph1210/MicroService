package com.YangKang.controller.api.electronicdeivce;

import com.YangKang.entity.ElectronicDevice;
import com.YangKang.service.impl.electronicdevice.ElectronicDeivceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ElectronicDevices")
public class ElectronicDeivceController {
    @Autowired
    private ElectronicDeivceService service;

    @GetMapping
    public List<ElectronicDevice> findAll(){
        return service.findAll();
    }
    @PostMapping()
    public ResponseEntity<ElectronicDevice> create(@RequestBody ElectronicDevice electronicDevice){
        service.create(electronicDevice);
        return ResponseEntity.ok(electronicDevice);
    }
}
