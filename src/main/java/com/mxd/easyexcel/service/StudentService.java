package com.mxd.easyexcel.service;

import com.mxd.easyexcel.domain.Student;

import java.util.List;

/**
 * @author mengxiangding
 */
public interface StudentService {
    /**
     * 读取excel
     * @param students
     */
    public void readExcel(List<Student> students);
}
