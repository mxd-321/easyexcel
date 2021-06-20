package com.mxd.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.mxd.easyexcel.domain.Student;
import com.mxd.easyexcel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author mengxiangding
 * @Copyright(C) 2021 杭州海康威视技术有限公司
 * @Description:
 * @create: 2021年06月20日 10:21:58
 */
@Component
@Scope("prototype")
public class WebStudentListener extends AnalysisEventListener<Student> {

    @Autowired
    private StudentService studentService;

    private final ArrayList<Student> students = new ArrayList<>();

    @Override
    public void invoke(Student student, AnalysisContext context) {
        students.add(student);
        if (students.size() == 5) {
            studentService.readExcel(students);
            students.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
