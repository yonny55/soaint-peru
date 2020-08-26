package com.soaint.logger.impl;

import com.soaint.appender.SoaIntAppender;
import com.soaint.logger.SoaIntLogger;
import com.soaint.logger.config.LogConfiguration;
import static com.soaint.logger.constants.LoggerConstants.*;

public class SoaIntLoggerImpl implements SoaIntLogger {
	private SoaIntAppender logAppender;

	public SoaIntLoggerImpl() {
		this.logAppender = LogConfiguration.getAppenderInstance();
	}

	@Override
	public void message(String text) {
		if (LogConfiguration.enabledMessageLevel()) {
			logAppender.append(text, MESSAGE_LEVEL);
		}
	}

	@Override
	public void warning(String text) {
		if (LogConfiguration.enabledMessageLevel() || LogConfiguration.enabledWarningLevel()) {
			logAppender.append(text, WARNING_LEVEL);
		}
	}

	@Override
	public void error(String text) {
		if (LogConfiguration.enabledMessageLevel() || LogConfiguration.enabledWarningLevel()
				|| LogConfiguration.enabledErrorLevel()) {
			logAppender.append(text, ERROR_LEVEL);
		}
	}

}
