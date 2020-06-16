package main.application.interactors.ClientRegistry;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import main.application.models.responseModel.ResponseModel;
import main.domain.Client;
import main.domain.FriendRegistry;

public interface ClientRegistryBoundaryOutputPort {
	public StringWriter present(List<Client> clients , FriendRegistry friendList);
}
