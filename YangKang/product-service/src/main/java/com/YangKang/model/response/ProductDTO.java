package com.YangKang.model.response;

import com.YangKang.entity.Accessory;
import com.YangKang.entity.ElectronicDevice;
import com.YangKang.entity.Product;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer id;
    private String name;
    private Float initPrice;
    private Integer viewCount;
    private String description;
    private String imageUrl;
    private ElectronicDevice.Ram ram;
    private String operatingSystem;
    private String size;
    private String masterial;
    private String color;
    private String sample;
    private String origin;
    private Accessory.Sex sex;


}
