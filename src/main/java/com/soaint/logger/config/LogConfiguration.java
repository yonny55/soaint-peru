package com.soaint.logger.config;

import static com.soaint.logger.constants.LoggerConstants.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.soaint.appender.SoaIntAppender;
import com.soaint.appender.impl.ConsoleSoaIntAppender;
import com.soaint.appender.impl.FileSoaIntAppender;
import com.soaint.appender.impl.JdbcSoaIntAppender;

public class LogConfiguration {
	private static Properties prop;
	private static SoaIntAppender appender = new ConsoleSoaIntAppender();
	private static String jdbcConfigFileName;
	
	static {
		InputStream is = null;
		
		try {
			prop = new Properties();
			is = LogConfiguration.class.getClassLoader().getResourceAsStream(CONFIG_LOG_FILE_NAME);
			prop.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SoaIntAppender getAppenderInstance() {
		final String appenderType = prop.getProperty(PROP_APPENDER_KEY);
		
		if (FILE_APPENDER.equalsIgnoreCase(appenderType)) {
			final String logFileName = prop.getProperty(PROP_FILE_KEY);
			appender = new FileSoaIntAppender(logFileName);
		} else if (JDBC_APPENDER.equalsIgnoreCase(appenderType)) {
			jdbcConfigFileName = prop.getProperty(PROP_JDBC_KEY);
			appender = new JdbcSoaIntAppender();
		}
		
		return appender;
	}
	
	public static String getJdbcConfigFileName() {
		return jdbcConfigFileName;
	}

	public static boolean enabledMessageLevel() {
		if (MESSAGE_LEVEL.equalsIgnoreCase(prop.getProperty(PROP_LEVEL_KEY))) {
			return true;
		}
		
		return false;
	}

	public static boolean enabledWarningLevel() {
		if (WARNING_LEVEL.equalsIgnoreCase(prop.getProperty(PROP_LEVEL_KEY))) {
			return true;
		}
		
		return false;
	}

	public static boolean enabledErrorLevel() {
		if (ERROR_LEVEL.equalsIgnoreCase(prop.getProperty(PROP_LEVEL_KEY))) {
			return true;
		}
		
		return false;
	}
}
