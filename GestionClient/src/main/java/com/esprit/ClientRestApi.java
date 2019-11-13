package com.esprit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")

public class ClientRestApi {
	
	@Autowired
	private ClientService clientService;
	

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public List<Client> listClients(){
		return clientService.ListClients();
	}
	
	//@GetMapping("/cin/{param:[0-9]+}")
	@RequestMapping(value="/cin/{param:[0-9]+}",method=RequestMethod.GET)
	//@ResponseStatus(HttpStatus.OK)
	public Client getClientByCin(@PathVariable(value="param") String cin) {
		return clientService.ClientByCin(cin);
	}
	
	
	@RequestMapping(value="/{param:[0-9]+}",method=RequestMethod.GET)
	public Optional<Client> getClientById(@PathVariable("param") int id) {
		return clientService.ClientById(id);
	}
	
	@RequestMapping(value="/type/{type:[A-Za-z]+}",method=RequestMethod.GET)
	public List<Client> getClientBytype(@PathVariable(value="type") String type) {
		return clientService.ListClientsByType(type);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Client> addClient(@RequestBody Client client){
		return new ResponseEntity<>(clientService.addClient(client),HttpStatus.OK);
	}
	
@PutMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseStatus(HttpStatus.OK)
public ResponseEntity<Client> updateClient(@PathVariable(value="id") int id,
		@RequestBody Client client){
	return new ResponseEntity<> (clientService.updateClient(id, client),HttpStatus.OK);
}

@DeleteMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseStatus(HttpStatus.OK)
public ResponseEntity<String> deleteClient(@PathVariable(value = "id") int id){
	return new ResponseEntity<>(clientService.deleteClient(id),HttpStatus.OK);
}
}
