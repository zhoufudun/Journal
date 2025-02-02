package com.yumbocheng;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

public class 日志重构 {

    @Test
    public void test01(){
        /*
        * 这个时候我们使用log4j将输出日志格式转换为 logback+slf4j
        * 此时需要使用 slf4j 提供的桥接器 log4j-over-slf4j 来实现
        * */

        /**
         * <!--SLF4J核心配置-->
         * <dependency>
         *   <groupId>org.slf4j</groupId>
         *   <artifactId>slf4j-api</artifactId>
         *   <version>1.7.29</version>
         * </dependency>
         *
         * <!--logback日志框架-->
         * <dependency>
         *   <groupId>ch.qos.logback</groupId>
         *   <artifactId>logback-classic</artifactId>
         *   <version>1.2.3</version>
         *   <scope>test</scope>
         * </dependency>
         *
         * <!--slf4j提供的log4j桥接器-->
         * <dependency>
         *   <groupId>org.slf4j</groupId>
         *   <artifactId>log4j-over-slf4j</artifactId>
         *   <version>1.7.25</version>
         * </dependency>
         */
        Logger logger = LogManager.getLogger(日志重构.class);
        logger.info("info信息");
    }
}
