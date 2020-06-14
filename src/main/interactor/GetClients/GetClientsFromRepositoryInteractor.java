package main.interactor.GetClients;

import main.dataAccess.ClientFileRepository;
import main.dataAccess.Repository;
import main.entities.Client;
import main.entities.ClientRegistry;

public class GetClientsFromRepositoryInteractor implements GetClientsFromRepositoryBoundaryInputPort{

	ClientRegistry clientRegister;
	public GetClientsFromRepositoryInteractor(ClientRegistry clientRegister) {
		this.clientRegister =clientRegister;
	}
	@Override
	public void execute() {
		clientRegister.getClientsFromRepository();		
	}
}
