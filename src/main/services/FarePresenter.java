package main.services;

import java.util.Map;

import main.interactor.FareBoundaryOutputPort;

public class FarePresenter implements FareBoundaryOutputPort{

	@Override
	public Map<String, Object> present(Map<String, Object> model) {
		return model;
	}

}
