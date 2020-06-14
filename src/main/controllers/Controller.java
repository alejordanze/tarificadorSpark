package main.controllers;

import static spark.Spark.*;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

//import org.json.JSONObject;
//
//import com.google.gson.Gson;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import main.Main;
import main.dataAccess.*;
import main.entities.*;
import main.interactor.CDRRegistry;
import main.interactor.GetCDRFromRepositoryBoundaryInputPort;
import main.interactor.GetCDRFromRepositoryInteractor;
import main.interactor.GetClientsFromRepositoryBoundaryInputPort;
import main.interactor.GetClientsFromRepositoryInteractor;

public abstract class Controller {
//	3	
//	static Repository<CDR> repository = new CDRFileRepository();
//	3
//	static Repository<Client> clientRepository = new ClientFileRepository();
//	2
//	static CDRRegistry CDRregister = new CDRRegistry(repository);
//	2
//	static ClientRegistry clientRegister = new ClientRegistry(clientRepository);
//	2
//	static CDRRegistry uploadCDRregister = new CDRRegistry(repository);
// 	1
//	static ClientRegistry uploadclientRegister = new ClientRegistry(clientRepository);
//	1
//	static String option = "Archivo";
//	1
//	static int numberCdr;
	final static Configuration conf = new Configuration(new Version(2, 3, 0));
	
	static GetClientsFromRepositoryBoundaryInputPort getClientsFromRepositoryBoundaryInputPort = new GetClientsFromRepositoryInteractor();
	static GetCDRFromRepositoryBoundaryInputPort getCDRFromRepositoryBoundaryInputPort = new GetCDRFromRepositoryInteractor();
	
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
