package main.controllers;

import static spark.Spark.*;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import main.Main;
import main.dataAccess.Repository;
import main.dataAccess.SqlRepository;
import main.interactor.CDRRegistry;

public abstract class Controller {
	
	static Repository repository = new SqlRepository();
	static CDRRegistry CDRregister = new CDRRegistry(repository);
	static String option = "Archivo";
	static int numberCdr;
	final static Configuration conf = new Configuration(new Version(2, 3, 0));
//	
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
	
	public static void getMethod() {
	}
	
	public static void postMethod() {
	}
	
	public static void init() {
		
	}

}