/**
 * Kuaidadi.com Inc.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.kuaidadi.framework.log;

/**
 * 日志组件对外公共接口
 * 
 * @author zhangliang
 * @version $Id: ILog.java, v 0.1 Jun 27, 2014 3:12:44 PM zhangliang Exp $
 */
public interface ILog {

    /**
     * 日志级别判断
     * 
     * @return
     */
    boolean isDebugEnabled();

    /**
     * 日志级别判断
     * 
     * @return
     */
    public boolean isInfoEnabled();

    /**
     * 错误日志
     * 
     * @param message
     * @param e
     */
    void error(Object message, Throwable e);

    /**
     * 错误日志
     * 
     * @param message
     */
    void error(Object message);

    /**
     * debug日志
     * 
     * @param message
     */
    void debug(Object message);

    /**
     * debug日志
     * 
     * @param message
     * @param e
     */
    void debug(Object message, Throwable e);

    /**
     * info级别的日志
     * 
     * @param message
     */
    void info(Object message);

    /**
     * info级别的日志
     * 
     * @param message
     * @param e
     */
    void info(Object message, Throwable e);

    /**
     * warn 级别日志
     * 
     * @param message
     */
    void warn(Object message);

    /**
     * warn 级别日志
     * 
     * @param message
     * @param e
     */
    void warn(Object message, Throwable e);
}
