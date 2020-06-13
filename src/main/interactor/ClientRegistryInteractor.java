package main.interactor;

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
		Map<String, Object> model = new HashMap<>();
		clientRegister.getClientsFromRepository();
		model.put("clients", clientRegister.getClients());
		model.put("friendList", FriendRegistry.getInstance());
		Map<String, Object> responseClientRegistryOutputport = clientRegistryOutputport.present(model);
		return responseClientRegistryOutputport;
	}

}
