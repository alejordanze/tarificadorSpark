package main.interactor.VerifyNumberClient;

import main.dataAccess.*;
import main.entities.Client;
 
public class VerifyNumberClientInteractor implements VerifyNumberClientBoundaryInputPort{

	static Repository<Client> clientRepository = new ClientFileRepository();
	
	VerifyNumberClientBoundaryOutputPort verifyNumberClientBoundaryOutputPort;
	
	public VerifyNumberClientInteractor(VerifyNumberClientBoundaryOutputPort verifyNumberClientBoundaryOutputPort) {
		this.verifyNumberClientBoundaryOutputPort = verifyNumberClientBoundaryOutputPort;
	}
	
	@Override
	public boolean execute(long number) {
		return verifyNumberClientBoundaryOutputPort.present(((ClientSqlRepository) clientRepository).isPhoneAvailable(number));
	}}

