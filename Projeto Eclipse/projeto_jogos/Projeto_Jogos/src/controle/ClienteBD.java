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
		String sql = "select idCliente, nomeCliente, telefoneCliente, qtdJogosVendidos, valorTotal, j.nomeJogo from Cliente c inner join Jogos j on c.jogo_idJogo = j.idJogo";

		conn = new Conexao().faz_conexao();

		try {
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();


			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nomeCliente"));
				cliente.setTelefone(rs.getString("telefoneCliente"));
				cliente.setQtd(rs.getInt("qtdJogosVendidos"));
				cliente.setValor(rs.getDouble("valorTotal"));
				cliente.setJogo(rs.getString("j.nomeJogo"));

				lista.add(cliente);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao pesquisar o Cliente -> " + e);
		}
		return lista;
	}
	
	public void cadastrarCliente(Cliente cliente) {
		String sql = "insert into Cliente (nomeCliente, telefoneCliente, cpfCliente, qtdJogosVendidos, valorTotal, idJogo) values (?,?,?,?,?,?)";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getCpf());
			stmt.setInt(4, cliente.getQtd());
			stmt.setDouble(5, cliente.getValor());
			stmt.setInt(6, cliente.getIdJogo());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha os campos para cadastrar!");
		}
		
	}
	
	public void alterarCliente(Cliente cliente) {
		String sql = "update Cliente set nomeCliente = ?, telefoneCliente = ?, cpfCliente = ?, qtdJogosVendidos = ?, valorTotal = ? where idCliente = ?";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getCpf());
			stmt.setInt(4, cliente.getQtd());
			stmt.setDouble(5, cliente.getValor());
			stmt.setInt(6, cliente.getId());
			
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