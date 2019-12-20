package com.paga.util;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class Log {
    private static Logger logger = LogManager.getLogger("Log");

    public static void startTestGroupCase(String sTestCaseName){
        logger.info("-----------------------------------------------------------------------");
        logger.info("--------------------   "+sTestCaseName+"测试方法    --------------------------");
    }
    public static void endTestGroupCase(String sTestCaseName){
        logger.info("-----------------------------------------------------------------------");
        logger.info("--------------------   "+sTestCaseName+"测试方法    --------------------------");
    }

    public static void startTestCase(String sTestCaseName){
        logger.info("---------------------------------------------------");
        logger.info("----------   "+sTestCaseName+"测试方法    ----------------");
    }
    public static void endTestCase(String sTestCaseName){
        logger.info("----------   "+sTestCaseName+"测试执行结束"+"    ----------------");
        logger.info("----------------------------------------------------");
    }
    public static void info(String message){
        logger.info(message);
    }

}
