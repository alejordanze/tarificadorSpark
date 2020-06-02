package main.dataAccess;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import main.entities.CDR;

public class CDRSqlRepository implements SqlRepository<CDR>{

	public void setStatement(PreparedStatement preparedStatement, CDR t) {
		try {
			preparedStatement.setLong(1, t.getOriginPhoneNumber());
	        preparedStatement.setLong(2, t.getDestinationPhoneNumber());
	        preparedStatement.setDate(3, new java.sql.Date(10102020));
	        preparedStatement.setInt(4, t.getDuration());
	        preparedStatement.setInt(5, t.getHour());
	        preparedStatement.setDouble(6, t.getCost());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String setSecuence() {
		return "insert into tarificador.CDR values (?, ?, ?, ?, ?, ?)";
	}
}
