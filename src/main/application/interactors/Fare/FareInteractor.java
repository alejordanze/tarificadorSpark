package main.application.interactors.Fare;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import main.application.gateways.Repository;
import main.application.models.responseModel.ResponseModel;
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
	public StringWriter execute(boolean saved) {
		return fareBoundaryOutputPort.present(uploadCDRregister,option,saved );
	}
}
