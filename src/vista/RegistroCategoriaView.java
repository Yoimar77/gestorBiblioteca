package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegistroCategoriaView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txtCategoria;
	public JButton btnAgregar;
	public JButton btnAtras;

	public RegistroCategoriaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("NUEVA CATEGORÍA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18)); // Fuente y tamaño del título
		lblNewLabel.setBounds(120, 30, 200, 30); // Posición y tamaño del título
		contentPane.add(lblNewLabel);

		txtCategoria = new JTextField();
		txtCategoria.setBounds(50, 100, 250, 30); // Ajuste del tamaño del campo de texto
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(304, 98, 120, 30); // Ajuste del tamaño y posición del botón
		contentPane.add(btnAgregar);
		
		btnAtras = new JButton("<---");
		btnAtras.setBounds(0, 0, 57, 23);
		contentPane.add(btnAtras);
		
		
	}
}
