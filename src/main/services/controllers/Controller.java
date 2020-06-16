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
import main.application.gateways.Repository;
import main.application.interactors.GetCDRFromRepository.GetCDRFromRepositoryBoundaryInputPort;
import main.application.interactors.GetCDRFromRepository.GetCDRFromRepositoryInteractor;
import main.application.interactors.GetClients.GetClientsFromRepositoryBoundaryInputPort;
import main.application.interactors.GetClients.GetClientsFromRepositoryInteractor;
import main.application.models.responseModel.ResponseModel;
import main.dataAccess.*;
import main.dataAccess.FileRepository.CDRFileRepository;
import main.dataAccess.FileRepository.ClientFileRepository;
import main.domain.CDR;
import main.domain.CDRRegistry;
import main.domain.Client;
import main.domain.ClientRegistry;

public abstract class Controller {
	static Repository<CDR> repository = new CDRFileRepository();
	static Repository<Client> clientRepository = new ClientFileRepository();
	static CDRRegistry CDRregister = new CDRRegistry(repository);
	static ClientRegistry clientRegister = new ClientRegistry(clientRepository);
	static CDRRegistry uploadCDRregister = new CDRRegistry(repository);
	static ClientRegistry uploadclientRegister = new ClientRegistry(clientRepository);
	static String option = "Archivo";
	static int numberCdr;
	final static Configuration conf = new Configuration(new Version(2, 3, 0));
	
	static GetClientsFromRepositoryBoundaryInputPort getClientsFromRepositoryBoundaryInputPort = new GetClientsFromRepositoryInteractor(clientRegister);
	static GetCDRFromRepositoryBoundaryInputPort getCDRFromRepositoryBoundaryInputPort = new GetCDRFromRepositoryInteractor(CDRregister);
	
	public static StringWriter getTemplate(ResponseModel model, String template) {
		conf.setClassForTemplateLoading(Main.class, "/");
		
		StringWriter writer = new StringWriter();
		
        try {
            Template formTemplate = conf.getTemplate("resources/" + template);

            formTemplate.process(model.getResponse(), writer);
        } catch (Exception e) {
            halt(500);
        }

        return writer;
	}

	
	public static void postMethod() {}
	
	public static void run() {
		getClientsFromRepositoryBoundaryInputPort.execute();
		getCDRFromRepositoryBoundaryInputPort.execute();
		HomeController.init();
		UploadCDRController.init();
		ConfigurationController.init();
		FareController.init();
		RegistryController.init();
		UploadClientController.init();
		ClientRegistryController.init();
		
	}

}
