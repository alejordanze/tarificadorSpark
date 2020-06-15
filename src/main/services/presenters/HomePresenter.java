package main.services.presenters;

import java.util.HashMap;
import java.util.Map;

import main.application.interactors.Home.HomeBoundaryOutputPort;
import main.application.models.responseModel.ResponseModel;

public class HomePresenter implements HomeBoundaryOutputPort{

	@Override
	public ResponseModel present() {
		ResponseModel model = new ResponseModel();
		return model;
	}

}
