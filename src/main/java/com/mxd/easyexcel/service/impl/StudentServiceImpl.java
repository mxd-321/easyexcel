package com.mxd.easyexcel.service.impl;

import com.mxd.easyexcel.dao.StudentDao;
import com.mxd.easyexcel.domain.Student;
import com.mxd.easyexcel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mengxiangding
 * @Copyright(C) 2021 杭州海康威视技术有限公司
 * @Description:
 * @create: 2021年06月20日 10:23:21
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void readExcel(List<Student> students) {
        for (Student student : students) {
            System.out.println("student = " + student);
        }

        studentDao.insertMongoDb(students);

    }
}
