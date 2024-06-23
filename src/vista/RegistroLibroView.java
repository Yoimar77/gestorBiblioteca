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

public class RegistroLibroView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtTitulo;
	public JTextField txtAutor;
	public JTextField txtEditorial;
	public JTextField txtAnioPublicacion;
	public JTextField txtIsbn;
	public JButton btnAgregar;
	public JButton btnAtras;

	public RegistroLibroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255)); // Color de fondo suave
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("NUEVO LIBRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18)); // Fuente y tamaño del título
		lblNewLabel.setBounds(160, 11, 130, 30); // Ajuste de posición y tamaño del título
		contentPane.add(lblNewLabel);

		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14)); // Fuente y tamaño de las etiquetas
		lblTitulo.setBounds(40, 60, 60, 20); // Ajuste de posición y tamaño de la etiqueta
		contentPane.add(lblTitulo);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutor.setBounds(40, 90, 60, 20);
		contentPane.add(lblAutor);

		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEditorial.setBounds(40, 120, 70, 20);
		contentPane.add(lblEditorial);

		JLabel lblAnioPublicacion = new JLabel("Año publicación:");
		lblAnioPublicacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnioPublicacion.setBounds(40, 150, 130, 20);
		contentPane.add(lblAnioPublicacion);

		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIsbn.setBounds(40, 180, 60, 20);
		contentPane.add(lblIsbn);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(160, 60, 220, 20); // Ajuste del tamaño del campo de texto
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		txtAutor = new JTextField();
		txtAutor.setColumns(10);
		txtAutor.setBounds(160, 90, 220, 20);
		contentPane.add(txtAutor);

		txtEditorial = new JTextField();
		txtEditorial.setColumns(10);
		txtEditorial.setBounds(160, 120, 220, 20);
		contentPane.add(txtEditorial);

		txtAnioPublicacion = new JTextField();
		txtAnioPublicacion.setColumns(10);
		txtAnioPublicacion.setBounds(160, 150, 220, 20);
		contentPane.add(txtAnioPublicacion);

		txtIsbn = new JTextField();
		txtIsbn.setColumns(10);
		txtIsbn.setBounds(160, 180, 220, 20);
		contentPane.add(txtIsbn);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 14)); // Fuente y tamaño del botón
		btnAgregar.setBackground(new Color(70, 130, 180)); // Color de fondo del botón
		btnAgregar.setForeground(Color.WHITE); // Color del texto del botón
		btnAgregar.setBounds(180, 220, 122, 30); // Ajuste del tamaño y posición del botón
		contentPane.add(btnAgregar);
		
		btnAtras = new JButton("<---");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtras.setBackground(Color.RED);
		btnAtras.setBounds(0, 0, 57, 23);
		contentPane.add(btnAtras);
	}

}
