package main.dataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public interface SqlRepository<T> extends Repository<T>{
	int port = 8889;
	String user = "root";
	String password = "root";
	String database = "tarificador";

	public abstract void setStatement(PreparedStatement preparedStatement,T t);
	public abstract List<T> executeStatement(Statement statement);
	public abstract String setSecuence();

	public default void exportRegistry(List<T> registry) {
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
	
	default Connection openConnection() {
		Connection connect = null;
        String routeFileProperties = "src/main/resources/config.properties";
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + database, user, password);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return connect;
    }
	
	public default List<T> getRegistry() {
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
    
    default void closeConnection(Connection connect) {
    	try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
