import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * DESARROLLADO POR PAUL HUAROC RICSE
 * 06/03/2023 
 */

public class menuConversor extends JFrame {
	
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					menuConversor frame = new menuConversor();
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
	public menuConversor() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConversor = new JLabel("CONVERSOR");
		lblConversor.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversor.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblConversor.setBounds(156, 24, 137, 19);
		contentPane.add(lblConversor);
		
		JButton btnMoneda = new JButton("MONEDA");
		btnMoneda.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frmMonedas monedas = new frmMonedas();
				dispose();
				monedas.setVisible(true);
				monedas.setLocationRelativeTo(null);
				//menuConversor menu = new menuConversor();
				
			}
		});
		btnMoneda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMoneda.setBounds(56, 94, 137, 45);
		contentPane.add(btnMoneda);
		
		JButton btnTemperatura = new JButton("TEMPERATURA");
		btnTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTemperatura temperatura = new frmTemperatura();
				dispose();
				temperatura.setVisible(true);
				temperatura.setLocationRelativeTo(null);
			}
		});
		btnTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTemperatura.setBounds(254, 94, 137, 45);
		contentPane.add(btnTemperatura);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(359, 168, 85, 21);
		contentPane.add(btnSalir);
	}
}
