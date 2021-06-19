package com.mxd.easyexcel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author mxd
 * @Date 2021/6/19 21:55
 *  学生实体类
 */

@Data
public class Student {

    private String name;

    private String gender;

    private Date birthday;

    private String id;
    
}
