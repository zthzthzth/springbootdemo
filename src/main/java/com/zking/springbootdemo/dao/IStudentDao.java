package com.zking.springbootdemo.dao;

import com.zking.springbootdemo.model.Student;

import java.util.List;

/**
 * @author Administrator
 * @create 2019-12-1618:28
 */
public interface IStudentDao {

    Student getStudentBySID(int sid);

    List<Student> getStudents(Student student);

}
