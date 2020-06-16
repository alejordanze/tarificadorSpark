package main.services.controllers;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import main.application.interactors.Configuration.ConfigurationBoundaryInputPort;
import main.application.interactors.Configuration.ConfigurationBoundaryOutputPort;
import main.application.interactors.Configuration.ConfigurationInteractor;
import main.application.interactors.ConfigurationOption.ConfigurationOptionBoundaryInputPort;
import main.application.interactors.ConfigurationOption.ConfigurationOptionInteractor;
import main.application.models.responseModel.ResponseModel;
import main.services.presenters.ConfigurationPresenter;

public class ConfigurationController extends Controller{

	static ConfigurationOptionBoundaryInputPort configOptionBoundaryInputPort = new ConfigurationOptionInteractor(CDRregister,clientRegister,uploadCDRregister, uploadclientRegister);
	static ConfigurationBoundaryOutputPort configBoundaryOutputPort = new ConfigurationPresenter();
	static ConfigurationBoundaryInputPort configBoundaryInputPort = new ConfigurationInteractor(configBoundaryOutputPort);
	static Map<String, String> options = new HashMap<>();
	
	
	public static void setOption() {
		configOptionBoundaryInputPort.execute(option);
	}
	
	public static void getMethod() {
		get("/configuration", (request, response) -> {
			return configBoundaryInputPort.execute(option);
		});
	}
	
	public static void postMethod() {
		post("/configuration", (req, res) -> {
			option = req.queryParams("option");
			setOption();
			return configBoundaryInputPort.execute(option);
		});
	}

	public static void init() {
		getMethod();
		postMethod();
	}
}
