package main.dataAccess;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

	@Override
	public String setSecuence() {
		return "insert into tarificador.Client values (?, ?, ?, ?)";
	}
}
