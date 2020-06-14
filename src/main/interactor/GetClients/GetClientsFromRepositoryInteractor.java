package main.interactor.GetClients;

import main.dataAccess.ClientFileRepository;
import main.dataAccess.Repository;
import main.domain.Client;
import main.domain.ClientRegistry;

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
