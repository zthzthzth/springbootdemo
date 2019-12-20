package com.zking.springbootdemo.service;

import com.zking.springbootdemo.model.Student;
import com.zking.springbootdemo.util.PageBean;

import java.util.List;

/**
 * @author Administrator
 * @create 2019-12-1618:38
 */
public interface IStudentService {

    Student getStudentBySID(int sid);


    List<Student> getStudentsPaging(Student student, PageBean pageBean);

}
