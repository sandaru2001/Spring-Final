package com.example.cw_spring.dto;

import com.example.cw_spring.entity.Gender;
import com.example.cw_spring.entity.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO implements SuperDTO {
    private String customer_code;
    private String customer_name;
    private Gender gender;
    private Date join_date;
    private Level level;
    private Integer total_points;
    private Date dob;
    private String address_line_01;
    private String address_line_02;
    private String address_line_03;
    private String address_line_04;
    private String address_line_05;
    private String contact_no;
    private String email;
    private Timestamp purchase_date_time;
}
