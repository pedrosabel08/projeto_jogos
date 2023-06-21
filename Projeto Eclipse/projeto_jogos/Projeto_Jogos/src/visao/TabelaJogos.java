package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import modelo.Funcionario;
import modelo.Cliente;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import controle.JogosBD;
import modelo.Jogos;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;

public class TabelaJogos extends JFrame {

	static Connection conexao;
	private JPanel contentPane;
	private JTable tbJogos;
	private ArrayList<Jogos> listaJogos;
	private Jogos jogoSelecionado;
	private DefaultTableModel modelo;
	protected static final int posicaoPessoa = 0;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TabelaJogos(TelaVenda tv) {
		setUndecorated(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 50, 430, 174);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				
						tbJogos = new JTable();
						tbJogos.setForeground(Color.WHITE);
						tbJogos.setBackground(Color.DARK_GRAY);
						tbJogos.setFont(new Font("Tahoma", Font.PLAIN, 14));
						tbJogos.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "Plataforma" }

						));
						scrollPane.setViewportView(tbJogos);
						
								tbJogos.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "Plataforma" }));
								scrollPane.setViewportView(tbJogos);
								
										modelo = (DefaultTableModel) tbJogos.getModel();
										tbJogos.setModel(modelo);
		JogosBD jogosBD = new JogosBD();
		listaJogos = jogosBD.pesquisarJogos();
		for (int i = 0; i < listaJogos.size(); i++) {
			Jogos j = listaJogos.get(i);
			modelo.addRow(new Object[] { j.getId(), j.getNome(), j.getPlataforma() });

		}
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int linha = tbJogos.getSelectedRow();
				int idJogos = (int) tbJogos.getValueAt(linha, 0);

				for (Jogos jogos : listaJogos) {
					if (jogos.getId() == idJogos) {
						jogoSelecionado = jogos;
					}
				}
				if (linha > -1) {

					tv.setJogoSelecionado(jogoSelecionado);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "escolha uma linha na tabela");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(145, 235, 148, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBackground(Color.DARK_GRAY);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
	}

}