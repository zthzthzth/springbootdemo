package com.zking.springbootdemo.service;

import com.zking.springbootdemo.model.ScheduleTrigger;

import java.util.List;

/**
 * 计划任务服务
 * @author Administrator
 * @create 2019-12-2320:08
 */
public interface IScheduleTriggerService {

    /**
     * 根据提供的计划任务ID删除任务参数记录
     * @param id 任务ID
     * @return int 影响行数
     */
    int deleteByPrimaryKey(Integer id);


    /**
     * 插入一条计划任务
     * @param record 计划任务
     * @return int 影响行数
     */
    int insert(ScheduleTrigger record);


    /**
     * 插入一条计划任务
     * @param record 计划任务
     * @return int 影响行数
     */
    int insertSelective(ScheduleTrigger record);


    /**
     * 根据记录任务ID, 获取一条记录任务记录
     * @param id
     * @return ScheduleTrigger
     */
    ScheduleTrigger selectByPrimaryKey(Integer id);


    /**
     * 更新计划任务记录（根据实体中的不为空的字段）
     * @param record 计划任务
     * @return int 影响行数
     */
    int updateByPrimaryKeySelective(ScheduleTrigger record);


    /**
     * 更新计划任务记录
     * @param record 计划任务
     * @return int 影响行数
     */
    int updateByPrimaryKey(ScheduleTrigger record);


    /**
     * 获取所有的计划任务记录
     * @return List
     */
    List<ScheduleTrigger> queryAll();

}
