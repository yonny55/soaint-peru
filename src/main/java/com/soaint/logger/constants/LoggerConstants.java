package com.soaint.logger.constants;

public class LoggerConstants {

	private LoggerConstants() {}
	
	// LOG LEVELS
	public static final String MESSAGE_LEVEL = "message";
	public static final String WARNING_LEVEL = "warning";
	public static final String ERROR_LEVEL = "error";
	
	// LOG CONFIGURATION KEYS
	public static final String PROP_APPENDER_KEY = "log.appender";
	public static final String PROP_FILE_KEY = "log.file";
	public static final String PROP_LEVEL_KEY = "log.level";
	public static final String PROP_JDBC_KEY = "log.jdbc";
	
	// LOG APPENDERS
	public static final String CONSOLE_APPENDER = "console";
	public static final String FILE_APPENDER = "file";
	public static final String JDBC_APPENDER = "jdbc";
	
	// DEFAULT LOG FILE
	public static final String DEFAULT_LOG_FILE = "soaIntLog.log";
	
	// CONFIGURATION LOG FILE NAME
	public static final String CONFIG_LOG_FILE_NAME = "log.config";
	
}
