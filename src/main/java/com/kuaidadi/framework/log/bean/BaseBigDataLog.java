package com.kuaidadi.framework.log.bean;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 大数据数据抽取日志的基类
 * 
 * @author lingguoshen
 *
 */
public abstract class BaseBigDataLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private int               logType;               // 日志的类型
    @JsonIgnore
    private String            logName;               // 日志的名称
    @JsonIgnore
    private String            logFormat;             // 日志格式 ：json、keyValue

    public BaseBigDataLog(int logType, String logName, String logFormat) {
        this.logType = logType;
        this.logName = logName;
        this.logFormat = logFormat;
    }

    public int getLogType() {
        return logType;
    }

    public void setLogType(int logType) {
        this.logType = logType;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogFormat() {
        return logFormat;
    }

    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }

}
