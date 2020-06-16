package entities;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;

import main.*;
import main.application.gateways.Repository;
import main.dataAccess.FileRepository.ClientFileRepository;
import main.dataAccess.SQLRepository.ClientSqlRepository;
import main.domain.Client;
import main.domain.ClientRegistry;
import main.domain.FriendRegistry;
import main.domain.Plan.Prepaid;

class ClientRegistryTest {

	private static final boolean False = false;

	@Test
	void getClientsFileTest() {
		Prepaid prepaid= new Prepaid(1.45);
		Client client = new Client(prepaid, 7777777, "Ivy Rocabado");
		Repository<Client> repository = new ClientFileRepository();
		ClientRegistry clientRegistry = new ClientRegistry(repository);
		List<Client> clients = new ArrayList<>();
		clients.add(client);
		clientRegistry.setClientes(clients);
		clientRegistry.saveRegistry();
		assertEquals(clients, clientRegistry.getClients());
		assertThat(clientRegistry.getClients(), is(clients));
	}
	
	@Test
	void getClientSqlTest() {
		Prepaid prepaid= new Prepaid(1.45);
		Client client = new Client(prepaid, 7777777, "Ivy Rocabado");
		Repository<Client> repository = new ClientSqlRepository();
		ClientRegistry clientRegistry = new ClientRegistry(repository);
		List<Client> clients = new ArrayList<>();
		clients.add(client);
		clientRegistry.setClientes(clients);
		clientRegistry.saveRegistry();
		assertEquals(clients, clientRegistry.getClients());
		assertThat(clientRegistry.getClients(), is(clients));
	}
	
	@Test
	void getAndSetRepositoryTest() {
		Repository<Client> repository = new ClientFileRepository();
		ClientRegistry clientRegistry = new ClientRegistry();
		clientRegistry.setRepository(repository);
		assertThat(clientRegistry.getRepository(), is(repository));

	}

	
	@Test
	void setRepositoryTest() {
		ClientRegistry clientRegistry = new ClientRegistry();
		Repository<Client> repository = new ClientSqlRepository();
		clientRegistry.setRepository(repository);
		assertEquals(repository, clientRegistry.getRepository());
	}
	
	@Test
	void getSqlList() {

		Repository<Client> repository = new ClientSqlRepository();
		ClientRegistry clientRegistry = new ClientRegistry(repository);
		clientRegistry.getClientsFromRepository();
		List<Client> clients = clientRegistry.getClients();
		assertThat(clientRegistry.getClients(), is(clients));
	}
	
	@Test
	void getPhoneAvailable() {
		ClientSqlRepository repository = new ClientSqlRepository();
		assertTrue(repository.isPhoneAvailable(89898989));
	}
	
	@Test
	void getPhoneAvailableFalse() {
		ClientSqlRepository repository = new ClientSqlRepository();
		assertFalse(repository.isPhoneAvailable(77777777));
	}
}
