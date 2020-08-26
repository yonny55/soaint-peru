package com.soaint.appender.impl;

import com.soaint.appender.SoaIntAppender;
import com.soaint.appender.jdbc.dao.SoaIntAppenderDAO;
import com.soaint.appender.jdbc.dao.impl.SoaIntAppenderDAOImpl;

public class JdbcSoaIntAppender implements SoaIntAppender {
	private SoaIntAppenderDAO dao;
	
	public JdbcSoaIntAppender() {
		dao = new SoaIntAppenderDAOImpl();
	}

	@Override
	public void append(String text, String typeText) {
		dao.append(text, typeText);
	}
	
}
