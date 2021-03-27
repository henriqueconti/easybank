package br.com.easybank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easybank.exception.ClienteNotFoundException;
import br.com.easybank.model.Cliente;
import br.com.easybank.repository.ClienteRepository;
import br.com.easybank.repository.ContaRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente getClienteById(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException("O cliente de id: " + id + " não existe"));
	}
	
	public Cliente setNewCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}
	
}
