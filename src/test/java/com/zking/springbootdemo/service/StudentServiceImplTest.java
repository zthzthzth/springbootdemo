package com.zking.springbootdemo.service;

import com.zking.springbootdemo.SpringbootdemoApplication;
import com.zking.springbootdemo.model.Student;
import com.zking.springbootdemo.util.PageBean;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Administrator
 * @create 2019-12-1618:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootdemoApplication.class})
class StudentServiceImplTest {

    @Resource
    private IStudentService studentService;

    @Test
    void getStudentBySID() {
        Student student = studentService.getStudentBySID(8);
        System.out.println(student);
    }

    @Test
    void getStudentsPaging() {
        Student stu = new Student();
        PageBean pageBean = new PageBean();
        pageBean.setRows(3);
        List<Student> datas = studentService.getStudentsPaging(stu, pageBean);
        for(Student student:  datas) {
            System.out.println(student);
        }
    }

}