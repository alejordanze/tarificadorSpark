package main.controllers;

import static spark.Spark.get;

import java.util.*;

import main.dataAccess.*;
import main.entities.CDR;

public class RegistryController extends Controller{
	
	static Repository repository2 = new CDRSqlRepository();
	static List<CDR> sqlList = repository2.getRegistry();
	
	public static void getMethod() {
		get("/registry", (request, response) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("cdrs", repository2.getRegistry());
			return getTemplate(model, "registry.ftl");
		});
		
	}
	
	public static void init() {
		getMethod();
	}
}
