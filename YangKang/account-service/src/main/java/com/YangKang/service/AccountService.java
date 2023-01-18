package com.YangKang.service;

import com.YangKang.entity.Account;
import com.YangKang.model.request.AccountCreate;
import com.YangKang.model.request.AccountFindProductID;
import com.YangKang.model.request.AccountUpdate;
import com.YangKang.model.request.AuthChangePassword;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Page<Account> findAll(Pageable pageable);

    Account findById(Integer id);

    Account findByUsername(String username);

    Account findByEmail(String email);

    Account findByProductID(Integer id);

    void create(AccountCreate create);

    void update(AccountUpdate update);

    void delete(Integer id);

//    void deleteListId(List<Integer> ids);

    void changePassword(AuthChangePassword changePassword);

    void activeAccount(Integer id);



    @Transactional
    String findUsernameByProductId(AccountFindProductID account);
}
