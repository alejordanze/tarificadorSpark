package main.controllers;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import main.dataAccess.*;
import main.entities.Client;
import main.entities.FriendRegistry;

public class ClientRegistryController extends Controller{
	
	static Repository<Client> repository2 = new ClientSqlRepository();
	static List<Client> sqlList = repository2.getRegistry();
	
	public static void getMethod() {
		get("/clientRegistry", (request, response) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("clients", clientRegister.getClients());
			model.put("friendList", FriendRegistry.getInstance());
			return getTemplate(model, "clientRegistry.ftl");
		});
		
	}
	
	public static void init() {
		getMethod();
	}
}
