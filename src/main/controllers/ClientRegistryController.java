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
import main.interactor.ClientRegistry.ClientRegistryBoundaryInputPort;
import main.interactor.ClientRegistry.ClientRegistryBoundaryOutputPort;
import main.interactor.ClientRegistry.ClientRegistryInteractor;
import main.services.ClientRegistryPresenter;

public class ClientRegistryController extends Controller{
	
	static Repository<Client> repository2 = new ClientSqlRepository();
	static List<Client> sqlList = repository2.getRegistry();
	static ClientRegistryBoundaryOutputPort clientRegistryBoudaryOutputPort = new ClientRegistryPresenter();
	static ClientRegistryBoundaryInputPort clientRegistryBoudaryInputPort = new ClientRegistryInteractor(clientRegistryBoudaryOutputPort);
	public static void getMethod() {
		get("/clientRegistry", (request, response) -> {
			return getTemplate(clientRegistryBoudaryInputPort.execute(), "clientRegistry.ftl");
		});
		
	}
	
	public static void init() {
		getMethod();
	}
}
