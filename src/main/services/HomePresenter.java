package main.services;

import java.util.Map;

import main.interactor.HomeBoundaryOutputPort;

public class HomePresenter implements HomeBoundaryOutputPort{

	@Override
	public Map<String, Object> presentHome(Map<String, Object> model) {
		return model;
	}

}
