package com.YangKang.service.impl.electronicdevice;

import com.YangKang.entity.ElectronicDevice;
import com.YangKang.repository.electronicDevice.ElecttronicDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicDeivceService {
    @Autowired
    private ElecttronicDeviceRepository repository;

    public List<ElectronicDevice> findAll(){
        return repository.findAll();
    }

    public void create(ElectronicDevice electronicDevice){
//        ElectronicDevice electronicDevice1 = new ElectronicDevice();
//        electronicDevice1.setName(electronicDevice1.getName());
//        electronicDevice1.setInitPrice(electronicDevice1.getInitPrice());
//        electronicDevice1.setViewCount(electronicDevice1.getViewCount());
//        electronicDevice1.setDescription(electronicDevice1.getDescription());
//        electronicDevice1.setImageUrl(electronicDevice1.getImageUrl());
//        electronicDevice1.setAccountId(electronicDevice1.getAccountId());
//        electronicDevice1.setRam(electronicDevice1.getRam());
//        electronicDevice1.setOperatingSystem(electronicDevice1.getOperatingSystem());
//        electronicDevice = electronicDevice1;
        repository.save(electronicDevice);
    }

}
