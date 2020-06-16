package main.application.interactors.ConfigurationOption;

import main.application.gateways.Repository;
import main.dataAccess.FileRepository.CDRFileRepository;
import main.dataAccess.FileRepository.ClientFileRepository;
import main.dataAccess.SQLRepository.CDRSqlRepository;
import main.dataAccess.SQLRepository.ClientSqlRepository;
import main.domain.CDR;
import main.domain.CDRRegistry;
import main.domain.Client;
import main.domain.ClientRegistry;

public class ConfigurationOptionInteractor implements ConfigurationOptionBoundaryInputPort{

	Repository<CDR> repository;
	Repository<Client> clientRepository;
	CDRRegistry CDRregister;
	ClientRegistry clientRegister;
	CDRRegistry uploadCDRregister;
	ClientRegistry uploadclientRegister;
	
	public ConfigurationOptionInteractor(CDRRegistry CDRregister, ClientRegistry clientRegister, CDRRegistry uploadCDRregister, ClientRegistry uploadclientRegister){
		this.CDRregister = CDRregister;
		this.clientRegister = clientRegister;
		this.uploadCDRregister = uploadCDRregister;
		this.uploadclientRegister = uploadclientRegister;
	}
	
	@Override
	public void execute(String option) {
		
		if(option.equals("Archivo")) {
			repository = new CDRFileRepository();
			clientRepository = new ClientFileRepository();
		}
		else {
			repository = new CDRSqlRepository();
			clientRepository = new ClientSqlRepository();
		}
		CDRregister.setRepository(repository);
		clientRegister.setRepository(clientRepository);
		uploadCDRregister.setRepository(repository);
		uploadclientRegister.setRepository(clientRepository);
		clientRegister.getClientsFromRepository();
		CDRregister.getCDRFromRepository();
		
	}

}
