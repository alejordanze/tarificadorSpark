package main.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Client;
import domain.FriendRegistry;
import main.interactor.ClientRegistry.ClientRegistryBoundaryOutputPort;

public class ClientRegistryPresenter implements ClientRegistryBoundaryOutputPort{

	@Override
	public Map<String, Object> present(List<Client> clients , FriendRegistry friendList) {
		Map<String, Object> model = new HashMap<>();
		model.put("clients", clients);
		model.put("friendList", friendList);
		return model;
	}

}
