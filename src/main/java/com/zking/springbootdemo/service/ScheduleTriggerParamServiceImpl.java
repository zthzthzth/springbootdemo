package com.zking.springbootdemo.service;

import com.zking.springbootdemo.dao.IScheduleTriggerParamDao;
import com.zking.springbootdemo.model.ScheduleTriggerParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @create 2019-12-2320:14
 */
@Service
public class ScheduleTriggerParamServiceImpl implements IScheduleTriggerParamService {

    @Resource
    private IScheduleTriggerParamDao scheduleTriggerParamDao;

    /**
     * @inheritDoc
     */
    @Override
    public int deleteByPrimaryKey(Integer paramId) {
        return scheduleTriggerParamDao.deleteByPrimaryKey(paramId);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int insert(ScheduleTriggerParam record) {
        return scheduleTriggerParamDao.insert(record);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int insertSelective(ScheduleTriggerParam record) {
        return scheduleTriggerParamDao.insertSelective(record);
    }

    /**
     * @inheritDoc
     */
    @Override
    public ScheduleTriggerParam selectByPrimaryKey(Integer paramId) {
        return scheduleTriggerParamDao.selectByPrimaryKey(paramId);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int updateByPrimaryKeySelective(ScheduleTriggerParam record) {
        return scheduleTriggerParamDao.updateByPrimaryKeySelective(record);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int updateByPrimaryKey(ScheduleTriggerParam record) {
        return scheduleTriggerParamDao.updateByPrimaryKey(record);
    }

    /**
     * @inheritDoc
     */
    @Override
    public List<ScheduleTriggerParam> listByScheduleTriggerId(Integer scheduleTriggerId) {
        return scheduleTriggerParamDao.listByScheduleTriggerId(scheduleTriggerId);
    }
}
