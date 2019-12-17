package com.zking.springbootdemo.service;

import com.zking.springbootdemo.SpringbootdemoApplication;
import com.zking.springbootdemo.model.Student;
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
        List<Student> lst = studentService.getStudentBySID(6);
        System.out.println(lst.get(0));
    }

}