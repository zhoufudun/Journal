package com.yunbocheng;

import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {
    @Override
    public int decide(LoggingEvent event) {
        return 0;
    }
}
