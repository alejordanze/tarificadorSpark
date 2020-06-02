package main.dataAccess;

import main.entities.Client;

public class ClientFileRepository implements FileRepository<Client>{

	@Override
	public String headboardFile() {
		return "NroTelefono, NombreSuscriptor, Plan";
	}

	@Override
	public String nameFile() {
		return "Clientregister ";
	}

	@Override
	public String messageWrite(Client t) {
		return t.join();
	}
}
