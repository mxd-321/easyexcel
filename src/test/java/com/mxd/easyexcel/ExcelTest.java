package com.mxd.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.mxd.easyexcel.domain.Student;
import com.mxd.easyexcel.listener.StudentListener;
import org.junit.Test;

/**
 * @Author mxd
 * @Date 2021/6/19 22:11
 */


public class ExcelTest {

    /**
     * 工作簿：一个excel文件就是一个工作簿
     * 工作表：一个工作簿中可以有多个工作表 (sheet)
     */
    @Test
    public void test01() {

        // 获得一个工作簿对象
        /**
         *  构建一个读的工作簿对象
         *
         * @param file 要读的工作簿路径
         *
         * @param head 文件中每一行数据要存储的实体类型的class
         *
         * @param readListener  读监听器，每读一行内容，都会调用一次该对象的 invoke，在 invoke 可以操作使用读取到的数据
         *
         * @return Excel reader builder.
         */
        ExcelReaderBuilder readWorkBook = EasyExcel.read("学生信息表.xlsx", Student.class, new StudentListener());

        // 获得一个工作表对象
        /**
         * sheet() 方法默认读取第一个工作表
         * sheet(Integer sheetNo) 读取编号为 sheetNo 的工作表
         * sheet(String sheetName)  读取名字为 sheetName 的工作表
         */
        ExcelReaderSheetBuilder sheet = readWorkBook.sheet();

        // 获得工作表中的内容
        sheet.doRead();
    }

}
