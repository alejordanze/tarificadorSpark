package main.dataAccess;


import java.sql.*;
import java.util.List;


public interface SqlRepository<T> extends Repository<T>{

	int port = 8889;
	String user = "root";
	String password = "root";
	String database = "tarificador";

	public abstract void setStatement(PreparedStatement preparedStatement,T t);
	public abstract String setSecuence();

	public default void exportRegistry(List<T> registry) {
		Connection connect = null;
		openConnection(connect);
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
	
	default void openConnection(Connection connect) {
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
    }
    
    default void closeConnection(Connection connect) {
    	try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
