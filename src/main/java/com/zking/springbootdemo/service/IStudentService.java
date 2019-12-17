package com.zking.springbootdemo.service;

import com.zking.springbootdemo.model.Student;

import java.util.List;

/**
 * @author Administrator
 * @create 2019-12-1618:38
 */
public interface IStudentService {

    List<Student> getStudentBySID(int sid);

}
