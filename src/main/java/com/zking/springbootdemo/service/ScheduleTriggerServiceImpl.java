package com.zking.springbootdemo.service;

import com.zking.springbootdemo.dao.IScheduleTriggerDao;
import com.zking.springbootdemo.model.ScheduleTrigger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @create 2019-12-2320:09
 */
@Service
public class ScheduleTriggerServiceImpl implements IScheduleTriggerService {

    @Resource
    private IScheduleTriggerDao scheduleTriggerDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return scheduleTriggerDao.deleteByPrimaryKey(id);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int insert(ScheduleTrigger record) {
        return scheduleTriggerDao.insert(record);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int insertSelective(ScheduleTrigger record) {
        return scheduleTriggerDao.insertSelective(record);
    }

    /**
     * @inheritDoc
     */
    @Override
    public ScheduleTrigger selectByPrimaryKey(Integer id) {
        return scheduleTriggerDao.selectByPrimaryKey(id);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int updateByPrimaryKeySelective(ScheduleTrigger record) {
        return scheduleTriggerDao.updateByPrimaryKeySelective(record);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int updateByPrimaryKey(ScheduleTrigger record) {
        return scheduleTriggerDao.updateByPrimaryKey(record);
    }

    /**
     * @inheritDoc
     */
    @Override
    public List<ScheduleTrigger> queryAll() {
        return scheduleTriggerDao.queryAll();
    }

}
