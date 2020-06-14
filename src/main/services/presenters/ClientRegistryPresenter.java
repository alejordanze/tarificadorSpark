package main.services.presenters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.application.interactors.ClientRegistry.ClientRegistryBoundaryOutputPort;
import main.domain.Client;
import main.domain.FriendRegistry;

public class ClientRegistryPresenter implements ClientRegistryBoundaryOutputPort{

	@Override
	public Map<String, Object> present(List<Client> clients , FriendRegistry friendList) {
		Map<String, Object> model = new HashMap<>();
		model.put("clients", clients);
		model.put("friendList", friendList);
		return model;
	}

}