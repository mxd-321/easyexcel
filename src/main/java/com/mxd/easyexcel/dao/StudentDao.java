package com.mxd.easyexcel.dao;

import com.mxd.easyexcel.domain.Student;

import java.util.List;

/**
 * @author mengxiangding
 * @Copyright(C) 2021 杭州海康威视技术有限公司
 * @Description:
 * @create: 2021年06月20日 10:38:22
 */

public interface StudentDao {

    /**
     * 存入mongodb中
     * @param students
     */
    public void insertMongoDb(List<Student> students);

    /**
     * 从mongodb中读取所有数据
     * @return
     */
    public List<Student> findDataMongoDb();
}
