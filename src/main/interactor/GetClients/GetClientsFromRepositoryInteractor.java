package main.interactor.GetClients;

import domain.Client;
import domain.ClientRegistry;
import main.dataAccess.ClientFileRepository;
import main.dataAccess.Repository;

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
