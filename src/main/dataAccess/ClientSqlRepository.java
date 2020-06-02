package main.dataAccess;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.entities.Client;

public class ClientSqlRepository implements SqlRepository<Client>{

	@Override
	public void setStatement(PreparedStatement preparedStatement, Client t) {	
		try {
			preparedStatement.setLong(1, t.getPhoneNumber());
			preparedStatement.setString(2, t.getFullName());
//			preparedStatement.setString(2, t.getPlan());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<Client> executeStatement(Statement statement) {
		List<Client> CDRList = new ArrayList<>();
		try {
			ResultSet rs = statement.executeQuery("SELECT * FROM CDR");
//			while (rs.next()) {
//			    int originPhoneNumber = rs.getInt("originPhoneNumber");
//			    int destinationPhoneNumber = rs.getInt("destinationPhoneNumber");
//			    double duration = rs.getDouble("duration");
//			    int hour = rs.getInt("hour");
//			    double cost = rs.getDouble("cost");
//			    Date date = rs.getDate("date");
//			    CDRList.add(new Client(originPhoneNumber, destinationPhoneNumber, duration, hour, date, cost));
//			    System.out.format("%s %s %s %s %s %s\n",originPhoneNumber, destinationPhoneNumber, duration, hour, cost, date);
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return CDRList;
	}

	

	@Override
	public String setSecuence() {
		return "insert into tarificador.Client values (?, ?, ?, ?)";
	}
}
