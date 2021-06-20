package com.mxd.easyexcel.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author mxd
 * @Date 2021/6/19 21:55
 *  学生实体类
 *
 * @ExcelProperty: 标注在成员变量上，把实体类中属性和Excel表中列关联起来
 * @ColumnWidth(20): 该注解，用于调整Excel工作簿中工作表的 列宽
 * @ExcelIgnore: 标注在成员变量上，默认所有字段都会和excel去匹配，加了这个注解会忽略该字段
 * @ExcelIgnoreUnannotated: 标注在类上，如果不标注该注解，默认类中所有成员变量都参与读写，
 *                                      标注该注解后，类中的成员变量如果没有标注 @ExcelProperty() 注解将不会参与读写
 */

@Data
//@ContentRowHeight    内容的行高
//@HeadRowHeight     表头的行高
public class Student {

    @ExcelProperty(value = "id")
    @ExcelIgnore
    private String id;

    @ExcelProperty(value = {"学生姓名"})
    @ColumnWidth(15)
    private String name;

    @ExcelProperty(value = "学生性别")
    private String gender;

    @ExcelProperty(value = "学生出生日期")
    @ColumnWidth(20)
    @DateTimeFormat("yyyy-MM-dd")
    private Date birthday;

}
