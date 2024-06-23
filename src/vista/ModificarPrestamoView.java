package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModificarPrestamoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtIdBuscar;
	public JTextField txtLibroId;
	public JButton btnModificar;
	public JButton btnBuscar;
	public JLabel lblTitulo;
	public JLabel lblAutor;
	public JLabel lblEditorial;
	public JLabel lblFechaPrestamo;
	public JLabel lblFechaEntrega;
	public JTextField txtUsuarioId;
	public JTextField txtFechaPrestamo;
	public JTextField txtFechaEntrega;
	private JLabel lblIngreseElId;
	public JButton btnAtras;


	public ModificarPrestamoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(240, 255, 240)); // Fondo verde claro

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdBuscar = new JTextField();
		txtIdBuscar.setBounds(183, 14, 200, 20);
		contentPane.add(txtIdBuscar);
		txtIdBuscar.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(68, 13, 89, 23);
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(208, 230, 120, 30);
		contentPane.add(btnModificar);
		
		btnAtras = new JButton("<---");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtras.setBounds(0, -4, 57, 23);
		btnAtras.setBackground(Color.red);
		contentPane.add(btnAtras);
		
		txtLibroId = new JTextField();
		txtLibroId.setBounds(183, 105, 200, 20);
		contentPane.add(txtLibroId);
		txtLibroId.setColumns(10);
		
		lblTitulo = new JLabel("USUARIO ID");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(61, 70, 140, 14);
		contentPane.add(lblTitulo);
		
		lblAutor = new JLabel("LIBRO ID");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAutor.setBounds(61, 107, 140, 14);
		contentPane.add(lblAutor);
		
		lblEditorial = new JLabel("FECHA PRÉSTAMO");
		lblEditorial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEditorial.setBounds(61, 136, 140, 14);
		contentPane.add(lblEditorial);
		
		lblFechaEntrega = new JLabel("FECHA ENTREGA");
		lblFechaEntrega.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaEntrega.setBounds(61, 161, 140, 14);
		contentPane.add(lblFechaEntrega);
		
		txtUsuarioId = new JTextField();
		txtUsuarioId.setColumns(10);
		txtUsuarioId.setBounds(183, 68, 200, 20);
		contentPane.add(txtUsuarioId);
		
		txtFechaPrestamo = new JTextField();
		txtFechaPrestamo.setColumns(10);
		txtFechaPrestamo.setBounds(183, 136, 200, 20);
		contentPane.add(txtFechaPrestamo);
		
		txtFechaEntrega = new JTextField();
		txtFechaEntrega.setColumns(10);
		txtFechaEntrega.setBounds(183, 163, 200, 20);
		contentPane.add(txtFechaEntrega);
		
		lblIngreseElId = new JLabel("INGRESE EL ID DEL PR\u00C9STAMO");
		lblIngreseElId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseElId.setBounds(183, -1, 205, 14);
		contentPane.add(lblIngreseElId);
	}

}
