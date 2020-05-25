package main;
import static spark.Spark.*;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	
	private static String export() {
		Repository repository = new FileRepository();
		Repository repository2 = new SqlRepository();
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
				+ "h1,h3 {color: blue;}" 
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
				+ "h1,h3 {color: blue;}" 
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
				+ "</form"
				+ "</div>"
				+ "</body>"
				+ "</html>";

	}
	
	private static String welcome(String name) {
		return "<html>"
				+ "<head>"
				+ "<style>"
				+ "body,.buttom {background-color: powderblue;}"
				+ "h1,h3 {color: blue;}" 
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
			    + "<button onclick=\"window.location.href='/export';\" class=\"buttom\">Realizar</button>"
				+ "</div>"
				+ "</body>"
				+ "</html>";

	}
	
	public static void main(String[] args) {
		get("/", (req, res) -> home());
		post("/welcome", (request, response)-> welcome(request.queryParams("name")));
		post("/export", (request, response) -> export());

	}
}
