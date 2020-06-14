package main.services;

import java.util.Map;

import main.interactor.UploadCDR.UploadCDRBoundaryOutputPort;

public class UploadCDRPresenter implements UploadCDRBoundaryOutputPort{

	@Override
	public Map<String, Object> present(Map<String, Object> model) {
		return model;
	}
}
