package main.dataAccess;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.entities.CDR;

public class CDRSqlRepository implements SqlRepository<CDR>{

	public void setStatement(PreparedStatement preparedStatement, CDR t) {
		try {
			preparedStatement.setLong(1, t.getOriginPhoneNumber());
	        preparedStatement.setLong(2, t.getDestinationPhoneNumber());
	        preparedStatement.setDate(3, t.getSqlDate());
	        preparedStatement.setDouble(4, t.getDuration());
	        preparedStatement.setInt(5, t.getHour());
	        preparedStatement.setDouble(6, t.getCost());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<CDR> executeStatement(Statement statement) {
		List<CDR> CDRList = new ArrayList<>();
		try {
			ResultSet rs = statement.executeQuery("SELECT * FROM CDR");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return CDRList;
	}

	@Override
	public String setSecuence() {
		return "insert into tarificador.CDR values (?, ?, ?, ?, ?, ?)";
	}
}
