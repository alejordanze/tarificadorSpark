package main.interactor.Fare;

import java.util.HashMap;
import java.util.Map;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;
import main.entities.CDR;
import main.interactor.CDRRegistry;

public class FareInteractor implements FareBoundaryInputPort{

	FareBoundaryOutputPort fareBoundaryOutputPort;
	CDRRegistry uploadCDRregister;
	String option;
	
	public FareInteractor(FareBoundaryOutputPort fareBoundaryOutputPort, CDRRegistry uploadCDRregister,String option) {
		this.fareBoundaryOutputPort=fareBoundaryOutputPort;
		this.uploadCDRregister = uploadCDRregister;
		this.option = option;
	}
	
	@Override
	public Map<String, Object> execute(boolean saved) {
		Map<String, Object> responseFareBoundaryOutputPort = fareBoundaryOutputPort.present(uploadCDRregister,option,saved );
		return responseFareBoundaryOutputPort;
	}
}
