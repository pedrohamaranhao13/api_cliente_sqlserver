package br.com.smarttecnologia.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente {

	private Integer idCliente;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String observacoes; 
	
	
}
