package entities;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.*;
import main.application.gateway.Repository;
import main.dataAccess.FileRepository.ClientFileRepository;
import main.dataAccess.SQLRepository.ClientSqlRepository;
import main.domain.Client;
import main.domain.ClientRegistry;
import main.domain.Prepaid;

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
