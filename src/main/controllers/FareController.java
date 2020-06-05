package main.controllers;

import static spark.Spark.get;
import static spark.Spark.post;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FareController extends Controller {

	private static void export() {
		CDRregister.saveRegistry();
	}
	
	private static Map<String, Object> getModel(boolean saved){
		Map<String, Object> model = new HashMap<>();
		model.put("cdrs", CDRregister);
		model.put("option", option);
		model.put("saved", saved);
		return model;
	}
	public static void getMethod() {
		get("/fare", (request, response) -> {
			
			return getTemplate(getModel(false), "export.ftl");
		});
	}
	
	public static void postMethod() {
		post("/fare", (request, response) -> {
			export();
			return getTemplate(getModel(true), "export.ftl");
		});
	}
	
	public static void init() {
		getMethod();
		postMethod();
	}
}
