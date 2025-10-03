package br.com.kaiomuniz.factories;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {


	private static final String HOST = "jdbc:postgresql://localhost:5432/bd_apiagenda";
	private static final String USER = "postgres";
	private static final String PASS = "kaio";
	private static final String DRIVER = "org.postgresql.Driver";


	public static Connection getConnection() throws Exception {
		Class.forName(DRIVER);
		return DriverManager.getConnection(HOST, USER, PASS);
	}
}
