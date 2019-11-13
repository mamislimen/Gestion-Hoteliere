package com.esprit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	public Client addClient(Client client) {
		return clientRepository.save(client);
	}
	
	public Client updateClient(int id , Client newClient) {
		if(clientRepository.findById(id).isPresent()) {
			Client exiClient = clientRepository.findById(id).get();
			if(newClient.getCin() != null ) {
				exiClient.setCin(newClient.getCin());
			}
			if(newClient.getNom() != null ) {
				exiClient.setNom(newClient.getNom());
			}
			if(newClient.getPrenom() != null ) {
				exiClient.setPrenom(newClient.getPrenom());
			}
			if(newClient.getTel() != null ) {
				exiClient.setTel(newClient.getTel());
			}
			if(newClient.getEmail() != null ) {
				exiClient.setEmail(newClient.getEmail());
			}
			if(newClient.getType() != null ) {
				exiClient.setType(newClient.getType());
			}
			return clientRepository.save(exiClient);
		}
		else return null;
	}
	
	public String deleteClient(int id) {
		if(clientRepository.findById(id).isPresent()) {
			clientRepository.deleteById(id);
			return "Client a été supprimé avec succée";
		}
		else return "Client est introubale";
	}

	
	public List<Client> ListClients() {
		return clientRepository.findAll();
	}
	
	public Optional<Client> ClientById(int id) {
		return clientRepository.findById(id);
	}
	
	public List<Client> ListClientsByType(String type) {
		return clientRepository.clientByType(type);
	}
	
	public Client ClientByCin(String cin) {
		return  clientRepository.clientByCin(cin);
	}

}
