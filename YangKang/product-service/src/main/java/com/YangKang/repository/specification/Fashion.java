package com.YangKang.repository.specification;

import com.YangKang.model.request.fashion.FashionFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class Fashion {
    public static Specification<com.YangKang.entity.Fashion> buildWhere(FashionFilter filter){
        if (filter == null){
            return null;
        }else {
            return hasNameLike(filter.getSearch());
        }
    }

    private static Specification<com.YangKang.entity.Fashion> hasNameLike(String search){
        return (root, query, builder) ->
        {
            if (StringUtils.hasText(search)) {
                return builder.like(root.get("size"),"%"+ search + "%");
            }else
                return null;
        };

    }
}
