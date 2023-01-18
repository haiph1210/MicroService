package com.YangKang.fegin.proxy;

import com.YangKang.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service")
public interface Account_Service_Proxy {
        @GetMapping("/accounts/id/{id}")
        Product findById(@PathVariable Integer id);

}
