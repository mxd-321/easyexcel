package com.mxd.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.mxd.easyexcel.domain.Student;
import com.mxd.easyexcel.listener.WebStudentListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author mengxiangding
 * @Copyright(C) 2021 杭州海康威视技术有限公司
 * @Description:
 * @create: 2021年06月20日 10:21:12
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private WebStudentListener studentListener;

    @GetMapping("/read")
    public String readExcel(MultipartFile file) {

        try {
            // 工作簿
            ExcelReaderBuilder readWorkerBook = EasyExcel.read(file.getInputStream(), Student.class, studentListener);

            // 工作表
            readWorkerBook.sheet().doRead();

            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
