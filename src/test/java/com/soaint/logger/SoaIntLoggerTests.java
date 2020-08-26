package com.soaint.logger;

import org.junit.Test;

import com.soaint.logger.impl.SoaIntLoggerImpl;

public class SoaIntLoggerTests {
	private static SoaIntLogger log = new SoaIntLoggerImpl();

	@Test
	public void logToJdbc() {
		log.error("Este es un mensaje de error");
		
		log.message("Este es un mensaje de informacion");
		
		log.warning("Este es un mesnaje de advertencia");
	}
}
