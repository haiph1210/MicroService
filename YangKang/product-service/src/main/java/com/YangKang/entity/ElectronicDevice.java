package com.YangKang.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "electronic_device")
@PrimaryKeyJoinColumn(name = "id")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElectronicDevice extends Product {
    @Column(name = "ram")
    @Enumerated(EnumType.STRING)
    private Ram ram;
    @Column(name = "operating_system")
    private String operatingSystem;

    public enum Ram{
        _1MB,_16GB,_32GB,_64GB,_128GB,_256G,_1TB
    }

}
