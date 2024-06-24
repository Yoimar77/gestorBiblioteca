package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModificarCategoriaView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txtId;
	public JTextField txtNombre;
	public JButton btnModificar;
	public JButton btnBuscar;
	public JButton btnAtras;


	public ModificarCategoriaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("MODIFICAR CATEGORÍA");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16)); // Fuente y tamaño del título
		lblTitulo.setBounds(110, 11, 224, 20); // Posición y tamaño del título
		contentPane.add(lblTitulo);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el ID de la categoría:");
		lblIngreseElId.setFont(new Font("Tahoma", Font.BOLD, 12)); // Fuente y tamaño de la etiqueta
		lblIngreseElId.setBounds(170, 64, 184, 20); // Posición y tamaño de la etiqueta
		contentPane.add(lblIngreseElId);
		
		txtId = new JTextField();
		txtId.setBounds(170, 88, 178, 20); // Ajuste del tamaño del campo de texto
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre categoría:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12)); // Fuente y tamaño de la etiqueta
		lblNombre.setBounds(30, 119, 150, 20); // Posición y tamaño de la etiqueta
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(170, 120, 178, 20); // Ajuste del tamaño del campo de texto
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(30, 87, 99, 20); // Posición y tamaño del botón
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(170, 150, 120, 30); // Posición y tamaño del botón
		contentPane.add(btnModificar);
		
		btnAtras = new JButton("<---");
		btnAtras.setBounds(0, -4, 57, 23);
		contentPane.add(btnAtras);
	}


}
