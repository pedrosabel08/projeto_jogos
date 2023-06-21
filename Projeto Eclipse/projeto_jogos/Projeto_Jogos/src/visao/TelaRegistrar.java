package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import controle.FuncionarioBD;
import modelo.Funcionario;
public class TelaRegistrar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCargo;
	private JFormattedTextField txtCPF;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private JFormattedTextField txtTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRegistrar frame = new TelaRegistrar();
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
	public TelaRegistrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		lblNewLabel.setBounds(79, 11, 325, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 86, 464, 34);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		txtNome.setBounds(10, 121, 464, 34);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cargo:");
		lblNewLabel_1_1.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 266, 464, 34);
		contentPane.add(lblNewLabel_1_1);
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		txtCargo.setColumns(10);
		txtCargo.setBounds(10, 301, 464, 34);
		contentPane.add(txtCargo);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF:");
		lblNewLabel_1_2.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 368, 464, 34);
		contentPane.add(lblNewLabel_1_2);
		
		txtCPF = new JFormattedTextField();
		txtCPF.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		txtCPF.setColumns(10);
		txtCPF.setBounds(10, 403, 464, 34);
		contentPane.add(txtCPF);
		
		MaskFormatter maskCPF;
		try {
			maskCPF = new MaskFormatter("###.###.###-##");
			maskCPF.install(txtCPF);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel_1_3 = new JLabel("Usuario:");
		lblNewLabel_1_3.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 466, 464, 34);
		contentPane.add(lblNewLabel_1_3);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(10, 501, 464, 34);
		contentPane.add(txtUsuario);
		
		JLabel lblNewLabel_1_4 = new JLabel("Senha:");
		lblNewLabel_1_4.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(10, 560, 464, 34);
		contentPane.add(lblNewLabel_1_4);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		txtSenha.setColumns(10);
		txtSenha.setBounds(10, 595, 464, 34);
		contentPane.add(txtSenha);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome, telefone, cargo, cpf, usuario, senha;

				nome = txtNome.getText();
				telefone = txtTelefone.getText();
				cargo = txtCargo.getText();
				cpf = txtCPF.getText();
				usuario = txtUsuario.getText();
				senha = txtSenha.getText();

				Funcionario funcionario = new Funcionario();
				funcionario.setNome(nome);
				funcionario.setTelefone(telefone);
				funcionario.setCargo(cargo);
				funcionario.setCpf(cpf);
				funcionario.setUsuario(usuario);
				funcionario.setSenha(senha);

				FuncionarioBD funcionarioBD = new FuncionarioBD();
				funcionarioBD.cadastrarFuncionario(funcionario);
				
				TelaLogin exibir = new TelaLogin();
				exibir.setLocationRelativeTo(null);
				exibir.setVisible(true);
				
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Faça seu login!");
				
			}
		});
		btnRegistrar.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		btnRegistrar.setBounds(166, 678, 152, 40);
		contentPane.add(btnRegistrar);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Telefone:");
		lblNewLabel_1_1_1.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 178, 464, 34);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtTelefone = new JFormattedTextField();
		txtTelefone.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(10, 213, 464, 34);
		contentPane.add(txtTelefone);
		
		MaskFormatter maskTelefone;
		try {
			maskTelefone = new MaskFormatter("(##)#####-####");
			maskTelefone.install(txtTelefone);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
	}
}
