/**
 * Kuaidadi.com Inc.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.kuaidadi.framework.log.bean;

import org.apache.commons.lang.time.StopWatch;

/**
 * 
 * @author zhangliang
 * @version $Id: StaticLogInfo.java, v 0.1 Aug 4, 2014 3:57:27 PM zhangliang Exp
 *          $
 */
public class StaticLogInfo {

    private StopWatch sw = null;

    private String    cmd;

    private String    resultCode;

    private long      timeCost;

    public StaticLogInfo() {
        sw = new StopWatch();
        sw.start();
        resultCode = "0";
    }

    /**
     * Getter method for property <tt>cmd</tt>.
     * 
     * @return property value of cmd
     */
    public String getCmd() {
        return cmd;
    }

    /**
     * Setter method for property <tt>cmd</tt>.
     * 
     * @param cmd
     *            value to be assigned to property cmd
     */
    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    /**
     * Getter method for property <tt>timeCost</tt>.
     * 
     * @return property value of timeCost
     */
    public long getTimeCost() {
        return timeCost;
    }

    /**
     * Setter method for property <tt>timeCost</tt>.
     * 
     * @param timeCost
     *            value to be assigned to property timeCost
     */
    public void setTimeCost(long timeCost) {
        this.timeCost = timeCost;
    }

    /**
     * Getter method for property <tt>resultCode</tt>.
     * 
     * @return property value of resultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Setter method for property <tt>resultCode</tt>.
     * 
     * @param resultCode
     *            value to be assigned to property resultCode
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        if (timeCost <= 0) {
            sw.stop();
            timeCost = sw.getTime();
        }

        sw = null;
        return cmd + "," + resultCode + "," + timeCost;
    }
}
