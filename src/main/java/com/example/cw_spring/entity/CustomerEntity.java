package com.example.cw_spring.entity;

import com.example.cw_spring.entity.enums.Gender;
import com.example.cw_spring.entity.enums.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customer")
@Entity
public class CustomerEntity implements SuperEntity{
    @Id
    private String customer_code;
    private String customer_name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String join_date;
    @Enumerated(EnumType.STRING)
    private Level level;
    private int total_points;
    private String  dob;
    private String address_line_01;
    private String address_line_02;
    private String address_line_03;
    private String address_line_04;
    private String address_line_05;
    private String contact_no;
    @Column(unique = true)
    private String email;
    private String  purchase_date_time;

@OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL)
    private List<SaleEntity> sales = new ArrayList<>();

}
