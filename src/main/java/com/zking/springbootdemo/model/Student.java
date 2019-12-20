package com.zking.springbootdemo.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Administrator
 * @create 2019-12-1618:26
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -2620096301912893872L;

    private int sid;
    private String sname;
    private Integer age;
    private String remark;
    private String snamePinyin;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSnamePinyin() {
        return snamePinyin;
    }

    public void setSnamePinyin(String snamePinyin) {
        this.snamePinyin = snamePinyin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sid == student.sid &&
                Objects.equals(sname, student.sname) &&
                Objects.equals(age, student.age) &&
                Objects.equals(remark, student.remark) &&
                Objects.equals(snamePinyin, student.snamePinyin);
    }


    @Override
    public int hashCode() {
        return Objects.hash(sid, sname, age, remark, snamePinyin);
    }


    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", remark='" + remark + '\'' +
                ", snamePinyin='" + snamePinyin + '\'' +
                '}';
    }
}
