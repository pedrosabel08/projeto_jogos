package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controle.Conexao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtSenha;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		lblNewLabel.setBounds(84, 46, 316, 40);
		contentPane.add(lblNewLabel);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		txtSenha.setColumns(10);
		txtSenha.setBounds(10, 245, 464, 34);
		contentPane.add(txtSenha);
		
		JLabel lblNewLabel_1_4 = new JLabel("Senha:");
		lblNewLabel_1_4.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(10, 210, 464, 34);
		contentPane.add(lblNewLabel_1_4);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(10, 151, 464, 34);
		contentPane.add(txtUsuario);
		
		JLabel lblNewLabel_1_3 = new JLabel("Usuario:");
		lblNewLabel_1_3.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 116, 464, 34);
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = Conexao.faz_conexao();
					
					String sql = "select * from Funcionario where usuario = ? and senha = ?";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, txtUsuario.getText());
					stmt.setString(2, new String(txtSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery();
					
					if(rs.next()) {
						
						TelaInicial exibir = new TelaInicial();
						exibir.setLocationRelativeTo(null);
						exibir.setVisible(true);
						
						setVisible(false);
						
						JOptionPane.showMessageDialog(null, "Bem-Vindo!");
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Usuario ou senha não existem");
					}
					
					stmt.close();
					con.close();
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		btnNewButton.setBounds(175, 362, 140, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/seta-para-tras.png")));
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio TI = new TelaInicio();
				TI.setVisible(true);
				TI.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setFont(new Font("Source Sans Pro", Font.PLAIN, 13));
		btnNewButton_1.setBounds(0, 0, 49, 29);
		contentPane.add(btnNewButton_1);
	}
}
