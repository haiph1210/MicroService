package com.YangKang.repository;

import com.YangKang.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;


public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByEmail(String email);
    Account findByUsername(String username);
    Account findByProductId(Integer id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    @Query("SELECT e.username FROM Account e WHERE e.productId = :id")
    Account findByProductId2(@Param("id") Integer id);

    @Modifying
    @Query("Update Account ac SET ac.password = :newPassword where id = :id ")
    void changePassword(@Param("id") Integer id,@Param("newPassword") String newPassword);

    @Modifying
    @Query("SELECT a FROM Account a where a.productId = :id")
    void selectProductID(@Param("id") Integer id);

}
