package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1000);
		this.setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFuncionario = new JButton("   Funcion\u00E1rio");
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionario TF = new TelaFuncionario();
				TF.setVisible(true);
				setVisible(false);
			}
		});
		btnFuncionario.setBackground(new Color(211, 211, 211));
		btnFuncionario.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/empregado (1).png")));
		btnFuncionario.setFont(new Font("Dialog", Font.PLAIN, 23));
		btnFuncionario.setBounds(603, 325, 240, 70);
		contentPane.add(btnFuncionario);
		
		JButton btnCliente = new JButton("   Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCliente TC = new TelaCliente();
				TC.setVisible(true);
				setVisible(false);
			}
		});
		btnCliente.setBackground(new Color(211, 211, 211));
		btnCliente.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/cliente.png")));
		btnCliente.setFont(new Font("Dialog", Font.PLAIN, 23));
		btnCliente.setBounds(603, 546, 240, 70);
		contentPane.add(btnCliente);
		
		JButton btnJogos = new JButton("   Jogos");
		btnJogos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaJogos TJ = new TelaJogos();
				TJ.setVisible(true);
				setVisible(false);
			}
		});
		btnJogos.setBackground(new Color(211, 211, 211));
		btnJogos.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/jogos.png")));
		btnJogos.setFont(new Font("Dialog", Font.PLAIN, 23));
		btnJogos.setBounds(1089, 325, 240, 70);
		contentPane.add(btnJogos);
		
		JButton btnVenda = new JButton("   Venda");
		btnVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVenda TV = new TelaVenda();
				TV.setVisible(true);
				setVisible(false);
			}
		});
		btnVenda.setBackground(new Color(211, 211, 211));
		btnVenda.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/vendas.png")));
		btnVenda.setFont(new Font("Dialog", Font.PLAIN, 23));
		btnVenda.setBounds(1089, 546, 240, 70);
		contentPane.add(btnVenda);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio TI = new TelaInicio();
				TI.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Dialog", Font.PLAIN, 23));
		btnVoltar.setBackground(new Color(211, 211, 211));
		btnVoltar.setBounds(845, 716, 240, 70);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, 0, 1924, 115);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Tela Inicial");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);
	}
}
