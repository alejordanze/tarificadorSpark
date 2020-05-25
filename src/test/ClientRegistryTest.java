package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.*;

class ClientRegistryTest {

	@Test
	void getClientsTest() {
		Prepaid prepaid= new Prepaid(1.45);
		Client client = new Client(prepaid, 7777777);
		ClientRegistry clientRegistry = new ClientRegistry();
		List<Client> clients = new ArrayList<>();
		clients.add(client);
		clientRegistry.setClientes(clients);
		assertEquals(clients, clientRegistry.getClients());
	}

}
