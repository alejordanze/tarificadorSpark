package main.dataAccess;

import java.util.List;

import main.entities.CDR;

public class CDRFileRepository extends FileRepository<CDR>{

	public CDRFileRepository(String file){
		this.fileName = file;
	}
	
	public CDRFileRepository() {
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
		return t.join();
	}

	@Override
	public CDR getItem(String[] cdrString) {
	    return new CDR(Long.valueOf(cdrString[0]), Long.valueOf(cdrString[1]), cdrString[2],cdrString[3], cdrString[4]);
	}
}
