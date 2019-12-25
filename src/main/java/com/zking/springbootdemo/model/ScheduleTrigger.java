package com.zking.springbootdemo.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class ScheduleTrigger {
    private Integer id;

    private String cron;

    private String status;

    private String jobName;

    private String jobGroup;

    private List<ScheduleTriggerParam> paramList = new ArrayList<ScheduleTriggerParam>();

    public ScheduleTrigger(Integer id, String cron, String status, String jobName, String jobGroup) {
        this.id = id;
        this.cron = cron;
        this.status = status;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
    }


    public ScheduleTrigger() {
        super();
    }

    public List<ScheduleTriggerParam> getParamList() {
        return paramList;
    }

    public void setParamList(List<ScheduleTriggerParam> paramList) {
        this.paramList = paramList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

}