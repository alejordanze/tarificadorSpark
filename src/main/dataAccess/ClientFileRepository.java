package main.dataAccess;

import java.util.List;

import main.entities.CDR;
import main.entities.Client;

public class ClientFileRepository extends FileRepository<Client>{
	
	public ClientFileRepository(String file){
		this.fileName = file;
	}
	
	public ClientFileRepository() {
	}

	public String headboardFile() {
		return "NroTelefono, NombreSuscriptor, Plan";
	}

	public String nameFile() {
		return "Clientregister ";
	}

	public String messageWrite(Client t) {
		return t.join();
	}

	public Client getItem(String[] cdrString) {
		
		if(cdrString.length == 4) {
			return new Client(Long.valueOf(cdrString[0]), cdrString[1], cdrString[2] ,cdrString[3]);
		}
		else {
			return new Client(Long.valueOf(cdrString[0]), cdrString[1], cdrString[2], "");
		}
	}
}
