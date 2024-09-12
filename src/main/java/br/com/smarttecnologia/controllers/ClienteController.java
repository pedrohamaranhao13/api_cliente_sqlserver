package br.com.smarttecnologia.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smarttecnologia.dtos.ClientePostDto;
import br.com.smarttecnologia.dtos.ClientePutDto;
import br.com.smarttecnologia.entities.Cliente;
import br.com.smarttecnologia.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {
	
	@PostMapping
	public String post(@RequestBody ClientePostDto dto) {
		
		try {
			Cliente cliente = new Cliente();
			
			cliente.setNome(dto.getNome());
			cliente.setEmail(dto.getEmail());
			cliente.setCpf(dto.getCpf());
			cliente.setTelefone(dto.getTelefone());
			cliente.setObservacoes(dto.getObservacoes());
			
			ClienteRepository clienteRepository = new ClienteRepository();
			clienteRepository.create(cliente);
			
			return "Cliente cadastrado com sucesso!";
		} catch (Exception e) {
			return "Erro: " + e.getMessage();
		}
	}
	
	@PutMapping
	public String put(@RequestBody ClientePutDto dto) {
		
		try {
			
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(dto.getIdCliente());
			
			if (cliente != null) {
				
				cliente.setNome(dto.getNome());
				cliente.setEmail(dto.getEmail());
				cliente.setCpf(dto.getCpf());
				cliente.setTelefone(dto.getTelefone());
				cliente.setObservacoes(dto.getObservacoes());
				
				clienteRepository.update(cliente);
				
				return "Cliente atualizado com sucesso!";
			} 
			else {
				return "Cliente não encontrado.";
			}
			
			
		} catch (Exception e) {
			return "Erro :" + e.getMessage();
		}
		
		
	}
	
	@DeleteMapping("{idCliente}")
	public String delete(@PathVariable("idCliente") Integer idCliente) {
		
		try {
			
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);
			
			if (cliente != null) {
				
				clienteRepository.delete(cliente);
				return "Cliente excluído com sucesso!";
			}
			else {
				return "Cliente não encontrado.";
			}
			
			
		} catch (Exception e) {
			return "Erro: " + e.getMessage();
		}
		
	}
	
	@GetMapping
	public String getAll() {
		//TODO
		return null;
	}

}
