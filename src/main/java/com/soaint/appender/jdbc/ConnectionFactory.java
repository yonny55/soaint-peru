package com.soaint.appender.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.soaint.logger.config.LogConfiguration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private static HikariConfig hikariConfig;
	private static HikariDataSource hikariDataSource;
	private static boolean existsTable = false;
	private static final String tableName = "SOA_INT_LOGS";

	public static Connection getConnection() throws SQLException {
		if (hikariDataSource == null) {
			hikariConfig = new HikariConfig(LogConfiguration.getJdbcConfigFileName());
	        hikariDataSource = new HikariDataSource(hikariConfig);
	        
	        if (!existsTable) {
	        	createTable(hikariDataSource.getConnection());
	        }
		}
		
		return hikariDataSource.getConnection();
	}
	
	private static void createTable(Connection connection) {
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    
		try {
			rs = connection.getMetaData().getTables(null, null, tableName, new String[] {"TABLE"});
			  while (rs.next()) {
			     if (tableName.equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
			    	 existsTable = true;
			    	 break;
			     }
			  }	
			
			if (!existsTable) {
				final String CREATE_TABLE_SQL = "CREATE TABLE SOA_INT_LOGS (\n" + 
						"	LOG_ID INT NOT NULL AUTO_INCREMENT,\n" + 
						"	TEXT VARCHAR(250) NOT NULL,\n" + 
						"	TYPE_TEXT VARCHAR(30) NOT NULL,\n" + 
						"	LOG_DATE TIMESTAMP NOT NULL,\n" + 
						"	CONSTRAINT SOA_INT_LOGS PRIMARY KEY (LOG_ID)\n" + 
						");";
				
				stmt = connection.createStatement();
			    stmt.executeUpdate(CREATE_TABLE_SQL);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
		        if (stmt != null) {
		          stmt.close();
		        }
		        if (conn != null) {
		          conn.close();
		        }
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
		}
	}

	public static void closeConnections() {
		if (hikariDataSource != null) {
			hikariDataSource.close();
		}
	}
}
