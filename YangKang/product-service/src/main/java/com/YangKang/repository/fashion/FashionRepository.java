package com.YangKang.repository.fashion;

import com.YangKang.entity.Fashion;
import com.YangKang.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FashionRepository extends JpaRepository<Fashion,Integer>, JpaSpecificationExecutor<Fashion> {
}
