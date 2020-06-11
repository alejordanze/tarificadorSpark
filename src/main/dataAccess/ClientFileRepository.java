package main.dataAccess;

import java.util.List;

import main.entities.CDR;
import main.entities.Client;
import main.entities.FriendRegistry;

public class ClientFileRepository extends FileRepository<Client>{
	FriendRegistry friendRegistry = FriendRegistry.getInstance();
	public ClientFileRepository(String file){
		this.fileName = file;
	}
	
	public ClientFileRepository() {
		this.fileName = "/Users/miguelalejandrojordan/Desktop/ClientRegister.csv";
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
		friendRegistry.setFriendsFromString(cdrString[0], cdrString[3]);
		if(cdrString.length == 4) {
			return new Client(Long.valueOf(cdrString[0]), cdrString[1], cdrString[2] ,cdrString[3]);
		}
		else {
			return new Client(Long.valueOf(cdrString[0]), cdrString[1], cdrString[2], "");
		}
	}
}
