package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controle.VendaBD;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Insets;
import modelo.Cliente;
import modelo.Jogos;
import modelo.Venda;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTable tabelaVenda;
	private JTextField txtIdJogo;
	private JTextField txtIdCliente;
	private JTextField txtNome;

	private Jogos jogoSelecionado;
	private Cliente clienteSelecionado;
	private JTextField txtNomeJogo;
	private JTextField txtPlataforma;
	private JTextField txtValor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda frame = new TelaVenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setJogoSelecionado(Jogos jogo) {
		this.jogoSelecionado = jogo;
		this.txtIdJogo.setText(String.valueOf(jogo.getId()));
		this.txtNomeJogo.setText(jogo.getNome());
		this.txtPlataforma.setText(jogo.getPlataforma());
		this.txtValor.setText(String.valueOf(jogo.getValor()));
		
	}
	public void setClienteSelecionado(Cliente cliente) {
		this.clienteSelecionado = cliente;
		this.txtIdCliente.setText(String.valueOf(cliente.getId()));
		this.txtNome.setText(cliente.getNome());
	}
	
	
	/**
	 * Create the frame.
	 */
	public TelaVenda() {
		setUndecorated(true);
		
		TelaVenda tv = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 2000, 1800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(742, 254, 747, 553);
		contentPane.add(scrollPane);

		tabelaVenda = new JTable();
		tabelaVenda.setBorder(null);
		tabelaVenda.setBackground(Color.DARK_GRAY);
		tabelaVenda.setForeground(Color.WHITE);
		tabelaVenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		DefaultTableModel model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome do Jogo", "Plataforma", "Cliente", "Valor (R$)"
			}
		);
		tabelaVenda.setModel(model);
		scrollPane.setViewportView(tabelaVenda);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID:");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(166, 334, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		txtIdJogo = new JTextField();
		txtIdJogo.setMargin(new Insets(2, 6, 2, 2));
		txtIdJogo.setCaretColor(Color.WHITE);
		txtIdJogo.setForeground(Color.WHITE);
		txtIdJogo.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdJogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdJogo.setEditable(false);
		txtIdJogo.setColumns(10);
		txtIdJogo.setBackground(Color.DARK_GRAY);
		txtIdJogo.setBounds(199, 331, 46, 25);
		contentPane.add(txtIdJogo);
		
		JButton btnPesquisarJogo = new JButton("Pesquisar");
		btnPesquisarJogo.setForeground(Color.WHITE);
		btnPesquisarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaJogos TJ = new TabelaJogos(tv);
				TJ.setVisible(true);
			}
		});
		btnPesquisarJogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisarJogo.setBackground(Color.DARK_GRAY);
		btnPesquisarJogo.setBounds(285, 323, 157, 37);
		contentPane.add(btnPesquisarJogo);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(166, 691, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setForeground(Color.WHITE);
		txtIdCliente.setCaretColor(Color.WHITE);
		txtIdCliente.setMargin(new Insets(2, 6, 2, 2));
		txtIdCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdCliente.setEditable(false);
		txtIdCliente.setColumns(10);
		txtIdCliente.setBackground(Color.DARK_GRAY);
		txtIdCliente.setBounds(199, 688, 46, 25);
		contentPane.add(txtIdCliente);
		
		JButton btnPesquisarCliente = new JButton("Pesquisar");
		btnPesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabelaCliente TC = new TabelaCliente(tv);
				TC.setVisible(true);
			}
		});
		btnPesquisarCliente.setForeground(Color.WHITE);
		btnPesquisarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisarCliente.setBackground(Color.DARK_GRAY);
		btnPesquisarCliente.setBounds(285, 680, 157, 37);
		contentPane.add(btnPesquisarCliente);
		
		txtNome = new JTextField();
		txtNome.setForeground(Color.WHITE);
		txtNome.setCaretColor(Color.WHITE);
		txtNome.setMargin(new Insets(2, 6, 2, 2));
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBackground(Color.DARK_GRAY);
		txtNome.setBounds(228, 730, 214, 25);
		contentPane.add(txtNome);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nome:");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setBounds(166, 733, 79, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setBackground(Color.DARK_GRAY);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (jogoSelecionado != null) {
				for (int i = 0; i < 1; i++) {
					model.addRow(new Object[] {
							jogoSelecionado.getNome(), jogoSelecionado.getPlataforma(), clienteSelecionado.getNome(), jogoSelecionado.getValor()
					});
				
					tabelaVenda.setModel(model);
					
				
				} 
			} else {
				JOptionPane.showMessageDialog(null, "Nenhum jogo selecionado!");
			}
				
			}
		});
		btnAdicionar.setBounds(742, 830, 157, 37);
		contentPane.add(btnAdicionar);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setBackground(Color.DARK_GRAY);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < model.getRowCount(); i++) {
					String idCliente = txtIdCliente.getText();
					String idJogo = txtIdJogo.getText();
					String nomeCliente = (tabelaVenda.getValueAt(i, 0).toString());
					String nomeJogo = (tabelaVenda.getValueAt(i, 1).toString());
					String plataforma = (tabelaVenda.getValueAt(i, 2).toString());
					String preco = (tabelaVenda.getValueAt(i, 3).toString());
					DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					String h =(dtf5.format(LocalDateTime.now()));
					
					Venda venda = new Venda();
					
					venda.setCliente(Integer.valueOf(idCliente));
					venda.setJogo(Integer.valueOf(idJogo));
					venda.setNomeCliente(nomeCliente); 
					venda.setNomeJogo(nomeJogo);
					venda.setPlataforma(plataforma);
					venda.setValor(Double.valueOf(preco));
					venda.setData(h);
					
					VendaBD vendaBD = new VendaBD();
					vendaBD.inserirVenda(venda);			
					
				}
				while(tabelaVenda.getModel().getRowCount()>0) {
					((DefaultTableModel) tabelaVenda.getModel()).removeRow(0);
				}
				JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
				
				txtIdCliente.setText("");
				txtIdJogo.setText("");
				txtNome.setText("");
				txtNomeJogo.setText("");
				txtPlataforma.setText("");
				txtValor.setText("");
			}
		});
		btnFinalizar.setBounds(1044, 830, 157, 37);
		contentPane.add(btnFinalizar);
		
		JButton btnHistorico = new JButton("Historico");
		btnHistorico.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHistorico.setForeground(Color.WHITE);
		btnHistorico.setBackground(Color.DARK_GRAY);
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoVendas HV = new HistoricoVendas(tv);
				HV.setVisible(true);
				HV.setLocationRelativeTo(null);
			}
		});
		btnHistorico.setBounds(1332, 830, 157, 37);
		contentPane.add(btnHistorico);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(25, 25, 112)));
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(166, 265, 157, 37);
		contentPane.add(panel_3);
		
		JLabel lblJogo = new JLabel("Jogo");
		lblJogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogo.setForeground(Color.WHITE);
		lblJogo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblJogo.setBackground(Color.DARK_GRAY);
		lblJogo.setBounds(0, 0, 157, 37);
		panel_3.add(lblJogo);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 204, 0)));
		panel_3_1.setBackground(Color.DARK_GRAY);
		panel_3_1.setBounds(166, 622, 157, 37);
		contentPane.add(panel_3_1);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setForeground(Color.WHITE);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCliente.setBackground(Color.DARK_GRAY);
		lblCliente.setBounds(0, 0, 157, 37);
		panel_3_1.add(lblCliente);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial frame = new TelaInicial();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(Color.DARK_GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(10, 11, 79, 37);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Venda");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(742, 149, 747, 78);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Nome:");
		lblNewLabel_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1.setBounds(166, 385, 79, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		txtNomeJogo = new JTextField();
		txtNomeJogo.setMargin(new Insets(2, 6, 2, 2));
		txtNomeJogo.setForeground(Color.WHITE);
		txtNomeJogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeJogo.setEditable(false);
		txtNomeJogo.setColumns(10);
		txtNomeJogo.setCaretColor(Color.WHITE);
		txtNomeJogo.setBackground(Color.DARK_GRAY);
		txtNomeJogo.setBounds(228, 382, 214, 25);
		contentPane.add(txtNomeJogo);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Plataforma:");
		lblNewLabel_2_1_2.setForeground(Color.BLACK);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_2.setBounds(166, 432, 79, 14);
		contentPane.add(lblNewLabel_2_1_2);
		
		txtPlataforma = new JTextField();
		txtPlataforma.setMargin(new Insets(2, 6, 2, 2));
		txtPlataforma.setForeground(Color.WHITE);
		txtPlataforma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPlataforma.setEditable(false);
		txtPlataforma.setColumns(10);
		txtPlataforma.setCaretColor(Color.WHITE);
		txtPlataforma.setBackground(Color.DARK_GRAY);
		txtPlataforma.setBounds(255, 429, 187, 25);
		contentPane.add(txtPlataforma);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Valor:");
		lblNewLabel_2_1_3.setForeground(Color.BLACK);
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_1_3.setBounds(166, 483, 79, 14);
		contentPane.add(lblNewLabel_2_1_3);
		
		txtValor = new JTextField();
		txtValor.setMargin(new Insets(2, 6, 2, 2));
		txtValor.setForeground(Color.WHITE);
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtValor.setEditable(false);
		txtValor.setColumns(10);
		txtValor.setCaretColor(Color.WHITE);
		txtValor.setBackground(Color.DARK_GRAY);
		txtValor.setBounds(228, 480, 214, 25);
		contentPane.add(txtValor);
		
		
		
	}
}
