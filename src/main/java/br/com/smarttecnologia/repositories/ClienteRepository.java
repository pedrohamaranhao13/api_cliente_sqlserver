package br.com.smarttecnologia.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import br.com.smarttecnologia.entities.Cliente;
import br.com.smarttecnologia.factories.ConnectionFactory;

public class ClienteRepository {

	public void create(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();
		
		String sql = "insert into cliente(nome, email, cpf, telefone, observacoes) values(?,?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCpf());
		statement.setString(4, cliente.getTelefone());
		statement.setString(5, cliente.getObservacoes());
		statement.execute();
		
		connection.close();
		
	}
	
	public void update(Cliente cliente) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		String sql = "update cliente set nome=?, email=?, cpf=?, telefone=?, observacoes=? where idcliente=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCpf());
		statement.setString(4, cliente.getTelefone());
		statement.setString(5, cliente.getObservacoes());
		statement.setInt(6, cliente.getIdCliente());
		statement.execute();
		
		connection.close();
	}
	
	public void delete(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();
		
		String sql = "delete from cliente where idcliente=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, cliente.getIdCliente());
		statement.execute();
		
		connection.close();
		
	}
	
	public List<Cliente> findAll() throws Exception {
		//  TODO
		return null;
	}
	
	public Cliente findById(Integer idCliente) throws Exception {
		//  TODO
		return null; 
	}
}
