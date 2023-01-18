package com.YangKang.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(name = "init_price")
    private Float initPrice;
    @Column(name = "view_count")
    private Integer viewCount;
    @Column
    private String description;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "account_id")
    private Integer accountId;
    @Column
    private Integer categoryId;
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDate createdDate;
    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updateAt;

//    private Integer port;



}
