package visao;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import controle.FuncionarioBD;
import modelo.Funcionario;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class TelaFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JFormattedTextField txtTelefone;
	private JTextField txtCargo;
	private JTextField txtSalario;
	private JFormattedTextField txtCpf;
	private JTextField txtId;
	private JTable tabelaFunc;
	private JTextField textField;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario frame = new TelaFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaFuncionario() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 2000, 1200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(0, 0, 6, 6, (Color) new Color(25, 25, 112)));
		scrollPane.setBounds(434, 128, 1055, 660);
		contentPane.add(scrollPane);

		tabelaFunc = new JTable();
		tabelaFunc.setBorder(null);
		tabelaFunc.setBackground(Color.LIGHT_GRAY);
		tabelaFunc.setForeground(new Color(0, 0, 0));
		tabelaFunc.setFont(new Font("Dialog", Font.PLAIN, 12));
		tabelaFunc.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Telefone", "Cargo", "Salário (R$)", "CPF", "Usuário", "Senha"
			}
		));
		scrollPane.setViewportView(tabelaFunc);

		try {
			FuncionarioBD funcionarioBD = new FuncionarioBD();

			DefaultTableModel model = (DefaultTableModel) tabelaFunc.getModel();
			model.setNumRows(0);

			ArrayList<Funcionario> lista = funcionarioBD.pesquisarFuncionario();
			for(int num = 0 ; num < lista.size() ; num ++) {
				model.addRow(new Object [] {
						lista.get(num).getId(),
						lista.get(num).getNome(),
						lista.get(num).getTelefone(),
						lista.get(num).getCargo(),
						lista.get(num).getSalario(),
						lista.get(num).getCpf(),
						lista.get(num).getUsuario(),
						lista.get(num).getSenha()

				});
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Erro no Listar Valores" + e);
		}

		tabelaFunc.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                	int row = tabelaFunc.getSelectedRow();
                    txtId.setText(tabelaFunc.getValueAt(row, 0).toString());
                    txtNome.setText(tabelaFunc.getValueAt(row, 1).toString());
                    txtTelefone.setText(tabelaFunc.getValueAt(row, 2).toString());
                    txtCargo.setText(tabelaFunc.getValueAt(row, 3).toString());
                    txtSalario.setText(tabelaFunc.getValueAt(row, 4).toString());
                    txtCpf.setText(tabelaFunc.getValueAt(row, 5).toString());
                    txtUsuario.setText(tabelaFunc.getValueAt(row, 6).toString());
                    txtSenha.setText(tabelaFunc.getValueAt(row, 7).toString());
                }
            }
        });
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(330, 839, 60, 26);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(0, 0, 60, 26);
		panel_2.add(lblNome);
		lblNome.setBackground(Color.DARK_GRAY);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setForeground(Color.WHITE);

		txtNome = new JTextField();
		txtNome.setForeground(Color.WHITE);
		txtNome.setFont(new Font("Dialog", Font.BOLD, 12));
		txtNome.setBackground(Color.DARK_GRAY);
		txtNome.setBounds(330, 872, 145, 31);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(534, 839, 82, 26);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setBounds(0, 0, 82, 26);
		panel.add(lblTelefone);
		lblTelefone.setBackground(Color.DARK_GRAY);
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelefone.setForeground(Color.WHITE);

		txtTelefone = new JFormattedTextField();
		txtTelefone.setForeground(Color.WHITE);
		txtTelefone.setFont(new Font("Dialog", Font.BOLD, 12));
		txtTelefone.setBackground(Color.DARK_GRAY);
		txtTelefone.setBounds(534, 872, 145, 31);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		MaskFormatter maskTelefone;
		try {
			maskTelefone = new MaskFormatter("(##)#####-####");
			maskTelefone.install(txtTelefone);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(728, 839, 69, 26);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo.setBounds(0, 0, 69, 26);
		panel_3.add(lblCargo);
		lblCargo.setBackground(Color.DARK_GRAY);
		lblCargo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCargo.setForeground(Color.WHITE);

		txtCargo = new JTextField();
		txtCargo.setForeground(Color.WHITE);
		txtCargo.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCargo.setBackground(Color.DARK_GRAY);
		txtCargo.setBounds(728, 872, 127, 31);
		contentPane.add(txtCargo);
		txtCargo.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(927, 839, 69, 26);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalario.setBounds(0, 0, 69, 26);
		panel_4.add(lblSalario);
		lblSalario.setBackground(Color.DARK_GRAY);
		lblSalario.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSalario.setForeground(Color.WHITE);

		txtSalario = new JTextField();
		txtSalario.setForeground(Color.WHITE);
		txtSalario.setFont(new Font("Dialog", Font.BOLD, 12));
		txtSalario.setBackground(Color.DARK_GRAY);
		txtSalario.setBounds(927, 872, 127, 31);
		contentPane.add(txtSalario);
		txtSalario.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(1148, 839, 69, 26);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setBounds(0, 0, 69, 26);
		panel_5.add(lblCpf);
		lblCpf.setBackground(Color.DARK_GRAY);
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCpf.setForeground(Color.WHITE);

		txtCpf = new JFormattedTextField();
		txtCpf.setForeground(Color.WHITE);
		txtCpf.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCpf.setBackground(Color.DARK_GRAY);
		txtCpf.setBounds(1148, 872, 127, 31);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		MaskFormatter maskCPF;
		try {
			maskCPF = new MaskFormatter("###.###.###-##");
			maskCPF.install(txtCpf);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(220, 839, 46, 26);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblIDCliente = new JLabel("ID");
		lblIDCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDCliente.setBounds(0, 0, 46, 26);
		panel_1.add(lblIDCliente);
		lblIDCliente.setBackground(Color.DARK_GRAY);
		lblIDCliente.setFont(new Font("Dialog", Font.BOLD, 14));
		lblIDCliente.setForeground(Color.WHITE);

		txtId = new JTextField();
		txtId.setForeground(Color.WHITE);
		txtId.setFont(new Font("Dialog", Font.BOLD, 12));
		txtId.setBackground(Color.DARK_GRAY);
		txtId.setEnabled(false);
		txtId.setBounds(220, 872, 46, 31);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCadastrar.setBackground(Color.DARK_GRAY);
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarFuncionario();
				LimparCampos();
				listarValores();
			}
		});
		btnCadastrar.setBounds(434, 938, 188, 40);
		contentPane.add(btnCadastrar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAlterar.setBackground(Color.DARK_GRAY);
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarFuncionario();
				LimparCampos();
				listarValores();
			}
		});
		btnAlterar.setBounds(706, 938, 197, 40);
		contentPane.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnExcluir.setBackground(Color.DARK_GRAY);
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFuncionario();
				LimparCampos();
				listarValores();
			}
		});
		btnExcluir.setBounds(990, 938, 197, 40);
		contentPane.add(btnExcluir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnLimpar.setBackground(Color.DARK_GRAY);
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCampos();
			}
		});
		btnLimpar.setBounds(1292, 938, 197, 40);
		contentPane.add(btnLimpar);
		
		JLabel lblNewLabel_1 = new JLabel("Funcion\u00E1rios");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(434, 26, 1055, 63);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("<--");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial frame = new TelaInicial();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(1505, 128, 56, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 74, 263, 240);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(1609, 367, 188, 31);
		contentPane.add(textField);
		
		JButton btnNewButton_1 = new JButton("Filtrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filtro = textField.getText();
				filtrarTabela(filtro);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(1609, 404, 188, 40);
		contentPane.add(btnNewButton_1);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel_4_1.setBackground(Color.DARK_GRAY);
		panel_4_1.setBounds(1354, 839, 82, 26);
		contentPane.add(panel_4_1);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsuario.setBackground(Color.DARK_GRAY);
		lblUsuario.setBounds(0, 0, 80, 26);
		panel_4_1.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(Color.WHITE);
		txtUsuario.setFont(new Font("Dialog", Font.BOLD, 12));
		txtUsuario.setColumns(10);
		txtUsuario.setBackground(Color.DARK_GRAY);
		txtUsuario.setBounds(1354, 872, 127, 31);
		contentPane.add(txtUsuario);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel_4_1_1.setBackground(Color.DARK_GRAY);
		panel_4_1_1.setBounds(1551, 839, 82, 26);
		contentPane.add(panel_4_1_1);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSenha.setBackground(Color.DARK_GRAY);
		lblSenha.setBounds(0, 0, 80, 26);
		panel_4_1_1.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setForeground(Color.WHITE);
		txtSenha.setFont(new Font("Dialog", Font.BOLD, 12));
		txtSenha.setColumns(10);
		txtSenha.setBackground(Color.DARK_GRAY);
		txtSenha.setBounds(1551, 872, 127, 31);
		contentPane.add(txtSenha);}

	private void CadastrarFuncionario() {
		String nome, telefone, cargo, cpf;
		double salario;
		int numero;

		nome = txtNome.getText();
		telefone = txtTelefone.getText();
		cargo = txtCargo.getText();
		salario = Double.parseDouble(txtSalario.getText());
		cpf = txtCpf.getText();

		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setTelefone(telefone);
		funcionario.setCargo(cargo);
		funcionario.setSalario(salario);
		funcionario.setCpf(cpf);

		FuncionarioBD funcionarioBD = new FuncionarioBD();
		funcionarioBD.cadastrarFuncionario(funcionario);
	}
	private void LimparCampos() {
		txtId.setText("");
		txtNome.setText("");
		txtTelefone.setText("");
		txtCargo.setText("");
		txtSalario.setText("");
		txtCpf.setText("");
	}
	private void AlterarFuncionario() {
		int id;
		String nome, telefone, cargo, cpf;
		double salario;

		id = Integer.parseInt(txtId.getText());
		nome = txtNome.getText();
		telefone = txtTelefone.getText();
		cargo = txtCargo.getText();
		salario = Double.parseDouble(txtSalario.getText());
		cpf = txtCpf.getText();

		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		funcionario.setNome(nome);
		funcionario.setTelefone(telefone);
		funcionario.setCargo(cargo);
		funcionario.setSalario(salario);
		funcionario.setCpf(cpf);

		FuncionarioBD funcionarioBD = new FuncionarioBD();
		funcionarioBD.alterarFuncionario(funcionario);
	}
	private void excluirFuncionario() {
		int id;

		id = Integer.parseInt(txtId.getText());

		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);

		FuncionarioBD funcionarioBD = new FuncionarioBD();
		funcionarioBD.excluirFuncionario(funcionario);
	}
	private void listarValores() {
		try {
			FuncionarioBD funcionarioBD = new FuncionarioBD();

			DefaultTableModel model = (DefaultTableModel) tabelaFunc.getModel();
			model.setNumRows(0);

			ArrayList<Funcionario> lista = funcionarioBD.pesquisarFuncionario();
			for(int num = 0 ; num < lista.size() ; num ++) {
				model.addRow(new Object [] {
						lista.get(num).getId(),
						lista.get(num).getNome(),
						lista.get(num).getTelefone(),
						lista.get(num).getCargo(),
						lista.get(num).getSalario(),
						lista.get(num).getCpf(),	
						lista.get(num).getUsuario(),
						lista.get(num).getSenha()

				});
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Erro no Listar Valores" + e);
		}

	}
	private void filtrarTabela(String filtro) {
	    DefaultTableModel model = (DefaultTableModel) tabelaFunc.getModel();
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
	    tabelaFunc.setRowSorter(sorter);
	    sorter.setRowFilter(RowFilter.regexFilter(filtro));
	}
}
