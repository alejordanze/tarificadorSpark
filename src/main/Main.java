package main;
import static spark.Spark.*;

import static java.util.Arrays.asList;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

import domain.*;
import freemarker.template.*;
import main.controllers.*;
import main.dataAccess.CDRFileRepository;
import main.dataAccess.ClientFileRepository;
import main.dataAccess.Repository;

public class Main {

	static List<CDR> getSampleCalls(){
		List<CDR> callsList = new ArrayList<>();
		
		return callsList = asList(new CDR(7777777, 6666666, 2, 1830, new Date()),
		new CDR(7777777, 6666666, 5, 2230, new Date()),
		new CDR(8888888, 7777777, 4, 2030, new Date()),
		new CDR(6666666, 7777777, 5, 1400, new Date()),
		new CDR(8888888, 7777776, 10, 1630, new Date()),
		new CDR(7777777, 6666666, 15, 2335, new Date()),
		new CDR(7777777, 6666666, 2, 1530, new Date()),
		new CDR(8888888, 7777777, 4, 2030, new Date()),
		new CDR(6666666, 7777777, 5, 1400, new Date()),
		new CDR(8888888, 7777777, 10, 1630, new Date()),
		new CDR(8888888, 6666666, 7, 1130, new Date()),
		new CDR(7777777, 6666666, 2, 1730, new Date()),
		new CDR(8888888, 7777777, 8, 2030, new Date()),
		new CDR(6666666, 7777777, 9, 2130, new Date()),
		new CDR(8888888, 7777777, 12, 2330, new Date()) );
	}
	
	public static StringWriter getTemplate(Map<String, Object> model, String template, Configuration cfg) {
		StringWriter writer = new StringWriter();
        try {
            Template formTemplate = cfg.getTemplate("resources/" + template);

            formTemplate.process(model, writer);
        } catch (Exception e) {
            halt(500);
        }

        return writer;
	}

	public static void main(String[] args) throws Exception   {

		staticFiles.location("/resources");
		Controller.init();
		HomeController.init();
		UploadCDRController.init();
		ConfigurationController.init();
		FareController.init();
		RegistryController.init();
		UploadClientController.init();
		ClientRegistryController.init();
	}
}
