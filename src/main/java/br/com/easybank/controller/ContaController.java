package br.com.easybank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easybank.exception.ContaNotFoundException;
import br.com.easybank.model.Conta;
import br.com.easybank.repository.ContaRepository;
import br.com.easybank.service.ContaService;

@RestController
@RequestMapping("/easybank/contas")
public class ContaController {
	
	private final ContaService contaService;
	
	@Autowired
	public ContaController(ContaService contaService) {
		this.contaService = contaService;
	}
	
	@GetMapping
	public ResponseEntity<List<Conta>> getAllContas(){
		List<Conta> contas = contaService.getContas();
		return new ResponseEntity<>(contas, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Conta> getContaById(@PathVariable(value = "id")Long id){
		Conta conta = contaService.getContaById(id);
		return new ResponseEntity<>(conta, HttpStatus.OK);	 
	}
	
	@GetMapping("/numeroConta/{numero_conta}")
	public ResponseEntity<Conta> getContaByNumeroConta(@PathVariable(value = "numero_conta")Integer numeroConta){
		Conta conta = contaService.getContaByNumeroConta(numeroConta);
		return new ResponseEntity<>(conta, HttpStatus.OK);	 
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Conta> registerConta(@RequestBody @Valid Conta conta){
		Conta contaCriada = contaService.setNewConta(conta);
		return new ResponseEntity<>(contaCriada, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> deletaConta(@PathVariable(value = "id") Long id){
		contaService.deleteContaById(id);	
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
