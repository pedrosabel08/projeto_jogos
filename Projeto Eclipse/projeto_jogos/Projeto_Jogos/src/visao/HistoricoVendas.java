package visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.VendaBD;
import modelo.Venda;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;


public class HistoricoVendas extends JFrame {

	private JPanel contentPane;
	private JTable tbVendas;
	private DefaultTableModel modelo;
	private ArrayList<Venda> listaVendas;
	private JTextField txtTotal;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public HistoricoVendas(TelaVenda tv) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHistricoDeVendas = new JLabel("Hist\u00F3rico de Vendas");
		lblHistricoDeVendas.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistricoDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 16));

		contentPane.add(lblHistricoDeVendas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 36, 823, 274);
		contentPane.add(scrollPane);
		
		tbVendas = new JTable();
		tbVendas.setForeground(Color.WHITE);
		tbVendas.setBackground(Color.DARK_GRAY);
		tbVendas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbVendas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Jogo","Cliente", "Valor", "Data"
			}
		));
		scrollPane.setViewportView(tbVendas);
		VendaBD vendaBD = new VendaBD();
		listaVendas = vendaBD.buscarVenda();
		
		modelo = (DefaultTableModel) tbVendas.getModel();
		for (int i = 0; i < listaVendas.size(); i++) {
			Venda v = listaVendas.get(i);
			modelo.addRow(new Object[] { v.getId(), v.getNomeJogo(),v.getNomeCliente(), v.getValor(), v.getData() });

		}

		tbVendas.setModel(modelo);
		JButton btnFechar = new JButton("Voltar");
		btnFechar.setForeground(Color.WHITE);
		btnFechar.setBackground(Color.DARK_GRAY);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFechar.setBounds(25, 392, 102, 30);
		contentPane.add(btnFechar);
		
		JLabel lblNewLabel_4 = new JLabel("Valor Total:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(663, 405, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		txtTotal.setColumns(10);
		txtTotal.setBackground(Color.WHITE);
		txtTotal.setBounds(762, 402, 86, 20);
		contentPane.add(txtTotal);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.setForeground(Color.WHITE);
		btnTotal.setBackground(Color.DARK_GRAY);
		btnTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double somaTotal=0;

				for(int i=0; i<modelo.getRowCount();i++)
					somaTotal += Double.parseDouble(modelo.getValueAt(i, 3).toString());
				txtTotal.setText(String.valueOf(somaTotal));
			}
		});
		btnTotal.setBounds(137, 392, 102, 30);
		contentPane.add(btnTotal);
		
		JLabel lblNewLabel = new JLabel("Historico de Vendas");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 11, 823, 14);
		contentPane.add(lblNewLabel);
	}
}
