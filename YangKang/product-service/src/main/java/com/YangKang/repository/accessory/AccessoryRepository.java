package com.YangKang.repository.accessory;

import com.YangKang.entity.Accessory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessoryRepository extends JpaRepository<Accessory,Integer> {
}
