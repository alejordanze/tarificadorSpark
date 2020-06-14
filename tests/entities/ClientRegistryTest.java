package entities;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Client;
import domain.ClientRegistry;
import domain.Prepaid;
import main.*;
import main.dataAccess.ClientFileRepository;
import main.dataAccess.ClientSqlRepository;
import main.dataAccess.Repository;

class ClientRegistryTest {

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

}
