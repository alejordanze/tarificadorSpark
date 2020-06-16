package main.application.interactors.Configuration;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationInteractor implements ConfigurationBoundaryInputPort{
	
	ConfigurationBoundaryOutputPort configBoundaryOutputPort;
	
	public ConfigurationInteractor(ConfigurationBoundaryOutputPort configBoundaryOutputPort){
		this.configBoundaryOutputPort = configBoundaryOutputPort;
	}
	
	@Override
	public StringWriter execute(String option) {
		return configBoundaryOutputPort.present(option);
		
	}

}
