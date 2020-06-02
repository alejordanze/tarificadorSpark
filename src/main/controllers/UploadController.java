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

public class UploadController extends Controller {

	public static int uploadRegistry(String file) throws Exception  {
		
		ClientRegistry clientsRegister = new ClientRegistry();
		clientsRegister.setClientes(getSampleClients());

        String line = "";
        String cvsSplitBy = ", ";
        SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");  
        BufferedReader br = new BufferedReader(new FileReader(file));
		line = br.readLine();
		numberCdr = 0;
		
		while((line = br.readLine()) != null) {
			numberCdr++;
            String[] cdrString = line.split(cvsSplitBy);
            CDR cdr = new CDR(Long.valueOf(cdrString[0]), Long.valueOf(cdrString[1]), cdrString[2],cdrString[3], cdrString[4]);
            System.out.println(cdr.join());
			CDRregister.addCDR(cdr, clientsRegister);
		}
		return CDRregister.getRegistry().size();
	}
	
	public static List<Client> getSampleClients(){
		Plan prepago = new Prepaid(new NormalFare(1.45), asList(new FareByHour(0.85, 2130, 2359)));
		Plan postpago = new Postpaid(1);
		Wow wow = new Wow(0.99);
		
		return asList(
				new Client(prepago, 7777777),
				new Client(postpago, 6666666),
				new Client(wow, 8888888)
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
			String path = "/Users/miguelalejandrojordan/Documents/";
			req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(path));
            Part filePart = req.raw().getPart("myfile");

            try (InputStream inputStream = filePart.getInputStream()) {
            	String fileName = path + filePart.getSubmittedFileName();
                OutputStream outputStream = new FileOutputStream(fileName);
                IOUtils.copy(inputStream, outputStream);
                outputStream.close();
                size = uploadRegistry(fileName);
            }
            model.put("length",size);
            model.put("quantity", numberCdr);
            return getTemplate(model, "uploadConfirm.ftl");
        });
	}

	public static void init() {
		getMethod();
		postMethod();
	}
	

}
