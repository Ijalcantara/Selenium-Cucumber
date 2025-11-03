package com.cheq.demo_webshop.utils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
* Utility class for obtaining Log4j loggers.
*/
public class LoggerUtil {
    /**
     * Returns a logger for the specified class.
     *
     * @param clazz the class for which the logger is required
     * @return the Logger instance for the given class
     */
    public static Logger getLogger(Class<?> clazz) {
    	// Get a logger instance for the given class name
        return LogManager.getLogger(clazz.getName());

    }
}

 