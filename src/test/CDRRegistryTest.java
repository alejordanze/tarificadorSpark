package test;

import static org.junit.Assert.*;
import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;
import java.util.Date;
import java.util.*;

import org.junit.*;
import org.junit.jupiter.api.Test;

import main.*;
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

public class CDRRegistryTest {

	Repository repository = new CDRFileRepository();
	private CDRRegistry reg = new CDRRegistry(repository);
	private Plan prepago = new Prepaid(new NormalFare(1.45), asList(new FareByHour(0.85, 2130, 2359)));
	private Plan postpago = new Postpaid(1);
	private Wow wow = new Wow(0.99);
	private CDR llamada = new CDR(7777777, 6666666, 2, 1830, new Date());
	private CDR llamada2 = new CDR(6666666, 7777777, 2, 2130, new Date());
	private CDR llamada3 = new CDR(8888888, 7777777, 12, 1534, new Date());
	private CDR llamada4 = new CDR(8888888, 6666666, 34, 1845, new Date());
	private CDR llamada5 = new CDR(8888888, 6666665, 34, 1925, new Date());
	
	private ClientRegistry clientsRegister = new ClientRegistry();
	private Client cliente = new Client(prepago, 7777777, "Ivy Rocabado");
	private Client cliente2 = new Client(postpago, 6666666, "Brayan Sejas");
	private Client cliente3 = new Client(wow, 8888888, "Saskia Sejas");

	@Test
	public void testAddingCalls() throws IOException {
		clientsRegister.addClient(cliente);
		clientsRegister.addClient(cliente2);
		clientsRegister.addClient(cliente3);
		reg.addCDR(llamada, clientsRegister);
		reg.addCDR(llamada2, clientsRegister);
		reg.addCDR(llamada3, clientsRegister);
		reg.addCDR(llamada4, clientsRegister);
		reg.addCDR(llamada5, clientsRegister);
		reg.saveRegistry();
		assertThat(reg.getRegistry(), is(asList(llamada, llamada2, llamada3, llamada4, llamada5)));
	}
	
	@Test
	void initializeTest() {
		CDRRegistry CDRregister = new CDRRegistry();
		clientsRegister.addClient(cliente);
		clientsRegister.addClient(cliente2);
		clientsRegister.addClient(cliente3);
		CDRregister.setRegistry(asList(llamada, llamada2, llamada3, llamada4), clientsRegister);
		assertThat(CDRregister.getRegistry(), is(asList(llamada, llamada2, llamada3, llamada4)));
	}
	
	List<CDR> addCallsToList(){
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
	
	@Test
	void principalTest() throws IOException {
		wow.addFriend(6666666);
		Client cliente = new Client(prepago, 7777777, "Ivy Rocabado");
		Client cliente2 = new Client(postpago, 6666666, "Brayan Sejas");
		Client cliente3 = new Client(wow, 8888888, "Saskia Sejas");
		Repository repository = new CDRFileRepository();
		CDRRegistry CDRregister = new CDRRegistry(repository);
		
		clientsRegister.addClient(cliente);
		clientsRegister.addClient(cliente2);
		clientsRegister.addClient(cliente3);
		
		List<CDR> list = addCallsToList();
		for(CDR cdr: list) {
			CDRregister.addCDR(cdr, clientsRegister);
		}
		CDRregister.saveRegistry();
		
		assertThat(CDRregister.getRegistry(), is(list));
	}
	
	@Test
	void testSqlSave() throws IOException {
		wow.addFriend(6666666);
		Client cliente = new Client(prepago, 7777777, "Ivy Rocabado");
		Client cliente2 = new Client(postpago, 6666666, "Brayan Sejas");
		Client cliente3 = new Client(wow, 8888888, "Saskia Sejas");
		Repository repository = new CDRSqlRepository();
		CDRRegistry CDRregister = new CDRRegistry(repository);
		
		clientsRegister.addClient(cliente);
		clientsRegister.addClient(cliente2);
		clientsRegister.addClient(cliente3);
		
		List<CDR> list = addCallsToList();
		for(CDR cdr: list) {
			CDRregister.addCDR(cdr, clientsRegister);
		}
		CDRregister.saveRegistry();
		
		assertThat(CDRregister.getRegistry(), is(list));
	}
	
	@Test
	void testSqlSaveConstructor() throws IOException {
		wow.addFriend(6666666);
		Client cliente = new Client(prepago, 7777777, "Ivy Rocabado");
		Client cliente2 = new Client(postpago, 6666666, "Brayan Sejas");
		Client cliente3 = new Client(wow, 8888888, "Saskia Sejas");
		Repository repository = new CDRSqlRepository();
		CDRRegistry CDRregister = new CDRRegistry(repository);
		
		clientsRegister.addClient(cliente);
		clientsRegister.addClient(cliente2);
		clientsRegister.addClient(cliente3);
		
		List<CDR> list = addCallsToList();
		for(CDR cdr: list) {
			CDRregister.addCDR(cdr, clientsRegister);
		}
		CDRregister.saveRegistry();
		
		assertThat(CDRregister.getRegistry(), is(list));
	}

}
