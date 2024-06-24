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

public class RegistroPrestamoView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txtLibroId;
	public JTextField txtUsuarioId;
	public JTextField txtFechaPrestamo;
	public JTextField txtFechaDevolucion;
	public JButton btnAgregar;
	public JButton btnAtras;

	public RegistroPrestamoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255)); // Color de fondo suave
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("NUEVO PRÉSTAMO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18)); // Fuente y tamaño del título
		lblNewLabel.setBounds(140, 11, 188, 30); // Ajuste de posición y tamaño del título
		contentPane.add(lblNewLabel);

		JLabel lblLibroId = new JLabel("Libro ID:");
		lblLibroId.setFont(new Font("Tahoma", Font.BOLD, 14)); // Fuente y tamaño de las etiquetas
		lblLibroId.setBounds(40, 60, 70, 20); // Ajuste de posición y tamaño de la etiqueta
		contentPane.add(lblLibroId);

		JLabel lblUsuarioId = new JLabel("Usuario ID:");
		lblUsuarioId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuarioId.setBounds(40, 90, 90, 20);
		contentPane.add(lblUsuarioId);

		JLabel lblFechaPrestamo = new JLabel("Fecha préstamo:");
		lblFechaPrestamo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaPrestamo.setBounds(40, 120, 130, 20);
		contentPane.add(lblFechaPrestamo);

		JLabel lblFechaDevolucion = new JLabel("Fecha devolución:");
		lblFechaDevolucion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaDevolucion.setBounds(40, 150, 140, 20);
		contentPane.add(lblFechaDevolucion);

		txtLibroId = new JTextField();
		txtLibroId.setBounds(190, 60, 200, 20); // Ajuste del tamaño del campo de texto
		contentPane.add(txtLibroId);
		txtLibroId.setColumns(10);

		txtUsuarioId = new JTextField();
		txtUsuarioId.setColumns(10);
		txtUsuarioId.setBounds(190, 90, 200, 20);
		contentPane.add(txtUsuarioId);

		txtFechaPrestamo = new JTextField();
		txtFechaPrestamo.setColumns(10);
		txtFechaPrestamo.setBounds(190, 120, 200, 20);
		contentPane.add(txtFechaPrestamo);

		txtFechaDevolucion = new JTextField();
		txtFechaDevolucion.setColumns(10);
		txtFechaDevolucion.setBounds(190, 150, 200, 20);
		contentPane.add(txtFechaDevolucion);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 14)); // Fuente y tamaño del botón
		btnAgregar.setBackground(new Color(70, 130, 180)); // Color de fondo del botón
		btnAgregar.setForeground(Color.WHITE); // Color del texto del botón
		btnAgregar.setBounds(180, 200, 122, 30); // Ajuste del tamaño y posición del botón
		contentPane.add(btnAgregar);
		
		btnAtras = new JButton("<---");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtras.setBackground(Color.RED);
		btnAtras.setBounds(0, 0, 57, 23);
		contentPane.add(btnAtras);
	}

}
