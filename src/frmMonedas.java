import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMonedas extends JFrame {
	private JTextField txtInsertarMoneda;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMonedas frame = new frmMonedas();
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
	//Funcion para convertir el sol peruano a otras monedas
	public String ConversionTasas(Double divisa, Double tasa) {
		String conversion = Double.toString(divisa* tasa);
		return conversion;
	}
	
	public frmMonedas() {
		setBounds(100, 100, 444, 255);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("MONEDAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulo.setBounds(154, 10, 96, 39);
		getContentPane().add(lblTitulo);
		
		txtInsertarMoneda = new JTextField();
		txtInsertarMoneda.setBounds(75, 61, 58, 27);
		getContentPane().add(txtInsertarMoneda);
		txtInsertarMoneda.setColumns(10);
		
		JComboBox cboxMonedas = new JComboBox();
		cboxMonedas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboxMonedas.setModel(new DefaultComboBoxModel(new String[] {"Dolar", "Euro", "Libras esterlinas", "Yen japones"}));
		cboxMonedas.setToolTipText("");
		cboxMonedas.setBounds(268, 59, 89, 26);
		getContentPane().add(cboxMonedas);
		
		JLabel lblSoles = new JLabel("Soles peruano a");
		lblSoles.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoles.setBounds(144, 59, 114, 27);
		getContentPane().add(lblSoles);
		
		JLabel lblConv = new JLabel("Convertir ");
		lblConv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConv.setBounds(10, 59, 65, 27);
		getContentPane().add(lblConv);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("s/es");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(367, 59, 32, 27);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double tasa;
				Double ValorMoneda=0.00;
				String tipoMonedaConvertir = cboxMonedas.getSelectedItem().toString();
				String monedaConvertida;
				
				if(txtInsertarMoneda.getText().equals("")){
					txtResultado.setText("Ingrese monedas");
				}else {
					ValorMoneda = Double.parseDouble(txtInsertarMoneda.getText());
					switch (tipoMonedaConvertir) {
					case "Dolar":
						tasa = 0.2642;
						monedaConvertida = ConversionTasas(ValorMoneda,tasa);
						txtResultado.setText(monedaConvertida);
						break;
					case "Euro":
						tasa = 0.2486;
						monedaConvertida = ConversionTasas(ValorMoneda,tasa);
						txtResultado.setText(monedaConvertida);
						break;
					case "Libras esterlinas":
						tasa = 0.2201;
						monedaConvertida = ConversionTasas(ValorMoneda,tasa);
						txtResultado.setText(monedaConvertida);
						break;
					case "Yen japones":
						tasa = 35.9548;
						monedaConvertida = ConversionTasas(ValorMoneda,tasa);
						txtResultado.setText(monedaConvertida);
						break;
					default:
						
						break;
					}
				}
				
				
				
				
				
				
			}
		});
		btnConvertir.setIcon(new ImageIcon(frmMonedas.class.getResource("/img/icons8_Money_Circulation_48px_1.png")));
		btnConvertir.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		btnConvertir.setBounds(89, 108, 216, 49);
		getContentPane().add(btnConvertir);
		
		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtResultado.setText("resultado");
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setEditable(false);
		txtResultado.setColumns(10);
		txtResultado.setBounds(89, 174, 216, 27);
		getContentPane().add(txtResultado);
		
		JButton lblAtras = new JButton("");
		lblAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuConversor menu = new menuConversor();
				dispose();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		lblAtras.setIcon(new ImageIcon(frmMonedas.class.getResource("/img/icons8_undo_26px.png")));
		lblAtras.setBounds(364, 162, 42, 39);
		getContentPane().add(lblAtras);

	}
}
