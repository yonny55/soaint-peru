package com.soaint.appender.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.soaint.appender.SoaIntAppender;
import static com.soaint.logger.constants.LoggerConstants.*;

public class FileSoaIntAppender implements SoaIntAppender  {
	private File logFile;
	
	public FileSoaIntAppender(String logFileName) {
		if (logFileName != null) {
			this.logFile = new File(logFileName);
		} else {
			this.logFile = new File(DEFAULT_LOG_FILE);
		}
	}

	@Override
	public void append(String text, String typeText) {
		BufferedWriter br = null;
		try {
			FileWriter fr = new FileWriter(logFile, true);
			br = new BufferedWriter(fr);
			br.write(new Date() + ": " + typeText + ": " + text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
