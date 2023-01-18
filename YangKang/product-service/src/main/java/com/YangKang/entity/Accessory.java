package com.YangKang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "id")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accessory extends Product{
        private String masterial;
        private String origin;
        @Enumerated(EnumType.STRING)
        private Sex sex;

        public enum Sex{
                MALE,FEMALE
        }

}
