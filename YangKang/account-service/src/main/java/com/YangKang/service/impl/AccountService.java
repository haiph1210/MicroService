package com.YangKang.service.impl;

import com.YangKang.entity.Account;
import com.YangKang.model.request.AccountCreate;
import com.YangKang.model.request.AccountFindProductID;
import com.YangKang.model.request.AccountUpdate;
import com.YangKang.model.request.AuthChangePassword;
import com.YangKang.repository.AccountRepository;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements com.YangKang.service.AccountService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AccountRepository repository;

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Account findById(Integer id) {
        return repository.findById(id).orElse(null);

    }

    @Override
    public Account findByUsername(String username) {
        return repository.findByUsername(username);

    }

    @Override
    public Account findByEmail(String email) {
        return repository.findByEmail(email);

    }

    @Override
    public Account findByProductID(Integer id) {
        return repository.findByProductId(id);
    }

    @Override
    public void create(AccountCreate create){
        Account account = mapper.map(create,Account.class);
        repository.save(account);
    }

    @Override
    public void update(AccountUpdate update){
        Account account = mapper.map(update,Account.class);
        repository.save(account);
    }

    @Override
    public void delete(Integer id){
        repository.deleteById(id);
    }

//    @Override
//    public void deleteListId(List<Integer> ids){
//        repository.deleteALlById(ids);
//    }

    @Transactional
    @Override
    public void changePassword(AuthChangePassword changePassword){
        repository.changePassword(changePassword.getId(),changePassword.getNewPassword());
    }

    @Override
    public void activeAccount(Integer id){
        Account account = repository.findById(id).orElse(null);
        account.setStatus(Account.Status.ACTIVE);
        repository.save(account);
    }

    @Override
    public String findUsernameByProductId(AccountFindProductID account) {
        return null;
    }
//    @Override
//    @Transactional
//    public vp findUsernameByProductId(AccountFindProductID account){
//
//        String user = repository.findUserNameByProductID(account.getProductId());
//        return user;
//    }

}
