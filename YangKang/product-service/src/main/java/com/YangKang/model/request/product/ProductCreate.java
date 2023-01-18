package com.YangKang.model.request.product;

import com.YangKang.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreate {
    private String name;
    private Float initPrice;
    private Integer viewCount;
    private String description;
    private String imageUrl;
    private Integer accountId;
//    private Integer categoryId;
}
