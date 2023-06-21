package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Cliente;

public class ClienteBD {

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	ArrayList<Cliente> lista = new ArrayList<>();
	
	public ArrayList <Cliente> pesquisarCliente(){
		String sql = "select * from Cliente";

		conn = new Conexao().faz_conexao();

		try {
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();


			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nomeCliente"));
				cliente.setTelefone(rs.getString("telefoneCliente"));
				cliente.setCpf(rs.getString("cpfCliente"));
				
				lista.add(cliente);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao pesquisar o Cliente -> " + e);
		}
		return lista;
	}
	
	public void cadastrarCliente(Cliente cliente) {
		String sql = "insert into Cliente (nomeCliente, telefoneCliente, cpfCliente) values (?,?,?)";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getCpf());
						
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha os campos para cadastrar!");
		}
		
	}
	
	public void alterarCliente(Cliente cliente) {
		String sql = "update Cliente set nomeCliente = ?, telefoneCliente = ?, cpfCliente = ? where idCliente = ?";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getCpf());
			stmt.setInt(4, cliente.getId());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null,"Cliente alterado com sucesso!");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao alterar -> " + e);
		}
	}
	
	public void excluirCliente(Cliente cliente) {
		String sql = "delete from Cliente where idCliente = ?";

		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cliente.getId());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null,"Cliente excluido com sucesso!");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao excluir -> " + e);
		}
	}
	
}
