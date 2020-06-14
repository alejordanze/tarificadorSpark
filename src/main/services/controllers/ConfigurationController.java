package main.services.controllers;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import main.dataAccess.*;
import main.dataAccess.FileRepository.CDRFileRepository;
import main.dataAccess.FileRepository.ClientFileRepository;
import main.dataAccess.SQLRepository.CDRSqlRepository;
import main.dataAccess.SQLRepository.ClientSqlRepository;

public class ConfigurationController extends Controller{

	static Map<String, String> options = new HashMap<>();
	
	public static Map<String, Object> getModel() {
		Map<String, Object> model = new HashMap<>();
		model.put("config", getOption());
		return model;
	}
	
	public static Map<String, String> getOption(){
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
	
	public static void setOption() {
		if(option.equals("Archivo")) {
			repository = new CDRFileRepository();
			clientRepository = new ClientFileRepository();
		}
		else {
			repository = new CDRSqlRepository();
			clientRepository = new ClientSqlRepository();
		}
		CDRregister.setRepository(repository);
		clientRegister.setRepository(clientRepository);
		clientRegister.getClientsFromRepository();
		CDRregister.getCDRFromRepository();
	}
	
	public static void getMethod() {
		get("/configuration", (request, response) -> {
			return getTemplate(getModel(), "config.ftl");
		});
	}
	
	public static void postMethod() {
		post("/configuration", (req, res) -> {
			option = req.queryParams("option");
			setOption();
			return getTemplate(getModel(), "config.ftl");
		});
	}

	public static void init() {
		getMethod();
		postMethod();
	}
}
