package main.controllers;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import main.dataAccess.ClientSqlRepository;
import main.dataAccess.Repository;
import main.entities.Client;

public class HomeController extends Controller {

	public static void getMethod() {
		
		get("/", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			return getTemplate(model, "index.ftl");
		});
	}
	
	public static void init() {
		getMethod();
	}

}
