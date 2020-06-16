package main.services.presenters;

import java.util.List;

import main.application.interactors.ClientRegistry.ClientRegistryBoundaryOutputPort;
import main.application.models.responseModel.ResponseModel;
import main.domain.Client;
import main.domain.FriendRegistry;

public class ClientRegistryPresenter implements ClientRegistryBoundaryOutputPort{

	@Override
	public ResponseModel present(List<Client> clients , FriendRegistry friendList) {
		ResponseModel myRespose = new ResponseModel();
		myRespose.addInformation("clients", clients);
		myRespose.addInformation("friendList", friendList);
		return myRespose;
	}

}
