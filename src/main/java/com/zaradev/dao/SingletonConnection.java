package com.zaradev.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	
	private static Connection connection;
	
	/*
	 * pour creer l'objet connection une seule fois 
	 * il faut la mettre dans le bloc static
	 */
	static {	
		try {
			// charger le pilote JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");
			// creer la connexion
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_CATALOGUE_PRODUITS", "root", "");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
