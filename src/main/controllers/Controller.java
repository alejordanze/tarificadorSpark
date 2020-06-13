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

public abstract class Controller {
	
	static Repository<CDR> repository = new CDRFileRepository();
//	1
//	static Repository<Client> clientRepository = new ClientFileRepository();
	static CDRRegistry CDRregister = new CDRRegistry(repository);
// 1
//	static ClientRegistry clientRegister = new ClientRegistry(clientRepository);
	static CDRRegistry uploadCDRregister = new CDRRegistry(repository);
	static ClientRegistry uploadclientRegister = new ClientRegistry(clientRepository);
	static String option = "Archivo";
	static int numberCdr;
	final static Configuration conf = new Configuration(new Version(2, 3, 0));
	
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

		clientRegister.getClientsFromRepository();
		CDRregister.getCDRFromRepository();	
	}

}
