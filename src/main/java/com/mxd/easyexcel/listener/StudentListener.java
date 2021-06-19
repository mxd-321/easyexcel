package com.mxd.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.mxd.easyexcel.domain.Student;

/**
 * @Author mxd
 * @Date 2021/6/19 22:21
 * 读取文档的监听器类
 */

public class StudentListener extends AnalysisEventListener<Student> {

    /**
     * 每读一行内容，都会调用一次该对象的 invoke，在 invoke 可以操作使用读取到的数据
     * @param student  每次读取到的数据封装的对象
     * @param context
     */
    @Override
    public void invoke(Student student, AnalysisContext context) {
        System.out.println("student = " + student);
    }

    /**
     * 读取完整个文档之后调用的方法
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
