package main.controllers;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationController extends Controller{

	public static Map<String, String> getOption(){
		Map<String, String> options = new HashMap<>();
		options.put("file","");
		options.put("sql","");
		if(option == "Archivo") {
			options.put("file","active");
		}
		else {
			options.put("sql","active");
		}
		return options;
	}
	
	public static void getMethod() {
		get("/configuration", (request, response) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("option", getOption());
			return getTemplate(model, "config.ftl");
		});
	}
	
	public static void postMethod() {
		post("configuration", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			option = req.queryParams("option");
			model.put("option", getOption());
			return getTemplate(model, "config.ftl");
		});
	}

	public static void init() {
		getMethod();
		postMethod();
	}
}
