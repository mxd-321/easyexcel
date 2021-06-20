package com.mxd.easyexcel.dao.impl;

import com.mxd.easyexcel.dao.StudentDao;
import com.mxd.easyexcel.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mengxiangding
 * @Copyright(C) 2021 杭州海康威视技术有限公司
 * @Description:
 * @create: 2021年06月20日 10:39:18
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertMongoDb(List<Student> students) {
        mongoTemplate.insert(students,"student");
    }
}
