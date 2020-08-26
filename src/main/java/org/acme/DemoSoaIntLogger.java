package org.acme;

import com.soaint.logger.SoaIntLogger;
import com.soaint.logger.impl.SoaIntLoggerImpl;

public class DemoSoaIntLogger {
	private static SoaIntLogger log = new SoaIntLoggerImpl();

	public void loggerUsage() {
		log.error("Este es un mensaje de error");
		
		log.message("Este es un mensaje de informacion");
		
		log.warning("Este es un mesnaje de advertencia");
	}
	
	public static void main(String args[]) {
		new DemoSoaIntLogger().loggerUsage();
	}
}
