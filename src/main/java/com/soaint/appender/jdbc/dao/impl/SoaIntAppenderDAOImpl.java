package com.soaint.appender.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.soaint.appender.jdbc.ConnectionFactory;
import com.soaint.appender.jdbc.dao.SoaIntAppenderDAO;

public class SoaIntAppenderDAOImpl implements SoaIntAppenderDAO {
	
	@Override
	public void append(String text, String typeText) {
		Connection connection = null;
		PreparedStatement ptmt = null;
		
		try {
			String queryString = "INSERT INTO SOA_INT_LOGS(TEXT, TYPE_TEXT, LOG_DATE) VALUES(?,?,?)";
			connection = ConnectionFactory.getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, text);
			ptmt.setString(2, typeText);
			ptmt.setTimestamp(3, new Timestamp(new Date().getTime()));
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
