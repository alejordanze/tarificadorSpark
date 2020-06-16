package interactors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.application.gateways.Repository;
import main.application.interactors.GetClients.GetClientsFromRepositoryBoundaryInputPort;
import main.application.interactors.GetClients.GetClientsFromRepositoryInteractor;
import main.dataAccess.SQLRepository.ClientSqlRepository;
import main.domain.Client;
import main.domain.ClientRegistry;

class GetClientTest {
	Repository<Client> repository = new ClientSqlRepository();
	ClientRegistry clientRegister = new ClientRegistry(repository);
	GetClientsFromRepositoryBoundaryInputPort getClientsFromRepositoryBoundaryInputPort = new GetClientsFromRepositoryInteractor(clientRegister);
	@Test
	void executeTest() {
		getClientsFromRepositoryBoundaryInputPort.execute();
		assertTrue(clientRegister.getClients().size()>0);
		
	}

}
