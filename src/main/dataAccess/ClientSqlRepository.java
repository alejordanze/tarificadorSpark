package main.dataAccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.entities.Client;

public class ClientSqlRepository extends SqlRepository<Client>{

	public void setStatement(PreparedStatement preparedStatement, Client t) {	
		try {
			preparedStatement.setLong(1, t.getPhoneNumber());
			preparedStatement.setString(2, t.getFullName());
			preparedStatement.setString(3, t.getPlan().getStringPlan());
			preparedStatement.setString(4, t.getPlan().getStringFriends());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Client> executeStatement(Statement statement) {
		List<Client> clientList = new ArrayList<>();
		try {
			ResultSet rs = statement.executeQuery("SELECT * FROM Client");
			while (rs.next()) {
			    Long number = rs.getLong("phoneNumber");
			    String fullName = rs.getString("fullName");
			    String plan = rs.getString("plan");
			    String friends = "["+ rs.getString("friends") + "]";
			    clientList.add(new Client(number, fullName, plan, friends));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return clientList;
	}
	
	public boolean isPhoneAvailable(long number) {
		Connection connect = openConnection();
		List<Client> clientList = new ArrayList<>();
		try {
			PreparedStatement statement = connect.prepareStatement("SELECT * FROM Client WHERE phoneNumber=?");
			statement.setLong(1, number);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
			    Long pnumber = rs.getLong("phoneNumber");
			    String fullName = rs.getString("fullName");
			    String plan = rs.getString("plan");
			    String friends = "["+ rs.getString("friends") + "]";
			    clientList.add(new Client(pnumber, fullName, plan, friends));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return clientList.isEmpty();
	}

	@Override
	public String setSecuence() {
		return "insert into tarificador.Client values (?, ?, ?, ?)";
	}
}
