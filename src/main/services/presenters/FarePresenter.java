package main.services.presenters;

import java.util.HashMap;
import java.util.Map;

import main.application.interactors.Fare.FareBoundaryOutputPort;
import main.domain.CDRRegistry;

public class FarePresenter implements FareBoundaryOutputPort{

	@Override
	public Map<String, Object> present(CDRRegistry cdrRegistry,String option,boolean saved){
		Map<String, Object> model = new HashMap<>();
		model.put("cdrs", cdrRegistry);
		model.put("option", option);
		model.put("saved", saved);
		return model;
	}

}