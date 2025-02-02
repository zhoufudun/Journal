package com.yumbocheng.lomback;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.ConsoleAppender;

public class LogbackExample {

    public static void main(String[] args) {
        // 创建 LoggerContext 实例
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        // 设置日志级别
        loggerContext.getLogger("ROOT").setLevel(Level.DEBUG);

        // 创建控制台输出的 Appender
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setContext(loggerContext);
        
        // 配置日志输出的格式
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(loggerContext);
        encoder.setPattern("%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %logger{36} - %msg%n");
        encoder.start();
        
        consoleAppender.setEncoder(encoder);
        consoleAppender.start();

        // 将 appender 添加到 root logger
        loggerContext.getLogger("ROOT").addAppender(consoleAppender);

        // 创建 Logger 实例
        Logger logger = LoggerFactory.getLogger(LogbackExample.class);

        // 打印不同级别的日志信息
        logger.trace("This is a trace message");
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");

        // 模拟异常日志
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            logger.error("An exception occurred: ", e);
        }
    }
}
