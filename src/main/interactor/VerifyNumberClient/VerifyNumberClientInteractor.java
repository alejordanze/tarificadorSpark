package main.interactor.VerifyNumberClient;

import domain.Client;
import main.dataAccess.*;
 
public class VerifyNumberClientInteractor implements VerifyNumberClientBoundaryInputPort{
	
	Repository<Client> clientRepository;
	
	VerifyNumberClientBoundaryOutputPort verifyNumberClientBoundaryOutputPort;
	
	public VerifyNumberClientInteractor(VerifyNumberClientBoundaryOutputPort verifyNumberClientBoundaryOutputPort, Repository<Client> clientRepository) {
		this.verifyNumberClientBoundaryOutputPort = verifyNumberClientBoundaryOutputPort;
		this.clientRepository = clientRepository;
	}
	
	@Override
	public boolean execute(long number) {
		return verifyNumberClientBoundaryOutputPort.present(((ClientSqlRepository) clientRepository).isPhoneAvailable(number));
	}
}