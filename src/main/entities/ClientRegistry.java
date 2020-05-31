package main.entities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClientRegistry{

	public List<Client> clients = new ArrayList<>();

	

	public List<Client> getClients() {
		return clients;
	}

	public void setClientes(List<Client> clients) {
		this.clients = clients;
	}
	
	public Client getClientByNumber(Long phoneNumber) {
		Client client = null;
		for(Client user: clients) {
			if(user.isSamePhoneNumber(phoneNumber)) {
				client = user;
			}
		}
		return client;
	}
	
	public void addClient(Client client) {
		this.clients.add(client);
	}
	
	public ClientRegistry() {}
}
