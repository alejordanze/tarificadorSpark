package main.interactor.Fare;

import java.util.HashMap;
import java.util.Map;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;
import main.entities.CDR;
import main.interactor.CDRRegistry;

public class FareInteractor implements FareBoundaryInputPort{

	static Repository<CDR> repository = new CDRFileRepository();
	static CDRRegistry uploadCDRregister = new CDRRegistry(repository);
	static String option = "Archivo";

	FareBoundaryOutputPort fareBoundaryOutputPort;
	public FareInteractor(FareBoundaryOutputPort fareBoundaryOutputPort) {
		this.fareBoundaryOutputPort=fareBoundaryOutputPort;
	}
	
	@Override
	public Map<String, Object> execute(boolean saved) {
		Map<String, Object> responseFareBoundaryOutputPort = fareBoundaryOutputPort.present(uploadCDRregister,option,saved );
		return responseFareBoundaryOutputPort;
	}
}
