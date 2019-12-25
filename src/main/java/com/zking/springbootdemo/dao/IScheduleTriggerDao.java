package com.zking.springbootdemo.dao;

import com.zking.springbootdemo.model.ScheduleTrigger;

import java.util.List;

public interface IScheduleTriggerDao {

    int deleteByPrimaryKey(Integer id);

    int insert(ScheduleTrigger record);

    int insertSelective(ScheduleTrigger record);

    ScheduleTrigger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScheduleTrigger record);

    int updateByPrimaryKey(ScheduleTrigger record);

    List<ScheduleTrigger> queryAll();
}