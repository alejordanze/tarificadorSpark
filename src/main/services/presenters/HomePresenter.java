package main.services.presenters;

import java.util.HashMap;
import java.util.Map;

import main.application.interactors.Home.HomeBoundaryOutputPort;

public class HomePresenter implements HomeBoundaryOutputPort{

	@Override
	public Map<String, Object> present() {
		Map<String, Object> model = new HashMap<>();
		return model;
	}

}
