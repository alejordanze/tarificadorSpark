package main.application.interactors.Fare;

import java.util.HashMap;
import java.util.Map;

import main.application.gateway.Repository;
import main.dataAccess.FileRepository.CDRFileRepository;
import main.domain.CDR;
import main.domain.CDRRegistry;

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
