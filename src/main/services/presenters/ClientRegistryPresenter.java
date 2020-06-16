package main.services.presenters;

import java.io.StringWriter;
import java.util.List;

import main.application.interactors.ClientRegistry.ClientRegistryBoundaryOutputPort;
import main.application.models.responseModel.ResponseModel;
import main.domain.Client;
import main.domain.FriendRegistry;

public class ClientRegistryPresenter extends Presenter implements ClientRegistryBoundaryOutputPort{

	@Override
	public StringWriter present(List<Client> clients , FriendRegistry friendList) {
		ResponseModel myResponse = new ResponseModel();
		myResponse.addInformation("clients", clients);
		myResponse.addInformation("friendList", friendList);
		
		return getTemplate(myResponse, "clientRegistry.ftl");
	}

}
