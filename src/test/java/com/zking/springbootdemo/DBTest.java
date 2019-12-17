package com.zking.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Administrator
 * @create 2019-12-1510:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DBTest {

    @Resource
    private DataSource dataSource;

    @Test
    public void testDataSource() throws SQLException {
        System.out.println("dataSource = " + dataSource.getClass());
        Connection con = dataSource.getConnection();
        System.out.println("connection = " + con);
        con.close();
    }

}
