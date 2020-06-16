package main.services.presenters;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import main.application.interactors.Fare.FareBoundaryOutputPort;
import main.application.models.responseModel.ResponseModel;
import main.domain.CDRRegistry;

public class FarePresenter extends Presenter implements FareBoundaryOutputPort{

	@Override
	public StringWriter present(CDRRegistry cdrRegistry, String option, boolean saved){
		ResponseModel model = new ResponseModel();
		model.addInformation("cdrs", cdrRegistry);
		model.addInformation("option", option);
		model.addInformation("saved", saved);
		return getTemplate(model, "export.ftl");
	}

}
