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

public class frmTemperatura extends JFrame {
	private JTextField txtResultado;
	private JTextField txtIngresoTemp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTemperatura frame = new frmTemperatura();
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
	public String ConversionTasas(Double valorTemp1, String tipoTemp1,String tipoTemp2) {
		String tempSalida="";
		
		if (tipoTemp1 == "Celsius") {
			switch (tipoTemp2) {
				case "Celsius":
					tempSalida = Double.toString(valorTemp1);
					break;
				case "Fahrenheit":
					Double CtoF = valorTemp1*(9/5) + 32;
					tempSalida =  Double.toString(CtoF);
					break;
				case "Kelvin":
					Double CtoK = valorTemp1 + 273.15;
					tempSalida = Double.toString(CtoK);
					break;
				default:
					break;
				}
		}	
		else if (tipoTemp1 == "Fahrenheit" ) {
			switch (tipoTemp2) {
				case "Celsius":
					Double FtoC = (5/9)*(valorTemp1-32);
					tempSalida = Double.toString(FtoC);
					break;
				case "Fahrenheit":
					tempSalida = Double.toString(valorTemp1);
					break;
				case "Kelvin":
					Double FtoK = (5/9)*(valorTemp1-32) + 273.15;
					tempSalida = Double.toString(FtoK);
					break;
				default:
					break;
			}
		}
		else if(tipoTemp1 == "Kelvin") {	
			switch (tipoTemp2) {
				case "Celsius":
					Double KtoC = valorTemp1 - 273.15;
					tempSalida = Double.toString(KtoC);
					break;
				case "Fahrenheit":
					Double ktoF = (9/5)*(valorTemp1-273.15) + 32;
					tempSalida = Double.toString(ktoF);
					break;
				case "Kelvin":
					tempSalida = Double.toString(valorTemp1);
					break;
				default:
					break;
			}	
		}
		
		return tempSalida;
		
	}
	
	public frmTemperatura() {
		setBounds(100, 100, 498, 255);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("TEMPERATURA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulo.setBounds(154, 10, 127, 39);
		getContentPane().add(lblTitulo);
		
		JComboBox cboxTempDestino = new JComboBox();
		cboxTempDestino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboxTempDestino.setModel(new DefaultComboBoxModel(new String[] {"Celsius", "Fahrenheit", "Kelvin"}));
		cboxTempDestino.setToolTipText("");
		cboxTempDestino.setBounds(356, 59, 85, 26);
		getContentPane().add(cboxTempDestino);
		
		JComboBox cboxTemp1 = new JComboBox();
		cboxTemp1.setModel(new DefaultComboBoxModel(new String[] {"Celsius", "Fahrenheit", "Kelvin"}));
		cboxTemp1.setToolTipText("");
		cboxTemp1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboxTemp1.setBounds(230, 59, 74, 26);
		getContentPane().add(cboxTemp1);
		
		JLabel lblNewLabel_1 = new JLabel("a");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(304, 59, 42, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Convertir ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(20, 59, 65, 27);
		getContentPane().add(lblNewLabel_1_1);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double ValorTemperatura1=0.00;
				String ValorTemperatura2="";
				String tipoTemperatura1 = cboxTemp1.getSelectedItem().toString();
				String tipoTemperatura2 = cboxTempDestino.getSelectedItem().toString();
				
				
				if(txtIngresoTemp.getText().equals("")){
					txtResultado.setText("Ingrese temperatura");
				}else {
					ValorTemperatura1 = Double.parseDouble(txtIngresoTemp.getText());
					ValorTemperatura2 = ConversionTasas(ValorTemperatura1, tipoTemperatura1, tipoTemperatura2);
					txtResultado.setText(ValorTemperatura2);
				}
			}
		});
		
		
		btnConvertir.setIcon(new ImageIcon(frmTemperatura.class.getResource("/img/icons8_thermometer_26px.png")));
		btnConvertir.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		btnConvertir.setBounds(105, 110, 199, 49);
		getContentPane().add(btnConvertir);
		
		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtResultado.setText("resultado");
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setEditable(false);
		txtResultado.setEnabled(false);
		txtResultado.setColumns(10);
		txtResultado.setBounds(105, 174, 199, 27);
		getContentPane().add(txtResultado);
		
		JButton btnVolver = new JButton("");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuConversor menu = new menuConversor();
				dispose();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				
			}
		});
		btnVolver.setIcon(new ImageIcon(frmTemperatura.class.getResource("/img/icons8_undo_26px.png")));
		btnVolver.setBounds(364, 162, 42, 39);
		getContentPane().add(btnVolver);
		
		
		
		txtIngresoTemp = new JTextField();
		txtIngresoTemp.setColumns(10);
		txtIngresoTemp.setBounds(85, 59, 74, 27);
		getContentPane().add(txtIngresoTemp);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("grados");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(169, 59, 46, 27);
		getContentPane().add(lblNewLabel_1_1_1);

	}
}
