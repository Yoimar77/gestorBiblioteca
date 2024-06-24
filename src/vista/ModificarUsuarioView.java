package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModificarUsuarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txtIdBuscar;
	public JTextField txtEmail;
	public JButton btnModificar;
	public JButton btnBuscar;
	public JLabel lblIdPrestamo;
	public JLabel lblUsuarioId;
	public JLabel lblLibroId;
	public JLabel lblFechaPrestamo;
	public JTextField txtId;
	public JTextField txtNombre;
	public JTextField txtTelefono;
	private JLabel lblIngreseElId;
	public JButton btnAtras;


	public ModificarUsuarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(240, 255, 240)); // Fondo verde claro

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdBuscar = new JTextField();
		txtIdBuscar.setBounds(154, 25, 200, 20);
		contentPane.add(txtIdBuscar);
		txtIdBuscar.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(50, 24, 89, 23);
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(199, 195, 120, 30);
		contentPane.add(btnModificar);
		
		btnAtras = new JButton("<---");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtras.setBounds(0, -4, 57, 23);
		btnAtras.setBackground(Color.red);
		contentPane.add(btnAtras);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(154, 121, 200, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblIdPrestamo = new JLabel("ID");
		lblIdPrestamo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdPrestamo.setBounds(50, 57, 140, 14);
		contentPane.add(lblIdPrestamo);
		
		lblUsuarioId = new JLabel("NOMBRE");
		lblUsuarioId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuarioId.setBounds(50, 96, 140, 14);
		contentPane.add(lblUsuarioId);
		
		lblLibroId = new JLabel("EMAIL");
		lblLibroId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLibroId.setBounds(50, 123, 140, 14);
		contentPane.add(lblLibroId);
		
		lblFechaPrestamo = new JLabel("TELEFONO");
		lblFechaPrestamo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaPrestamo.setBounds(50, 152, 140, 14);
		contentPane.add(lblFechaPrestamo);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(154, 55, 200, 20);
		contentPane.add(txtId);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(154, 90, 200, 20);
		contentPane.add(txtNombre);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(154, 150, 200, 20);
		contentPane.add(txtTelefono);
		
		lblIngreseElId = new JLabel("INGRESE EL ID DEL USUARIO");
		lblIngreseElId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseElId.setBounds(165, 11, 205, 14);
		contentPane.add(lblIngreseElId);
	}

}
