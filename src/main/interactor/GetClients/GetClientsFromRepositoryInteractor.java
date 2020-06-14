package main.interactor.GetClients;

import main.dataAccess.ClientFileRepository;
import main.dataAccess.Repository;
import main.entities.Client;
import main.entities.ClientRegistry;

public class GetClientsFromRepositoryInteractor implements GetClientsFromRepositoryBoundaryInputPort{

	static Repository<Client> clientRepository = new ClientFileRepository();
	static ClientRegistry clientRegister = new ClientRegistry(clientRepository);

	public GetClientsFromRepositoryInteractor() {}
	@Override
	public void execute() {
		clientRegister.getClientsFromRepository();		
	}
}
