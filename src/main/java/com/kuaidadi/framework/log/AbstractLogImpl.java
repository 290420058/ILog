/**
 * Kuaidadi.com Inc.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.kuaidadi.framework.log;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.kuaidadi.framework.log.bean.BaseBigDataLog;
import com.kuaidadi.framework.log.util.JsonUtil;

/**
 * 
 * @author zhangliang
 * @version $Id: AbstractLogImpl.java, v 0.1 Jul 1, 2014 11:50:40 AM zhangliang
 *          Exp $
 */
public abstract class AbstractLogImpl implements ILog {
    private final static String BIGDATA_SPLIT_STR = "\t";
    protected static String     HOST;
    static {
        try {
            HOST = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            HOST = "127.0.0.1";
        }
    }

    protected String warpMessage(Object message) {
        if (null == message) {
            return "";
        }
        String flag = LogFactory.getFlag();
        /****
         * 大数据新格式文件的渲染 add by lingguoshen 2014-10-13
         */
        if (message instanceof BaseBigDataLog) {
            BaseBigDataLog baseBigDataLog = (BaseBigDataLog) message;
            StringBuffer buffer = new StringBuffer();
            buffer.append(baseBigDataLog.getLogType()).append(BIGDATA_SPLIT_STR).append(baseBigDataLog.getLogName())
                .append(BIGDATA_SPLIT_STR).append(baseBigDataLog.getLogFormat()).append(BIGDATA_SPLIT_STR);
            if (baseBigDataLog.getLogFormat().equals("json")) {
                buffer.append(JsonUtil.toJson(baseBigDataLog));
            } else {
                buffer.append(baseBigDataLog.toString());
            }
            buffer.append(BIGDATA_SPLIT_STR).append("Flag=").append(flag);
            return buffer.toString();
        } else {

            if (flag == null || flag.isEmpty()) {
                return message.toString();
            }

            return message + ",Flag=" + flag;
        }
    }

    protected String warpExceptionMessage(Object message) {
        return "host=" + HOST + "," + warpMessage(message);
    }
}
