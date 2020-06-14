package main.dataAccess;

import java.util.List;

import domain.CDR;
import domain.Client;
import domain.FriendRegistry;

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
		String fullName = t.getFullName();
		long phoneNumber = t.getPhoneNumber();
		String plan = t.getPlan().getStringPlan();
		String friends = friendRegistry.getStringFriends(phoneNumber);
		return phoneNumber + ", " + fullName + ", " + plan + ", " + friends;
	}

	public Client getItem(String[] cdrString) {
		if(cdrString.length == 4) {
			friendRegistry.setFriendsFromString(cdrString[0], cdrString[3]);
			return new Client(Long.valueOf(cdrString[0]), cdrString[1], cdrString[2]);
		}
		else {
			return new Client(Long.valueOf(cdrString[0]), cdrString[1], cdrString[2]);
		}
	}
}
