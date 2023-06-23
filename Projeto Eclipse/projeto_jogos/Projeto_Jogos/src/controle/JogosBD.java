package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Jogos;

public class JogosBD {

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	ArrayList<Jogos> lista = new ArrayList<>();
	
	public ArrayList <Jogos> pesquisarJogos(){
		String sql = "select * from Jogo";

		conn = new Conexao().faz_conexao();

		try {
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();


			while(rs.next()) {
				Jogos jogo = new Jogos();
				jogo.setId(rs.getInt("idJogo"));
				jogo.setNome(rs.getString("nomeJogo"));
				jogo.setPlataforma(rs.getString("plataforma"));
				jogo.setQtd(rs.getInt("qtd"));
				jogo.setValor(rs.getDouble("valor"));

				lista.add(jogo);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao pesquisar o Cliente -> " + e);
		}
		return lista;
	}
	
	public void cadastrarJogo(Jogos jogo) {
		String sql = "insert into Jogo (nomeJogo, plataforma, qtd, valor) values (?,?,?,?)";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, jogo.getNome());
			stmt.setString(2, jogo.getPlataforma());
			stmt.setInt(3, jogo.getQtd());
			stmt.setDouble(4, jogo.getValor());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "Jogo inserido com sucesso!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Preencha os campos para cadastrar!");
		}
		
	}
	
	public void alterarJogo(Jogos jogo) {
		String sql = "update Jogo set nomeJogo = ?, plataforma = ?, qtd = ?, valor = ? where idJogo = ?";
		
		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, jogo.getNome());
			stmt.setString(2, jogo.getPlataforma());
			stmt.setInt(3, jogo.getQtd());
			stmt.setDouble(4, jogo.getValor());
			stmt.setInt(5, jogo.getId());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null,"Jogo alterado com sucesso!");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao alterar -> " + e);
		}
	}
	
	public void excluirJogo(Jogos jogo) {
		String sql = "delete from Jogo where idJogo = ?";

		conn = new Conexao().faz_conexao();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, jogo.getId());
			
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null,"Jogo excluido com sucesso!");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null,"Erro no Banco de Dados ao excluir -> " + e);
		}
	}
	
	public Jogos diminuirEstoque(Jogos jogo) {
		String sql = "update Jogo set qtd = qtd - 1 where idJogo = ?";
		
		conn = new Conexao().faz_conexao();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, jogo.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jogo;
		
	}
	
}
