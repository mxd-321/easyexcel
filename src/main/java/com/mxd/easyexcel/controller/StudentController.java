package com.mxd.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.mxd.easyexcel.domain.Student;
import com.mxd.easyexcel.listener.WebStudentListener;
import com.mxd.easyexcel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

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

    @Autowired
    private StudentService studentService;

    /**
     * 上传excel文件，读取后存入mongodb
     * @param file
     * @return
     */
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

    /**
     * 从mongodb读取，存入excel，并且支持下载
     * @param response
     * @throws IOException
     */
    @GetMapping("/write")
    public void writeExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-Disposition","attachment; filename*=UTF-8''" + fileName + ".xlsx");

        ServletOutputStream outputStream = response.getOutputStream();


        // 工作簿对象
        /**
         * 构建一个写的工作簿对象
         *
         * @param pathName
         *            要写入的文件路径
         * @param head
         *            封装写入的数据的实体的类型
         * @return Excel writer builder   写的工作簿对象
         */
        ExcelWriterBuilder writeWorkBook = EasyExcel.write(outputStream, Student.class);

        // 工作表对象
        ExcelWriterSheetBuilder sheet = writeWorkBook.sheet();

        // 准备数据
        List<Student> students = studentService.findDataMongoDb();

        // 写
        sheet.doWrite(students);

    }
}
