package com.zking.springbootdemo.service;

import com.zking.springbootdemo.model.ScheduleTriggerParam;

import java.util.List;

/**
 * 任务配置参数服务类，用于任务参数的CRUD操作
 * @author Administrator
 * @create 2019-12-2320:14
 */
public interface IScheduleTriggerParamService {

    /**
     * 根据提供的参数Id删除一条任务配置参数记录
     * @param paramId 参数ID
     * @return int 删除操作影响行数
     */
    int deleteByPrimaryKey(Integer paramId);


    /**
     * 插入条任务参数记录
     * @param record 任务参数记录
     * @return int 插入操作影响的行数
     */
    int insert(ScheduleTriggerParam record);


    /**
     * 插入一条任务参数记录，与<code>int insert(ScheduleTriggerParam record)</code>
     * 的区别是，该方法对不为空的字段生成插入语句。
     * @param record 任务参数记录
     * @return
     */
    int insertSelective(ScheduleTriggerParam record);


    /**
     * 根据主键参数获取记录
     * @param paramId 主键参数
     * @return  ScheduleTriggerParam
     */
    ScheduleTriggerParam selectByPrimaryKey(Integer paramId);


    /**
     * 更新任务参数记录
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ScheduleTriggerParam record);


    /**
     * 更新任务参数记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(ScheduleTriggerParam record);


    /**
     * 通过任务参数ID获取任务参数记录
     * @param scheduleTriggerId 任务参数ID
     * @return List
     */
    List<ScheduleTriggerParam> listByScheduleTriggerId(Integer scheduleTriggerId);

}
