package main.dataAccess;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.entities.CDR;

public class CDRSqlRepository extends SqlRepository<CDR>{

	public void setStatement(PreparedStatement preparedStatement, CDR t) {
		long timestamp = new java.util.Date().getTime();
		try {
			preparedStatement.setLong(1, t.getOriginPhoneNumber());
	        preparedStatement.setLong(2, t.getDestinationPhoneNumber());
	        preparedStatement.setDate(3, t.getSqlDate());
	        preparedStatement.setDouble(4, t.getDuration());
	        preparedStatement.setInt(5, t.getHour());
	        preparedStatement.setDouble(6, t.getCost());
	        preparedStatement.setTimestamp(7, new Timestamp(timestamp));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<CDR> executeStatement(Statement statement) {
		List<CDR> CDRList = new ArrayList<>();
		try {
			ResultSet rs = statement.executeQuery("SELECT * FROM CDR");
			Date aux;
			while (rs.next()) {
			    int originPhoneNumber = rs.getInt("originPhoneNumber");
			    int destinationPhoneNumber = rs.getInt("destinationPhoneNumber");
			    double duration = rs.getDouble("duration");
			    int hour = rs.getInt("hour");
			    double cost = rs.getDouble("cost");
			    Date date = rs.getDate("date");
			    Date addedDate = new Date(rs.getTimestamp("dateAdded").getTime());
			    CDRList.add(new CDR(originPhoneNumber, destinationPhoneNumber, duration, hour, date, cost, addedDate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
//		Map<java.util.Date, List<CDR>> map = sortByDate(CDRList);
//		 for (Map.Entry<java.util.Date, List<CDR>> entry : map.entrySet()) {
//			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//	        System.out.println(formatter.format(entry.getKey().getTime()));
//	        for(CDR cdr: entry.getValue()) {
//	        	System.out.println(cdr.getCost());
//	        }
//	    }
		return CDRList;
	}
	
	public Map<java.util.Date, List<CDR>> sortByDate(List<CDR> list){
		Map<java.util.Date, List<CDR>> map = new HashMap<>();
		for(CDR cdr: list) {
			List<CDR> auxList = new ArrayList<>();
			java.util.Date date = cdr.getDateAdded();
			
			for(CDR cdr2: list) {
				if(date.equals(cdr2.getDateAdded())) {
					auxList.add(cdr2);
				}
			}
			map.put(date, auxList);
		}
		return map;
	}

	@Override
	public String setSecuence() {
		return "insert into tarificador.CDR values (?, ?, ?, ?, ?, ?, ?)";
	}
}
