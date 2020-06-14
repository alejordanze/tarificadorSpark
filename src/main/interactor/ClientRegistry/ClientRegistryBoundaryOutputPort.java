package main.interactor.ClientRegistry;

import java.util.List;
import java.util.Map;

import main.domain.Client;
import main.domain.FriendRegistry;

public interface ClientRegistryBoundaryOutputPort {
	public Map<String, Object> present(List<Client> clients , FriendRegistry friendList);
}
