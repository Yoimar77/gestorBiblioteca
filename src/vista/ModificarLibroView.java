package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModificarLibroView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txtIdBuscar;
	public JTextField txtAutor;
	public JButton btnModificar;
	public JButton btnBuscar;
	public JLabel lblTitulo;
	public JLabel lblAutor;
	public JLabel lblEditorial;
	public JLabel lblAnioPublicacion;
	public JLabel lblIsbn;
	public JTextField txtId;
	public JTextField txtTitulo;
	public JTextField txtEditorial;
	public JTextField txtAnioPublicacion;
	public JTextField txtIsbn;
	private JLabel lblIngreseElNombre;
	private JLabel lblId;
	public JButton btnAtras;


	public ModificarLibroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(240, 255, 240)); // Fondo verde claro

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdBuscar = new JTextField();
		txtIdBuscar.setBounds(207, 14, 200, 20);
		contentPane.add(txtIdBuscar);
		txtIdBuscar.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(92, 13, 89, 23);
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(254, 221, 120, 30);
		contentPane.add(btnModificar);
		
		btnAtras = new JButton("<---");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtras.setBounds(0, -4, 57, 23);
		btnAtras.setBackground(Color.red);
		contentPane.add(btnAtras);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(207, 91, 200, 20);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);
		
		lblTitulo = new JLabel("TÍTULO");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(92, 70, 140, 14);
		contentPane.add(lblTitulo);
		
		lblAutor = new JLabel("AUTOR");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAutor.setBounds(92, 93, 140, 14);
		contentPane.add(lblAutor);
		
		lblEditorial = new JLabel("EDITORIAL");
		lblEditorial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEditorial.setBounds(92, 122, 140, 14);
		contentPane.add(lblEditorial);
		
		lblAnioPublicacion = new JLabel("AÑO PUBLICACIÓN");
		lblAnioPublicacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAnioPublicacion.setBounds(92, 147, 120, 14);
		contentPane.add(lblAnioPublicacion);
		
		lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIsbn.setBounds(92, 177, 140, 14);
		contentPane.add(lblIsbn);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(207, 45, 200, 20);
		contentPane.add(txtId);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(207, 68, 200, 20);
		contentPane.add(txtTitulo);
		
		txtEditorial = new JTextField();
		txtEditorial.setColumns(10);
		txtEditorial.setBounds(207, 119, 200, 20);
		contentPane.add(txtEditorial);
		
		txtAnioPublicacion = new JTextField();
		txtAnioPublicacion.setColumns(10);
		txtAnioPublicacion.setBounds(207, 144, 200, 20);
		contentPane.add(txtAnioPublicacion);
		
		txtIsbn = new JTextField();
		txtIsbn.setColumns(10);
		txtIsbn.setBounds(207, 175, 200, 20);
		contentPane.add(txtIsbn);
		
		lblIngreseElNombre = new JLabel("INGRESE EL NOMBRE DEL LIBRO");
		lblIngreseElNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseElNombre.setBounds(207, 0, 205, 14);
		contentPane.add(lblIngreseElNombre);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblId.setBounds(92, 45, 140, 14);
		contentPane.add(lblId);
	}

}
