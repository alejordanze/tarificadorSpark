package main.controllers;

import static spark.Spark.get;
import static spark.Spark.post;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import main.dataAccess.*;
import main.entities.*;
import spark.utils.IOUtils;

public class UploadClientController extends Controller {
	
	public static int uploadRegistry(String file) throws Exception  {
		FileRepository<Client> fileRepo = new ClientFileRepository(file);
		List<Client> clients = new ArrayList<>();
		for(Client client: fileRepo.getRegistry()) {
//			if(verifyNumber(client.getPhoneNumber())) {
				clients.add(client);
//			}
		}
		uploadclientRegister.setClientes(clients);
		uploadclientRegister.saveRegistry();
		return uploadclientRegister.getClients().size();
	}
	
	public static boolean verifyNumber(long number) {
		return ((ClientSqlRepository) clientRepository).isPhoneAvailable(number);
	}
	
	public static void getMethod() {
		get("/uploadClient", (req,res) -> {
			Map<String, Object> model = new HashMap<>();
			return getTemplate(model, "uploadClient.ftl");
		});
	}
	
	public static void postMethod() {
		post("/uploadClient", (req, response) -> {
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
            model.put("type", "Clientes");
            model.put("redirect", "uploadClient");
            return getTemplate(model, "uploadConfirm.ftl");
        });
	}
	
	
	public static void init() {
		getMethod();
		postMethod();
	}

}
