package main.services;

import java.util.Map;

import main.interactor.UploadClient.UploadClientBoundaryOutputPort;

public class UploadClientPresenter implements UploadClientBoundaryOutputPort{

	@Override
	public Map<String, Object> present(Map<String, Object> model) {
		return model;
	}

}
