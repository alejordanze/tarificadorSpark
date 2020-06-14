package main.interactor.ClientRegistry;

import java.util.HashMap;
import java.util.Map;

import main.dataAccess.ClientFileRepository;
import main.dataAccess.Repository;
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
	public Map<String, Object> execute() {
		clientRegister.getClientsFromRepository();
		Map<String, Object> responseClientRegistryOutputport = clientRegistryOutputport.present(clientRegister.getClients(),FriendRegistry.getInstance());
		return responseClientRegistryOutputport;
	}

}
