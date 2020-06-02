package main;
import static spark.Spark.*;

import static java.util.Arrays.asList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.CDRSqlRepository;
import main.dataAccess.FileRepository;
import main.dataAccess.Repository;
import main.dataAccess.SqlRepository;
import main.entities.CDR;
import main.entities.Client;
import main.entities.ClientRegistry;
import main.interactor.CDRRegistry;
import main.useCases.FareByHour;
import main.useCases.NormalFare;
import main.useCases.Plan;
import main.useCases.Postpaid;
import main.useCases.Prepaid;
import main.useCases.Wow;
import spark.Request;
import spark.Response;
import spark.Route;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.servlet.ServletException;
import spark.utils.IOUtils;

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
	
	public static void uploadRegistry(String file) throws Exception  {
		Repository repository = new CDRFileRepository();
		CDRRegistry CDRregister = new CDRRegistry(repository);
		ClientRegistry clientsRegister = new ClientRegistry();
		clientsRegister.setClientes(getSampleClients());

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
        try {
	        br = new BufferedReader(new FileReader(file));
	        while ((line = br.readLine()) != null) {
	            String[] cdrString = line.split(cvsSplitBy);
	            CDR cdr = new CDR();
	            cdr.setOriginPhoneNumbern(Long.valueOf(cdrString[0]));
	            cdr.setDestinationPhoneNumber(Long.valueOf(cdrString[1]));
	            cdr.setDate(formatter1.parse(cdrString[2]));
	            cdr.setDuration(Integer.parseInt(cdrString[3]));
				CDRregister.addCDR(cdr, clientsRegister);
	        }
			CDRregister.saveRegistry();
            br.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	public static List<Client> getSampleClients(){
		Plan prepago = new Prepaid(new NormalFare(1.45), asList(new FareByHour(0.85, 2130, 2359)));
		Plan postpago = new Postpaid(1);
		Wow wow = new Wow(0.99);
		
		return asList(
				new Client(prepago, 7777777, "Ivy Rocabado"),
				new Client(postpago, 6666666, "Brayan Sejas"),
				new Client(wow, 8888888, "Saskia Sejas")
				);
	}
	
	private static String export() {
		Repository repository = new CDRFileRepository();
		Repository repository2 = new CDRSqlRepository();
		ClientRegistry clientsRegister = new ClientRegistry();
		CDRRegistry CDRregister = new CDRRegistry(repository2);
		clientsRegister.setClientes(getSampleClients());
		List<CDR> list = getSampleCalls();
		
		for(CDR cdr: list) {
			CDRregister.addCDR(cdr, clientsRegister);
		}
		CDRregister.saveRegistry();
		
		return "<html>"
				+ "<head>"
				+ "<style>"
				+ "body,.buttom {background-color: powderblue;}"
				+ "h1,h3 {color: #00074e;}" 
				+ "label {color: black;}"
				+ ".box {background-color: #f1f1f1; padding: 20px; text-align: center;}"
				+ "</style>" 
				+ "</head>"
				+ "<body>"
				+ "<div class=\"box\">"
				+ "<h1>Tarificador</h1>"
				+ "</div>"
				+ "</br>"
				+ "<div class=\"box\">"
				+ "<label> Registro de la tarificacion de CDRS exportado exitosamente</label>"
				+ "</div>"
				+ "</body>"
				+ "</html>";
		}
	
	private static String home() {
		return "<html>"
				+ "<head>"
				+ "<style>"
				+ "body,.buttom {background-color: powderblue;}"
				+ "h1,h3 {color: #00074e;}" 
				+ "label {color: black;}"
				+ ".box {background-color: #f1f1f1; padding: 20px; text-align: center;}"
				+ "</style>" 
				+ "</head>"
				+ "<body>"
				+ "<div class=\"box\">"
				+ "<h1>Bienvenido a tarificador</h1>"
				+ "</div>"
				+"</br>"
				+ "<div class=\"box\">"
				+ "<form method='post' action='/welcome'>" 
				+ "<h3>Ingrese su nombre</h3>"
				+ "<label>Nombre:</label>"
				+ "<input type='text' name='name'>"
				+ "<input type='submit' value='Entrar' class=\"buttom\">"
				+ "</form>"
				+ "</div>"
				+ "</body>"
				+ "</html>";

	}
	
	private static String welcome(String name) {
		return "<html>"
				+ "<head>"
				+ "<style>"
				+ "body,.buttom {background-color: powderblue;}"
				+ "h1,h3 {color: #00074e;}" 
				+ "label {color: black;}"
				+ ".box {background-color: #f1f1f1; padding: 20px; text-align: center;}"
				+ "</style>" 
				+ "</head>"
				+ "<body>"
				+ "<div class=\"box\">"
				+ "<h1>Tarificador</h1>"
				+ "</div>"
				+ "</br>"
				+ "<div class=\"box\">"
				+ "<h1>Bienvenido "
				+ name
				+ "</h1>"
				+ "<h3>Presione el boton si desea realizar la tarificacion de CDRS</h3>"
				+ "<form method='post' action='/export'>" 
			    + "<button type='submit' class=\"buttom\">Realizar</button>"
				+ "</form>"
				+ "</div>"
				+ "</br>"
				+ "<div class=\"box\">"
				+ "<form method='post' action='/upload' enctype='multipart/form-data'>"
				+ "Cargar archivo de CDRs:<input type='file' name='myFile'>" 
				+ "<p>"
				+ "<input type='submit' value='Upload'>"
				+ "</form>"
				+ "</div>"
				+ "</body>"
				+ "</html>";

	}

	public static void main(String[] args) throws Exception   {
		get("/", (req, res) -> home());
		post("/welcome", (request, response)-> welcome(request.queryParams("name")));
		post("/export", (request, response) -> export());
		post("/upload", (request, response) -> {
			request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/tmp"));        	
        	Part uploadedFile = null;
			try {
				uploadedFile = request.raw().getPart("myFile");
//				uploadRegistry(uploadedFile.getSubmittedFileName());
			} catch (IOException | ServletException e) {
				e.printStackTrace();
			}
        	return "se cargo el archivo";
        });
	}
}
