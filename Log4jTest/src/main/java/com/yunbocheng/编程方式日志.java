package com.yunbocheng;

import org.apache.log4j.*;
import org.apache.log4j.helpers.LogLog;
import org.testng.annotations.Test;

public class 编程方式日志 {

    @Test
    public void Test01() {

        LogLog.setInternalDebugging(true);
        // 设置 log4j 配置文件路径
        System.setProperty("log4j.configuration", "log4j-2.properties");

        // 创建 Logger 实例
        Logger logger = Logger.getLogger(String.valueOf(编程方式日志.class));

        // 设置输出格式（日志的布局）
        PatternLayout commonsLayout = new PatternLayout("%d{ISO8601} [%t] %-5p %c - %m%n");

        // 创建 ConsoleAppender（控制台输出）
        Appender consoleAppender = new ConsoleAppender(commonsLayout);
        logger.addAppender(consoleAppender);

        RollingFileAppender rollingFileAppender = new RollingFileAppender();
        rollingFileAppender.setMaxFileSize(String.valueOf(1024));
        rollingFileAppender.setMaxBackupIndex(5);
        rollingFileAppender.setFile("E://编程方式-自定义滚动日志.log");
        rollingFileAppender.setLayout(commonsLayout);
        rollingFileAppender.activateOptions();
        rollingFileAppender.setAppend(true);

        logger.addAppender(rollingFileAppender);

        // 创建 FileAppender（文件输出）
        try {
            Appender fileAppender = new FileAppender(commonsLayout, "E:/app.log", true); // true 表示追加模式
            logger.addAppender(fileAppender);
        } catch (Exception e) {
            System.err.println("无法创建文件 appender: " + e.getMessage());
        }

        // 设置日志级别
        logger.setLevel(org.apache.log4j.Level.DEBUG); // 设置日志级别为 DEBUG

        // 日志记录
        logger.trace("This is a trace message");
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");

        // 模拟异常
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            logger.error("An exception occurred: ", e);
        }
    }
}
