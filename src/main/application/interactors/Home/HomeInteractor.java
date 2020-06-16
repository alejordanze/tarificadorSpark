package main.application.interactors.Home;

import java.io.StringWriter;
public class HomeInteractor implements HomeBoundaryInputPort{

	HomeBoundaryOutputPort homeBoundaryOutputPort;
	
	public HomeInteractor(HomeBoundaryOutputPort homeBoundaryOutputPort) {
		this.homeBoundaryOutputPort=homeBoundaryOutputPort;
	}
	
	@Override
	public StringWriter execute() {
		return homeBoundaryOutputPort.present();
	}
}
