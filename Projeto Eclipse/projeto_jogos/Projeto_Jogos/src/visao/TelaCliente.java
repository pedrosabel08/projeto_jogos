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

import controle.ClienteBD;
import modelo.Cliente;

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

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCpf;
	private JTextField txtId;
	private JTable tabelaCliente;
	private JTextField textField;
	private JTextField txtQuantidade;
	private JTextField txtValor;

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
	public TelaCliente() {
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

		tabelaCliente = new JTable();
		tabelaCliente.setBorder(null);
		tabelaCliente.setBackground(Color.LIGHT_GRAY);
		tabelaCliente.setForeground(new Color(0, 0, 0));
		tabelaCliente.setFont(new Font("Dialog", Font.PLAIN, 12));
		tabelaCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Telefone", "CPF", "Quantidade", "Valor Total"
			}
		));
		scrollPane.setViewportView(tabelaCliente);

		try {
			ClienteBD clienteBD = new ClienteBD();

			DefaultTableModel model = (DefaultTableModel) tabelaCliente.getModel();
			model.setNumRows(0);

			ArrayList<Cliente> lista = clienteBD.pesquisarCliente();
			for(int num = 0 ; num < lista.size() ; num ++) {
				model.addRow(new Object [] {
						lista.get(num).getId(),
						lista.get(num).getNome(),
						lista.get(num).getTelefone(),
						lista.get(num).getCpf(),
						lista.get(num).getQtd(),
						lista.get(num).getValor()

				});
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Erro no Listar Valores" + e);
		}

		tabelaCliente.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                	int row = tabelaCliente.getSelectedRow();
                    txtId.setText(tabelaCliente.getValueAt(row, 0).toString());
                    txtNome.setText(tabelaCliente.getValueAt(row, 1).toString());
                    txtTelefone.setText(tabelaCliente.getValueAt(row, 2).toString());
                    txtCpf.setText(tabelaCliente.getValueAt(row, 3).toString());
                    txtQuantidade.setText(tabelaCliente.getValueAt(row, 4).toString());
                    txtValor.setText(tabelaCliente.getValueAt(row, 5).toString());
                }
            }
        });
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(544, 838, 60, 26);
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
		txtNome.setBounds(544, 871, 145, 31);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(748, 838, 82, 26);
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
		txtTelefone.setBounds(748, 871, 145, 31);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		MaskFormatter maskTelefone;
		try {
			maskTelefone = new MaskFormatter("(##)#####-####");
			maskTelefone.install(txtTelefone);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(956, 838, 69, 26);
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
		txtCpf.setBounds(956, 871, 127, 31);
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
		panel_1.setBounds(434, 838, 46, 26);
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
		txtId.setBounds(434, 871, 46, 31);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCadastrar.setBackground(Color.DARK_GRAY);
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente();
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
				AlterarCliente();
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
				excluirCliente();
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
		
		JLabel lblNewLabel_1 = new JLabel("Clientes");
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(1153, 838, 97, 26);
		contentPane.add(panel_3);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Dialog", Font.BOLD, 14));
		lblQuantidade.setBackground(Color.DARK_GRAY);
		lblQuantidade.setBounds(0, 0, 97, 26);
		panel_3.add(lblQuantidade);
		
		JTextField txtQuantidade = new JTextField();
		txtQuantidade.setForeground(Color.WHITE);
		txtQuantidade.setFont(new Font("Dialog", Font.BOLD, 12));
		txtQuantidade.setColumns(10);
		txtQuantidade.setBackground(Color.DARK_GRAY);
		txtQuantidade.setBounds(1153, 871, 145, 31);
		contentPane.add(txtQuantidade);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(1344, 838, 97, 26);
		contentPane.add(panel_4);
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorTotal.setForeground(Color.WHITE);
		lblValorTotal.setFont(new Font("Dialog", Font.BOLD, 14));
		lblValorTotal.setBackground(Color.DARK_GRAY);
		lblValorTotal.setBounds(0, 0, 101, 26);
		panel_4.add(lblValorTotal);
		
		JTextField txtValor = new JTextField();
		txtValor.setForeground(Color.WHITE);
		txtValor.setFont(new Font("Dialog", Font.BOLD, 12));
		txtValor.setColumns(10);
		txtValor.setBackground(Color.DARK_GRAY);
		txtValor.setBounds(1344, 871, 145, 31);
		contentPane.add(txtValor);}

	private void CadastrarCliente() {
		String nome, telefone, cpf;
		int qtd;
		double valor;

		nome = txtNome.getText();
		telefone = txtTelefone.getText();
		cpf = txtCpf.getText();
		qtd = Integer.parseInt(txtQuantidade.getText());
		valor = Double.parseDouble(txtValor.getText());
		

		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		cliente.setCpf(cpf);
		cliente.setQtd(qtd);
		cliente.setValor(valor);


		ClienteBD clienteBD = new ClienteBD();
		clienteBD.cadastrarCliente(cliente);
	}
	private void LimparCampos() {
		txtId.setText("");
		txtNome.setText("");
		txtTelefone.setText("");
		txtCpf.setText("");
		txtQuantidade.setText("");
		txtValor.setText("");
	}
	private void AlterarCliente() {
		String nome, telefone, cpf;
		int qtd, id;
		double valor;

		id = Integer.parseInt(txtId.getText());
		nome = txtNome.getText();
		telefone = txtTelefone.getText();
		cpf = txtCpf.getText();
		qtd = Integer.parseInt(txtQuantidade.getText());
		valor = Double.parseDouble(txtValor.getText());

		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		cliente.setCpf(cpf);
		cliente.setQtd(qtd);
		cliente.setValor(valor);

		ClienteBD clienteBD = new ClienteBD();
		clienteBD.alterarCliente(cliente);
	}
	private void excluirCliente() {
		int id;

		id = Integer.parseInt(txtId.getText());

		Cliente cliente = new Cliente();
		cliente.setId(id);
		
		ClienteBD clienteBD = new ClienteBD();
		clienteBD.excluirCliente(cliente);
	}
	private void listarValores() {
		try {
			
			ClienteBD clienteBD = new ClienteBD();
			DefaultTableModel model = (DefaultTableModel) tabelaCliente.getModel();
			model.setNumRows(0);

			ArrayList<Cliente> lista = clienteBD.pesquisarCliente();
			for(int num = 0 ; num < lista.size() ; num ++) {
				model.addRow(new Object [] {
						lista.get(num).getId(),
						lista.get(num).getNome(),
						lista.get(num).getTelefone(),
						lista.get(num).getCpf(),
						lista.get(num).getQtd(),
						lista.get(num).getValor()

				});
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Erro no Listar Valores" + e);
		}

	}
	private void filtrarTabela(String filtro) {
	    DefaultTableModel model = (DefaultTableModel) tabelaCliente.getModel();
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
	    tabelaCliente.setRowSorter(sorter);
	    sorter.setRowFilter(RowFilter.regexFilter(filtro));
	}
}
