/**
 * Kuaidadi.com Inc.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.kuaidadi.framework.log;

import java.lang.reflect.Constructor;

import com.kuaidadi.framework.log.util.FlagGenerator;

/**
 * 统一日志记录记录方式工具类，（主要包括框架类 common-logging slf4j,日志具体记录类 log4j）方便做一些公共的切面工作
 * 
 * @author zhangliang
 * @version $Id: LogFactory.java, v 0.1 Jun 27, 2014 2:52:33 PM zhangliang Exp $
 */
public class LogFactory {
    private static Constructor<? extends ILog> logConstructor;
    private static ThreadLocal<String>         flag = new ThreadLocal<String>();
    static {
        tryImplementation(new Runnable() {
            public void run() {
                try {
                    useSlf4jLogging();
                } catch (Exception e) {
                }
            }
        });
        tryImplementation(new Runnable() {
            public void run() {
                try {
                    useCommonsLogging();
                } catch (Exception e) {
                }
            }
        });
        tryImplementation(new Runnable() {
            public void run() {
                try {
                    useLog4JLogging();
                } catch (Exception e) {
                }
            }
        });
    }

    private static void tryImplementation(Runnable runnable) {
        if (logConstructor == null) {
            try {
                runnable.run();
            } catch (Exception e) {
            }
        }
    }

    public static synchronized void useSlf4jLogging() throws Exception {
        setImplementation(com.kuaidadi.framework.log.slf4j.Slf4jLogImpl.class);
    }

    public static synchronized void useCommonsLogging() throws Exception {
        setImplementation(com.kuaidadi.framework.log.commonlog.CommonLogImpl.class);
    }

    public static synchronized void useLog4JLogging() throws Exception {
        setImplementation(com.kuaidadi.framework.log.log4j.Log4jLogImpl.class);
    }

    private static void setImplementation(Class<? extends ILog> implClass) throws Exception {
        try {
            Constructor<? extends ILog> candidate = implClass.getConstructor(new Class[] { String.class });
            ILog logger = candidate.newInstance(new Object[] { LogFactory.class.getName() });
            logger.info("Logging initialized using '" + implClass + "' adapter.");
            logConstructor = candidate;
        } catch (Throwable t) {
            throw new LogException("Error setting Log implementation.  Cause: " + t, t);
        }
    }

    // disable construction
    private LogFactory() {
    }

    public static ILog getLog(Class<?> aClass) {
        return getLog(aClass.getName());
    }

    public static ILog getLog(String logger) {
        try {
            return logConstructor.newInstance(new Object[] { logger });
        } catch (Exception e) {
            throw new LogException("Error creating logger for logger " + logger + ".  Cause: " + e, e);
        }
    }

    /**
     * Setter method for property <tt>flag</tt>.
     * 
     * @param flag
     *            value to be assigned to property flag
     */
    public static void setFlag(String value) {
        flag.set(value);
    }

    /**
     * get method for property <tt>flag</tt>.
     * 
     * @param flag
     *            value to be get
     */
    public static String getFlag() {
        return flag.get();
    }

    public static void removeFlag() {
        flag.remove();
    }

    public static String getUniqueFlag() {
        return FlagGenerator.get().toStringBabble();
    }
}
