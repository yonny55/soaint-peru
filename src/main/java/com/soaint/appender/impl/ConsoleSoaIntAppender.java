package com.soaint.appender.impl;

import java.util.Date;

import com.soaint.appender.SoaIntAppender;

public class ConsoleSoaIntAppender implements SoaIntAppender {

	@Override
	public void append(String text, String typeText) {
		System.out.println(new Date() + ": " + typeText + ": " + text);
	}

}
