package br.com.smarttecnologia.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String HOST = "jdbc:mysql://localhost:3306/bd_api_clientes?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() throws Exception {

        Class.forName(DRIVER);
        return DriverManager.getConnection(HOST, USER, PASSWORD);
	}

}
