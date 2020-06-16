package main.application.interactors.ClientRegistry;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import main.application.gateways.Repository;
import main.application.models.responseModel.ResponseModel;
import main.dataAccess.FileRepository.ClientFileRepository;
import main.domain.Client;
import main.domain.ClientRegistry;
import main.domain.FriendRegistry;

public class ClientRegistryInteractor implements ClientRegistryBoundaryInputPort{

	
	ClientRegistryBoundaryOutputPort clientRegistryOutputport;
	ClientRegistry clientRegister;
	
	public ClientRegistryInteractor(ClientRegistryBoundaryOutputPort clientRegistryOutputport, ClientRegistry clientRegister) {
		this.clientRegistryOutputport = clientRegistryOutputport;
		this.clientRegister = clientRegister;
	}
	
	@Override
	public StringWriter execute() {
		clientRegister.getClientsFromRepository();
		return clientRegistryOutputport.present(clientRegister.getClients(),FriendRegistry.getInstance());
	}

}
