package main;
import static spark.Spark.*;

import static java.util.Arrays.asList;
import java.io.*;
import java.util.*;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import freemarker.template.*;
import main.controllers.*;
import main.dataAccess.*;

import main.entities.*;

import main.interactor.CDRRegistry;
import main.useCases.*;
import spark.Request;
import spark.Response;
import spark.Route;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import spark.utils.IOUtils;

public class Main {
	
	static Repository repository = new SqlRepository();
	static CDRRegistry CDRregister = new CDRRegistry(repository);
	static String option = "Archivo";
	static int numberCdr;
	
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
		
		final Configuration conf = new Configuration(new Version(2, 3, 0));
		conf.setClassForTemplateLoading(Main.class, "/");
		
		get("/", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			return getTemplate(model, "index.ftl", conf);
		});
		
		UploadController.init();
		ConfigurationController.init();
		FareController.init();
		RegistryController.init();

	}
}
