package com.YangKang.model.request;

import com.YangKang.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountUpdate {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;
    private String fullName;

    private Integer age;

    private Integer telephone;

    private Account.Sex sex;

    private String address;

    private Integer productId;
    private Account.Role role;
    private Account.Status status;
}
