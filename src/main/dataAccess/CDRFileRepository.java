package main.dataAccess;

import main.entities.CDR;

public class CDRFileRepository implements FileRepository<CDR>{

	@Override
	public String headboardFile() {
		return "Origen, Destino, Duracion, Hora, Fecha, Costo";
	}

	@Override
	public String nameFile() {
		return "CDRregister ";
	}

	@Override
	public String messageWrite(CDR t) {
		return t.join();
	}
}
