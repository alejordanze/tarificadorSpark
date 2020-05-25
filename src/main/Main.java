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
		
		return "<label> Registro de la tarificacion de CDRS exportado exitosamente</label>";
	}
	
	private static String home() {
		return "<html>"
				+ "<body>"
				+ "<form method='post' action='/welcome'>" 
				+ "<h1>Bienvenido a tarificador</h1>"
				+ "<h3>Ingrese su nombre</h3>"
				+ "<label>Nombre:</label>"
				+ "<input type='text' name='name'>"
				+ "<input type='submit' value='Entrar'>"
				+ "</form"
				+ "</body>"
				+ "</html>";

	}
	
	private static String welcome(String name) {
		return "<h1>Bienvenido "
				+ name
				+ "</h1>"
				+ "<h3>Presione el boton si desea realizar la tarificacion de CDRS</h3>"
			    + "<button onclick=\"window.location.href='/export';\">Realizar</button>";

	}
	
	public static void main(String[] args) {
		get("/", (req, res) -> home());
		post("/welcome", (request, response)-> welcome(request.queryParams("name")));
		post("/export", (request, response) -> export());

	}
}
