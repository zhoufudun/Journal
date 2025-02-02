package com.yumbocheng;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4J集成JUL {

    @Test
    public void test01() {
        /*
         * 我们使用SLF4J来集成JUL日志框架
         *   这个也是SLF4J之前的日志框架，此时需要适配器
         *   此时需要的适配器是
         *
         *   适配器导入之后，JUL日志的实现不用导入依赖的
         *   因为JUL是jdk内置的，不需要额外的导入
         *
         *   从结果看是JUL日志打印的，默认是info级别的输出的。
         *
         * */
        /**
         * <!--JUL适配器依赖-->
         *     <dependency>
         *       <groupId>org.slf4j</groupId>
         *       <artifactId>slf4j-jdk14</artifactId>
         *       <version>1.7.25</version>
         *     </dependency>
         *
         * <!--SLF4J核心配置：门面技术-->
         *     <dependency>
         *       <groupId>org.slf4j</groupId>
         *       <artifactId>slf4j-api</artifactId>
         *       <version>1.7.29</version>
         *     </dependency>
         */
        Logger logger = LoggerFactory.getLogger(SLF4J集成log4j的方法.class);
        // 打印输出信息
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }
}
