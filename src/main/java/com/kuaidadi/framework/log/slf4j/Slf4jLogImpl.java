/**
 * Kuaidadi.com Inc.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.kuaidadi.framework.log.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kuaidadi.framework.log.AbstractLogImpl;

/**
 * 
 * @author zhangliang
 * @version $Id: Slf4jLogImpl.java, v 0.1 Jun 30, 2014 3:40:52 PM zhangliang Exp
 *          $
 */
public class Slf4jLogImpl extends AbstractLogImpl {

    private Logger logger;
    /** 错误日志 */
    private Logger errorLogger = LoggerFactory.getLogger("errorLogger");

    public Slf4jLogImpl(String clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    /**
     * @see com.kuaidadi.ILog#isDebugEnabled()
     */
    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    /**
     * @see com.kuaidadi.ILog#isInfoEnabled()
     */
    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    /**
     * @see com.kuaidadi.ILog#error(java.lang.String, java.lang.Throwable)
     */
    @Override
    public void error(Object message, Throwable e) {
        String msg = warpExceptionMessage(message);
        logger.error(msg, e);
        errorLogger.error(msg, e);
    }

    /**
     * @see com.kuaidadi.ILog#error(java.lang.String)
     */
    @Override
    public void error(Object message) {
        String msg = warpExceptionMessage(message);
        if (message instanceof Throwable) {
            logger.error(msg, (Throwable) message);
            errorLogger.error(msg, (Throwable) message);
        } else {
            logger.error(msg);
            errorLogger.error(msg);
        }
    }

    /**
     * @see com.kuaidadi.ILog#debug(java.lang.String)
     */
    @Override
    public void debug(Object message) {
        logger.debug(warpMessage(message));
    }

    /**
     * @see com.kuaidadi.ILog#info(java.lang.String)
     */
    @Override
    public void info(Object message) {
        logger.info(warpMessage(message));
    }

    /**
     * @see com.kuaidadi.ILog#warn(java.lang.String)
     */
    @Override
    public void warn(Object message) {
        logger.warn(warpExceptionMessage(message));
    }

    /**
     * @see com.taxi.framework.log.common.ILog#warn(java.lang.String,
     *      java.lang.Throwable)
     */
    @Override
    public void warn(Object message, Throwable e) {
        logger.warn(warpExceptionMessage(message), e);
    }

    /**
     * @see com.taxi.framework.log.common.ILog#debug(java.lang.Object,
     *      java.lang.Throwable)
     */
    @Override
    public void debug(Object message, Throwable e) {
        logger.debug(warpMessage(message), e);
    }

    /**
     * @see com.taxi.framework.log.common.ILog#info(java.lang.Object,
     *      java.lang.Throwable)
     */
    @Override
    public void info(Object message, Throwable e) {
        logger.info(warpMessage(message), e);
    }
}
