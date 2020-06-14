package main.interactor.ClientRegistry;

import java.util.HashMap;
import java.util.Map;

import main.dataAccess.ClientFileRepository;
import main.dataAccess.Repository;
import main.entities.Client;
import main.entities.ClientRegistry;
import main.entities.FriendRegistry;

public class ClientRegistryInteractor implements ClientRegistryBoundaryInputPort{

	
	static Repository<Client> clientRepository = new ClientFileRepository();
	static ClientRegistry clientRegister = new ClientRegistry(clientRepository);

	ClientRegistryBoundaryOutputPort clientRegistryOutputport;

	public ClientRegistryInteractor(ClientRegistryBoundaryOutputPort clientRegistryOutputport) {
		this.clientRegistryOutputport = clientRegistryOutputport;
	}
	
	@Override
	public Map<String, Object> execute() {
		clientRegister.getClientsFromRepository();
		Map<String, Object> responseClientRegistryOutputport = clientRegistryOutputport.present(clientRegister.getClients(),FriendRegistry.getInstance());
		return responseClientRegistryOutputport;
	}

}
