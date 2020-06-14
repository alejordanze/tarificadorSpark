package main.interactor.Home;

import java.util.HashMap;
import java.util.Map;

public class HomeInteractor implements HomeBoundaryInputPort{

	HomeBoundaryOutputPort homeBoundaryOutputPort;
	
	public HomeInteractor(HomeBoundaryOutputPort homeBoundaryOutputPort) {
		this.homeBoundaryOutputPort=homeBoundaryOutputPort;
	}
	
	@Override
	public Map<String, Object> execute() {
		Map<String, Object> model = new HashMap<>();
		Map<String, Object> responseHomeBoundaryOutputPort = homeBoundaryOutputPort.present(model);
		return responseHomeBoundaryOutputPort;
	}
}
