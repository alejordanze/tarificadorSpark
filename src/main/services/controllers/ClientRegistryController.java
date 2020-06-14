package main.services.controllers;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import main.application.interactors.ClientRegistry.ClientRegistryBoundaryInputPort;
import main.application.interactors.ClientRegistry.ClientRegistryBoundaryOutputPort;
import main.application.interactors.ClientRegistry.ClientRegistryInteractor;
import main.dataAccess.*;
import main.domain.Client;
import main.domain.FriendRegistry;
import main.services.presenters.ClientRegistryPresenter;

public class ClientRegistryController extends Controller{
	
	static Repository<Client> repository2 = new ClientSqlRepository();
	static List<Client> sqlList = repository2.getRegistry();
	static ClientRegistryBoundaryOutputPort clientRegistryBoudaryOutputPort = new ClientRegistryPresenter();
	static ClientRegistryBoundaryInputPort clientRegistryBoudaryInputPort = new ClientRegistryInteractor(clientRegistryBoudaryOutputPort,clientRegister);
	public static void getMethod() {
		get("/clientRegistry", (request, response) -> {
			return getTemplate(clientRegistryBoudaryInputPort.execute(), "clientRegistry.ftl");
		});
		
	}
	
	public static void init() {
		getMethod();
	}
}
