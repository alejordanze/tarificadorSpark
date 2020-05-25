package main;


import java.sql.*;
import java.util.List;

public class SqlRepository implements Repository{

	private Connection connect = null;
	private int port;
	private String user;
	private String password;
	private String database;
	
	public SqlRepository(){
		this.port = 8889;
		this.user = "root";
		this.password = "root";
		this.database = "tarificador";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		try {
			this.connect = DriverManager.getConnection("jdbc:mysql://localhost:" + this.port + "/" + database, this.user, this.password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public SqlRepository(int port, String database, String user, String password){
		this.port = port;
		this.user = user;
		this.password = password;
		this.database = database;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		try {
			this.connect = DriverManager.getConnection("jdbc:mysql://localhost:" + this.port + "/" + database, this.user, this.password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void exportRegistry(List<CDR> registry) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = this.connect
			        .prepareStatement("insert into tarificador.CDR values (?, ?, ?, ?, ?, ?)");
			
			for(CDR cdr: registry) {
				preparedStatement.setLong(1, cdr.getOriginPhoneNumber());
		        preparedStatement.setLong(2, cdr.getDestinationPhoneNumber());
		        preparedStatement.setDate(3, new java.sql.Date(10102020));
		        preparedStatement.setInt(4, cdr.getDuration());
		        preparedStatement.setInt(5, cdr.getHour());
		        preparedStatement.setDouble(6, cdr.getCost());
		        preparedStatement.executeUpdate();
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
