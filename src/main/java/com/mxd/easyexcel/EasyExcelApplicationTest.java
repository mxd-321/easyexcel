package com.mxd.easyexcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mengxiangding
 * @Copyright(C) 2021 杭州海康威视技术有限公司
 * @Description: 从上传的Excel表中读取信息，存储到mongoDb中
 * @create: 2021年06月20日 10:20:35
 */
@SpringBootApplication
public class EasyExcelApplicationTest {
    public static void main(String[] args) {
        SpringApplication.run(EasyExcelApplicationTest.class,args);
    }
}
