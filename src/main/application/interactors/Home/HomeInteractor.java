package main.application.interactors.Home;

import java.util.HashMap;
import java.util.Map;

import main.application.models.responseModel.ResponseModel;

public class HomeInteractor implements HomeBoundaryInputPort{

	HomeBoundaryOutputPort homeBoundaryOutputPort;
	
	public HomeInteractor(HomeBoundaryOutputPort homeBoundaryOutputPort) {
		this.homeBoundaryOutputPort=homeBoundaryOutputPort;
	}
	
	@Override
	public ResponseModel execute() {
		ResponseModel responseHomeBoundaryOutputPort = homeBoundaryOutputPort.present();
		return responseHomeBoundaryOutputPort;
	}
}
