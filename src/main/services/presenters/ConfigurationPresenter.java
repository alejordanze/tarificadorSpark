package main.services.presenters;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import main.application.interactors.Configuration.ConfigurationBoundaryOutputPort;
import main.application.models.responseModel.ResponseModel;

public class ConfigurationPresenter extends Presenter implements ConfigurationBoundaryOutputPort {
	
	Map<String, String> options = new HashMap<>();
	
	public Map<String, String> getOption(String option){
		if(option.equals("Archivo")) {
			options.put("file","active");
			options.put("sql","");
		}
		else {
			options.put("file","");
			options.put("sql","active");
		}
		return options;
	}
	
	@Override
	public StringWriter present(String option) {
		ResponseModel model = new ResponseModel();
		model.addInformation("config", getOption(option));
		return getTemplate(model, "config.ftl");
	}

}
