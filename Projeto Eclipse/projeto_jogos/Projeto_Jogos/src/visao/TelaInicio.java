package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
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
	public TelaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sabel Jogos");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Source Sans Pro", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(47, 207, 305, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRegistrar tr = new TelaRegistrar();
				tr.setVisible(true);
				tr.setLocationRelativeTo(null);
				
				setVisible(false);
			}
		});
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setBackground(new Color(25, 25, 112));
		btnRegistrar.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		btnRegistrar.setBounds(549, 58, 195, 40);
		contentPane.add(btnRegistrar);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tl = new TelaLogin();
				tl.setVisible(true);
				tl.setLocationRelativeTo(null);
				
				setVisible(false);
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		btnLogin.setBackground(new Color(25, 25, 112));
		btnLogin.setBounds(549, 372, 195, 40);
		contentPane.add(btnLogin);
	}
}
