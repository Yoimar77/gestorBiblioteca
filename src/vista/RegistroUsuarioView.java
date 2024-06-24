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

public class RegistroUsuarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtEmail;
	public JTextField txtTelefono;
	public JButton btnAgregar;
	public JTextField txtId;
	public JButton btnAtras;
	
	public RegistroUsuarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255)); // Color de fondo suave
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NUEVO USUARIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18)); // Fuente y tamaño del título
		lblNewLabel.setBounds(150, 11, 176, 30); // Ajuste de posición y tamaño del título
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14)); // Fuente y tamaño de las etiquetas
		lblNombre.setBounds(40, 105, 70, 20); // Ajuste de posición y tamaño de la etiqueta
		contentPane.add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(40, 136, 70, 20);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(40, 167, 80, 20);
		contentPane.add(lblTelefono);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(150, 107, 220, 20); // Ajuste del tamaño del campo de texto
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(150, 138, 220, 20);
		contentPane.add(txtEmail);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(150, 169, 220, 20);
		contentPane.add(txtTelefono);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 14)); // Fuente y tamaño del botón
		btnAgregar.setBackground(new Color(70, 130, 180)); // Color de fondo del botón
		btnAgregar.setForeground(Color.WHITE); // Color del texto del botón
		btnAgregar.setBounds(180, 200, 116, 30); // Ajuste del tamaño y posición del botón
		contentPane.add(btnAgregar);
		
		JLabel lblId = new JLabel("id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(40, 72, 70, 20);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(150, 72, 220, 20);
		contentPane.add(txtId);
		
		btnAtras = new JButton("<---");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtras.setBackground(Color.RED);
		btnAtras.setBounds(0, 0, 57, 23);
		contentPane.add(btnAtras);
	}
}

