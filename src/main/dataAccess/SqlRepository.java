package main.dataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import main.entities.CDR;

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
			Class.forName("com.mysql.cj.jdbc.Driver");
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
			Class.forName("com.mysql.cj.jdbc.Driver");
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
		        preparedStatement.setDate(3, cdr.getSqlDate());
		        preparedStatement.setDouble(4, cdr.getDuration());
		        preparedStatement.setInt(5, cdr.getHour());
		        preparedStatement.setDouble(6, cdr.getCost());
		        preparedStatement.executeUpdate();
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<CDR> getRegistry() {
		List<CDR> CDRList = new ArrayList<>();
		try {
			Statement statement = this.connect.createStatement();
			ResultSet rs = 	statement.executeQuery("SELECT * FROM CDR");
			
			while (rs.next()) {
		        int originPhoneNumber = rs.getInt("originPhoneNumber");
		        int destinationPhoneNumber = rs.getInt("destinationPhoneNumber");
		        double duration = rs.getDouble("duration");
		        int hour = rs.getInt("hour");
		        double cost = rs.getDouble("cost");
		        Date date = rs.getDate("date");
		        CDRList.add(new CDR(originPhoneNumber, destinationPhoneNumber, duration, hour, date, cost));
		        System.out.format("%s %s %s %s %s %s\n",originPhoneNumber, destinationPhoneNumber, duration, hour, cost, date);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CDRList;
	}
}
