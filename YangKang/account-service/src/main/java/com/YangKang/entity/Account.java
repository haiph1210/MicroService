package com.YangKang.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Formula("concat(first_name, ' ',last_name)")

    @Column
    private String fullName;
    @Column
    private Integer age;
    @Column
    private Integer telephone;
    @Column
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Column
    private String address;
    @Column
    private Integer productId;
    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column
    @CreationTimestamp
    private LocalDate createDate;
    @Column
    @UpdateTimestamp
    private LocalDateTime updateAt;

    public enum Sex{
        MALE,FEMALE,UNKNOW
    }
    public enum Role{
        ADMIN,USER
    }
    public enum Status{
        NOT_ACTIVE,ACTIVE
    }
}
