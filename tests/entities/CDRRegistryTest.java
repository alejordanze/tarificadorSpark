package entities;

import static org.junit.Assert.*;
import static java.util.Arrays.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.*;

import org.junit.*;
import org.junit.jupiter.api.Test;

import main.*;
import main.application.gateways.Repository;
import main.dataAccess.FileRepository.CDRFileRepository;
import main.dataAccess.FileRepository.FileRepository;
import main.dataAccess.SQLRepository.CDRSqlRepository;
import main.dataAccess.SQLRepository.SqlRepository;
import main.domain.CDR;
import main.domain.CDRRegistry;
import main.domain.Client;
import main.domain.ClientRegistry;
import main.domain.FriendRegistry;
import main.domain.Fare.FareByHour;
import main.domain.Fare.NormalFare;
import main.domain.Plan.Plan;
import main.domain.Plan.Postpaid;
import main.domain.Plan.Prepaid;
import main.domain.Plan.Wow;

public class CDRRegistryTest {

	Repository<CDR> repository = new CDRFileRepository();
	private CDRRegistry reg = new CDRRegistry(repository);
	private Plan prepago = new Prepaid(new NormalFare(1.45), asList(new FareByHour(0.85, 2130, 2359)));
	private Plan postpago = new Postpaid(1);
	private Wow wow = new Wow(0.99);
	private CDR llamada = new CDR(8888888, 6666666, 2, 1830, new Date());
	private CDR llamada2 = new CDR(6666666, 7777777, 2, 2130, new Date());
	private CDR llamada3 = new CDR(8888888, 7777777, 12, 1534, new Date());
	private CDR llamada4 = new CDR(8888888, 6666666, 34, 1845, new Date());
	private CDR llamada5 = new CDR(8888888, 6666665, 34, 1925, new Date());
	
	private ClientRegistry clientsRegister = new ClientRegistry();
	private Client cliente = new Client(prepago, 7777777, "Ivy Rocabado");
	private Client cliente2 = new Client(postpago, 6666666, "Brayan Sejas");
	private Client cliente3 = new Client(wow, 8888888, "Saskia Sejas");

	FriendRegistry friendRegistry = FriendRegistry.getInstance();
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
		friendRegistry.setFriends(8888888, asList((long)6666666));
		Client cliente = new Client(prepago, 7777777, "Ivy Rocabado");
		Client cliente2 = new Client(postpago, 6666666, "Brayan Sejas");
		Client cliente3 = new Client(wow, 8888888, "Saskia Sejas");
		Repository<CDR> repository = new CDRFileRepository();
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
		friendRegistry.setFriends(8888888, asList((long)6666666));
		Client cliente = new Client(prepago, 7777777, "Ivy Rocabado");
		Client cliente2 = new Client(postpago, 6666666, "Brayan Sejas");
		Client cliente3 = new Client(wow, 8888888, "Saskia Sejas");
		Repository<CDR> repository = new CDRSqlRepository();
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
		friendRegistry.setFriends(8888888, asList((long)6666666));
		Client cliente = new Client(prepago, 7777777, "Ivy Rocabado");
		Client cliente2 = new Client(postpago, 6666666, "Brayan Sejas");
		Client cliente3 = new Client(wow, 8888888, "Saskia Sejas");
		Repository<CDR> repository = new CDRSqlRepository();
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
	void getAndSetRepositoryTest() throws IOException {
		friendRegistry.setFriends(8888888, asList((long)6666666));
		Client cliente = new Client(prepago, 7777777, "Ivy Rocabado");
		Client cliente2 = new Client(postpago, 6666666, "Brayan Sejas");
		Client cliente3 = new Client(wow, 8888888, "Saskia Sejas");
		Repository<CDR> repository = new CDRFileRepository();
		CDRRegistry CDRregister = new CDRRegistry();
		CDRregister.setRepository(repository);
		
		clientsRegister.addClient(cliente);
		clientsRegister.addClient(cliente2);
		clientsRegister.addClient(cliente3);
		
		List<CDR> list = addCallsToList();
		for(CDR cdr: list) {
			CDRregister.addCDR(cdr, clientsRegister);
		}
		CDRregister.saveRegistry();
		
		assertThat(CDRregister.getRegistry(), is(list));
		assertThat(CDRregister.getRepository(), is(repository));
	}
	
	
	@Test
	void testSqlGet() throws IOException {
		friendRegistry.setFriends(8888888, asList((long)6666666));
		Repository<CDR> repository = new CDRSqlRepository();
		CDRRegistry CDRregister = new CDRRegistry(repository);
		CDRregister.getCDRFromRepository();
		List<CDR> list = CDRregister.getRegistry();

		assertThat(CDRregister.getRegistry(), is(list));
	}
	
	@Test
	void testSorting() {
		Date date1 = new Date(Timestamp.valueOf("2020-06-04 03:55:44").getTime());
		Date date2 = new Date(Timestamp.valueOf("2020-06-05 05:40:32").getTime());
//		long originPhoneNumber, long destinationPhoneNumber, double duration, int hour, java.sql.Date date, double cost, Date dateAdded
		CDR llamada = new CDR(7777777, 6666666, 2, 1830, new java.sql.Date(new Date().getTime()), 3.0, new Date(Timestamp.valueOf("2020-06-04 03:55:44").getTime()));
		CDR llamada2 = new CDR(6666666, 7777777, 2, 2130, new java.sql.Date(new Date().getTime()), 5.0, new Date(Timestamp.valueOf("2020-06-05 05:40:32").getTime()));
		List<CDR> list = new ArrayList<CDR>();
		List<CDR> list2 = new ArrayList<CDR>();
		List<CDR> list3 = new ArrayList<CDR>();
		list.add(llamada);
		list2.add(llamada2);
		list3.add(llamada);
		list3.add(llamada2);
		Map<String, List<CDR>> map = new HashMap<>();
		map.put(date1.toString(), list2);
		map.put(date2.toString(), list);
		CDRSqlRepository repository = new CDRSqlRepository();
		assertTrue(repository.sortByDate(list3).containsValue(list));
	}
	
	
	@Test
	void FileRepositoryTest() {
		friendRegistry.setFriends(8888888, asList((long)6666666));

		CDR llamada = new CDR(8888888, 6666666, 5, 2230, new Date());
		Repository<CDR> repository = new CDRFileRepository();
		CDRRegistry CDRregister = new CDRRegistry(repository);
		CDRregister.getCDRFromRepository();
		List<CDR> list = CDRregister.getRegistry();

		assertThat(CDRregister.getRegistry(), is(list));
	}
	
//	@Test 
//	void testClientConsumption() {
//		Repository<CDR> repository = new CDRFileRepository();
//		Client cliente3 = new Client(wow, 8888888, "Saskia Sejas");
//		clientsRegister.addClient(cliente3);
//		CDRRegistry CDRregister = new CDRRegistry();
//		CDRregister.addCDR(llamada, clientsRegister);
//		CDRregister.addCDR(llamada, clientsRegister);
//		CDRregister.addCDR(llamada, clientsRegister);
//		CDRregister.addCDR(llamada, clientsRegister);
//		System.out.println(CDRregister.getClientConsumption((long)8888888).size());
////		assertTrue(CDRregister.getClientConsumption(8888888).get(0).containsKey("month"));
//		
//	}
//	

}
