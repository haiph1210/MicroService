package com.YangKang.repository.specification;

import com.YangKang.model.request.product.ProductFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class Product {
    public static Specification<com.YangKang.entity.Product> buildWhere(ProductFilter filter){
        if (filter == null){
            return null;
        }else {
            return hasNameLike(filter.getSearch())
                    ;
        }
    }

    private static Specification<com.YangKang.entity.Product> hasNameLike(String search){
        return (root, query, builder) ->
        {
            if (StringUtils.hasText(search)) {
                return builder.like(root.get("name"),"%"+ search + "%");
            }else
                return null;
        };
    }

//    private static Specification<com.YangKang.entity.Product> hasSizeLike(String size) {
//        return (root, query, builder) ->
//        {
//            if (StringUtils.hasText(size)) {
//                return builder.like(root.get("fashion").get("size"), "%" + size + "%");
//            } else
//                return null;
//        };
//    }

}
