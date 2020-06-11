package main.dataAccess;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import main.entities.CDR;

public class CDRFileRepository extends FileRepository<CDR>{

	public CDRFileRepository(String file){
		this.fileName = file;
	}
	
	public CDRFileRepository() {
		this.fileName = "/Users/miguelalejandrojordan/Desktop/CDRRegister.csv";
	}

	@Override
	public String headboardFile() {
		return "Origen, Destino, Fecha, Hora, Duración, Costo";
	}

	@Override
	public String nameFile() {
		return "CDRregister ";
	}

	@Override
	public String messageWrite(CDR t) {
		Long originPhoneNumber = t.getOriginPhoneNumber();
		long destinationPhoneNumber = t.getDestinationPhoneNumber();
        Date date = t.getSqlDate();
        double duration = t.getDuration();
        int hour = t.getHour();
        double cost = t.getCost();
		return originPhoneNumber + ", " + destinationPhoneNumber + ", \"" + date.toString() + "\", " + duration + ", " + hour + ", " + cost;
	}

	@Override
	public CDR getItem(String[] cdrString) {
		if(cdrString.length == 5) {
			return new CDR(Long.valueOf(cdrString[0]), Long.valueOf(cdrString[1]), cdrString[2],cdrString[3], cdrString[4]);
		}
		
	    return new CDR(Long.valueOf(cdrString[0]), Long.valueOf(cdrString[1]), Double.parseDouble(cdrString[3]),Integer.parseInt(cdrString[4]), java.sql.Date.valueOf(cdrString[2].substring(1, cdrString[2].length()-1)), Double.parseDouble(cdrString[5]), new Date(Timestamp.valueOf(cdrString[6].substring(1, cdrString[6].length()-1)).getTime()));
	}
}
