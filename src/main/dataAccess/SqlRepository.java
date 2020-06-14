package main.dataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class SqlRepository<T> implements Repository<T>{
	int port = 3306;
	String user = "root";
	String password = "";
	String database = "tarificador";
	Connection connect;
	
	public abstract void setStatement(PreparedStatement preparedStatement,T t);
	public abstract List<T> executeStatement(Statement statement);
	public abstract String setSecuence();

	public void exportRegistry(List<T> registry) {
		Connection connect = openConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connect
			        .prepareStatement(setSecuence());
			for(T t: registry) {
				setStatement(preparedStatement,t);
		        preparedStatement.executeUpdate();
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(connect);
	}
	
	public List<T> getRegistry() {
		List<T> list = new ArrayList<>();
		Connection connect = openConnection();
		try {
			Statement statement = connect.createStatement();
			list = executeStatement(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	Connection openConnection() {
		
        String routeFileProperties = "src/main/resources/config.properties";
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + database + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return connect;
    }
    
    void closeConnection(Connection connect) {
    	try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
