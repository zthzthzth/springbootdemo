package com.zking.springbootdemo.service;

import com.zking.springbootdemo.dao.IStudentDao;
import com.zking.springbootdemo.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @create 2019-12-1618:39
 */
@Service("studentService")
public class StudentServiceImpl implements IStudentService {

    @Resource
    private IStudentDao studentDao;

    @Override
    public List<Student> getStudentBySID(int sid) {
        return studentDao.getStudentBySID(sid);
    }
}
