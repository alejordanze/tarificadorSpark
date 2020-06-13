package main.services;

import java.util.Map;

import main.interactor.FareExportBoundaryOutputPort;

public class FareExportPresenter implements FareExportBoundaryOutputPort{

	@Override
	public Map<String, Object> present(Map<String, Object> model) {
		return model;
	}

}
