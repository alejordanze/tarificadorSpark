package main.services;

import java.util.Map;

import main.interactor.ClientRegistryBoundaryOutputPort;

public class ClientRegistryPresenter implements ClientRegistryBoundaryOutputPort{

	@Override
	public Map<String, Object> present(Map<String, Object> model) {
		return model;
	}

}
