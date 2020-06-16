package main.application.interactors.GetClients;

import main.application.gateways.Repository;
import main.dataAccess.FileRepository.ClientFileRepository;
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
