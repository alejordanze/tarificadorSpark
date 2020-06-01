package main.dataAccess;


import java.sql.*;
import java.util.List;

import main.entities.CDR;

public interface SqlRepository<T> extends Repository<T>{

	private Connection connect = null;
	private int port;
	private String user;
	private String password;
	private String database;
	
//	default public SqlRepository(){
//		this.port = 8889;
//		this.user = "root";
//		this.password = "root";
//		this.database = "tarificador";
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}  
//		try {
//			this.connect = DriverManager.getConnection("jdbc:mysql://localhost:" + this.port + "/" + database, this.user, this.password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	
//	}
//	
//	default public SqlRepository(int port, String database, String user, String password){
//		this.port = port;
//		this.user = user;
//		this.password = password;
//		this.database = database;
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}  
//		try {
//			this.connect = DriverManager.getConnection("jdbc:mysql://localhost:" + this.port + "/" + database, this.user, this.password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	
//	}

	public void exportRegistry(List<T> registry);

}
