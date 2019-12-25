package com.zking.springbootdemo.dao;

import com.zking.springbootdemo.model.ScheduleTriggerParam;

import java.util.List;

public interface IScheduleTriggerParamDao {

    int deleteByPrimaryKey(Integer paramId);

    int insert(ScheduleTriggerParam record);

    int insertSelective(ScheduleTriggerParam record);

    ScheduleTriggerParam selectByPrimaryKey(Integer paramId);

    int updateByPrimaryKeySelective(ScheduleTriggerParam record);

    int updateByPrimaryKey(ScheduleTriggerParam record);

    List<ScheduleTriggerParam> listByScheduleTriggerId(Integer scheduleTriggerId);
}