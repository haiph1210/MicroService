package com.YangKang.controller.api;

import com.YangKang.entity.Account;
import com.YangKang.model.request.AccountCreate;
import com.YangKang.model.request.AccountFindProductID;
import com.YangKang.model.request.AccountUpdate;
import com.YangKang.model.request.AuthChangePassword;
import com.YangKang.model.response.AccountDTO;
import com.YangKang.repository.AccountRepository;
import com.YangKang.service.AccountService;
import net.minidev.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountRepository repository;
    @Autowired
    private JSONObject message;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AccountService service;

    @GetMapping()
    public List<Account> findAll(){
        return service.findAll();
    }

    @GetMapping("/page")
    public Page<AccountDTO> findAll(Pageable pageable){
        Page<Account> page = service.findAll(pageable);
        List<Account> accounts = page.getContent();
        List<AccountDTO> dtos = mapper.map(accounts,new TypeToken<List<AccountDTO>>(){}.getType());
        return new PageImpl<>(dtos,pageable,page.getTotalPages());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<AccountDTO> findById(@PathVariable Integer id){
        Account account = service.findById(id);
        message.put("Result","Find ID!!!");
        message.put("Status",200);
        return ResponseEntity.ok(mapper.map(account,AccountDTO.class));
    }
    @GetMapping("/username/{username}")
    public AccountDTO findByUsername(@PathVariable String username){
        Account account = service.findByUsername(username);
        return mapper.map(account,AccountDTO.class);
    }
    @GetMapping("/email/{email}")
    public AccountDTO findByEmail(@PathVariable String email){
        Account account = service.findByEmail(email);
        return mapper.map(account, AccountDTO.class);

    }
    @GetMapping("/product/{productId}")
    public AccountDTO findByProductID(@PathVariable Integer id){
        Account account = service.findByProductID(id);
        return mapper.map(account, AccountDTO.class);
    }
    @GetMapping("/findUsername")
    public String findUserNameByProductID(@RequestBody AccountFindProductID account){
        return service.findUsernameByProductId(account);
    }
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody AccountCreate create){
        service.create(create);
        message.put("Result","Account Create Success!!!");
        message.put("Status",200);
        return ResponseEntity.status(HttpStatus.OK).body(message.toString());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody AccountUpdate update){
        update.setId(id);
        service.update(update);
        message.put("Result: " ,"Account Update Success!!!");
        message.put("Status" ,200);
        return ResponseEntity.status(HttpStatus.OK).body(message.toString());
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        message.put("Result: ","Account Delete Success!!!");
        message.put("Status", 200);
        return ResponseEntity.status(HttpStatus.OK).body(message.toString());
    }

//    @DeleteMapping("/deletelist/{ids}")
//    public ResponseEntity<?> deleteListId(@PathVariable List<Integer> ids){
//        service.deleteListId(ids);
//        message.put("Result: ","Account Delete List ID Success!!!");
//        message.put("Status", 200);
//        return ResponseEntity.status(HttpStatus.OK).body(message.toString());
//    }

    @PostMapping("changepass")
    public void changePassword(@RequestBody AuthChangePassword changePassword){
        service.changePassword(changePassword);
    }
//
//    public void activeAccount(Integer id){
//        Account account = service.findById(id);
//        account.setStatus(Account.Status.ACTIVE);
//        service.save(account);
//    }
    @GetMapping("/hi/{id}")
    public Account findusername(@PathVariable Integer id){
        return repository.findByProductId(id);
    }

    @GetMapping("hihi/{id}")
    public void findID(@PathVariable Integer id){
        repository.selectProductID(id);
    }
}
