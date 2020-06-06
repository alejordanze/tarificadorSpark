package main.controllers;

import static java.util.Arrays.asList;
import static spark.Spark.get;
import static spark.Spark.post;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import main.dataAccess.*;
import main.entities.CDR;
import main.entities.Client;
import main.entities.ClientRegistry;
import main.useCases.FareByHour;
import main.useCases.NormalFare;
import main.useCases.Plan;
import main.useCases.Postpaid;
import main.useCases.Prepaid;
import main.useCases.Wow;
import spark.utils.IOUtils;

public class UploadCDRController extends Controller {

	public static int uploadRegistry(String file) throws Exception  {
		
		FileRepository<CDR> fileRepo = new CDRFileRepository(file);
		uploadCDRregister.setRegistry(fileRepo.getRegistry(), clientRegister);
		return uploadCDRregister.getRegistry().size();
	}
	
	public static List<Client> getSampleClients(){
		Plan prepago = new Prepaid(new NormalFare(1.45), asList(new FareByHour(0.85, 2130, 2359)));
		Plan postpago = new Postpaid(1);
		Wow wow = new Wow(0.99);
		
		return asList(
				new Client(prepago, 7777777, "Ivy Rocabado"),
				new Client(postpago, 6666666, "Saskia Sejas"),
				new Client(wow, 8888888, "Naida Rocabado")
				);
	}
	
	public static void getMethod() {
		get("/upload", (req,res) -> {
			Map<String, Object> model = new HashMap<>();
			return getTemplate(model, "upload.ftl");
		});
	}

	public static void postMethod() {
		post("/upload", (req, response) -> {
			Map<String, Object> model = new HashMap<>();
			int size = 0;
			String path = "/Users/miguelalejandrojordan/";
			req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(path));
            Part filePart = req.raw().getPart("myfile");

            try (InputStream inputStream = filePart.getInputStream()) {
            	String fileName = path + filePart.getSubmittedFileName();
                OutputStream outputStream = new FileOutputStream(fileName);
                IOUtils.copy(inputStream, outputStream);
                outputStream.close();
                numberCdr = uploadRegistry(fileName);
            }
            model.put("quantity", numberCdr);
            model.put("type", "CDR's");
            model.put("redirect", "upload");
            return getTemplate(model, "uploadConfirm.ftl");
        });
	}

	public static void init() {
		getMethod();
		postMethod();
	}
	

}
