package main.services.controllers;

import static spark.Spark.*;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import main.domain.*;

//import org.json.JSONObject;
//
//import com.google.gson.Gson;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import main.Main;
import main.application.interactors.GetCDRFromRepository.GetCDRFromRepositoryBoundaryInputPort;
import main.application.interactors.GetCDRFromRepository.GetCDRFromRepositoryInteractor;
import main.application.interactors.GetClients.GetClientsFromRepositoryBoundaryInputPort;
import main.application.interactors.GetClients.GetClientsFromRepositoryInteractor;
import main.dataAccess.*;
import main.domain.CDR;
import main.domain.CDRRegistry;
import main.domain.Client;
import main.domain.ClientRegistry;

public abstract class Controller {
//	5
	static Repository<CDR> repository = new CDRFileRepository();
//	6
	static Repository<Client> clientRepository = new ClientFileRepository();
//	3
	static CDRRegistry CDRregister = new CDRRegistry(repository);
//	3
	static ClientRegistry clientRegister = new ClientRegistry(clientRepository);
//	3
	static CDRRegistry uploadCDRregister = new CDRRegistry(repository);
// 	2
	static ClientRegistry uploadclientRegister = new ClientRegistry(clientRepository);
//	1
	static String option = "Archivo";
//	2
	static int numberCdr;
	final static Configuration conf = new Configuration(new Version(2, 3, 0));
	
	static GetClientsFromRepositoryBoundaryInputPort getClientsFromRepositoryBoundaryInputPort = new GetClientsFromRepositoryInteractor(clientRegister);
	static GetCDRFromRepositoryBoundaryInputPort getCDRFromRepositoryBoundaryInputPort = new GetCDRFromRepositoryInteractor(CDRregister);
	
	public static StringWriter getTemplate(Map<String, Object> model, String template) {
		conf.setClassForTemplateLoading(Main.class, "/");
		
		StringWriter writer = new StringWriter();
		
        try {
            Template formTemplate = conf.getTemplate("resources/" + template);

            formTemplate.process(model, writer);
        } catch (Exception e) {
            halt(500);
        }

        return writer;
	}

	
	public static void postMethod() {}
	
	public static void init() {
		getClientsFromRepositoryBoundaryInputPort.execute();
		getCDRFromRepositoryBoundaryInputPort.execute();
	}

}
