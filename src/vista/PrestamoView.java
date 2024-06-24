package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PrestamoView extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable table;
	public JTextField txtIdLibro;
	public JTextField txtId;
	public DefaultTableModel model;
	public JButton btnVerTabla;
	public JButton btnAgregarRegistro;
	public JButton btnEliminar;
	public JButton btnBuscar;
	private JLabel lblNewLabel_2;
	public JButton btnModificar;
	public JButton btnAtras;

	public PrestamoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 34, 366, 122);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		model=new DefaultTableModel();
		table.setModel(model);
		model.addColumn("id");
		model.addColumn("libro_id");
		model.addColumn("usuario_id");
		model.addColumn("fecha_préstamo");
		model.addColumn("fecha_devolución");
		
		scrollPane.setViewportView(table);
		
		btnVerTabla = new JButton("VER TABLA");
		btnVerTabla.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerTabla.setBounds(58, 11, 104, 23);
		contentPane.add(btnVerTabla);
		
		btnAgregarRegistro = new JButton("REGISTRAR");
		btnAgregarRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregarRegistro.setBounds(160, 193, 104, 23);
		contentPane.add(btnAgregarRegistro);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(309, 227, 104, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblNewLabel = new JLabel("Agrega un nuevo registro:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 197, 164, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEliminaUnRegistro = new JLabel("Ingresa el id del registro a eliminar:");
		lblEliminaUnRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEliminaUnRegistro.setBounds(10, 231, 202, 14);
		contentPane.add(lblEliminaUnRegistro);
		
		txtIdLibro = new JTextField();
		txtIdLibro.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtIdLibro.setText("id libro");
		txtIdLibro.setBounds(221, 12, 104, 20);
		contentPane.add(txtIdLibro);
		txtIdLibro.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(335, 11, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar por id libro");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(220, 0, 193, 14);
		contentPane.add(lblNewLabel_1);
		
		txtId = new JTextField();
		txtId.setBounds(222, 228, 77, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Modifica un registro:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 167, 132, 14);
		contentPane.add(lblNewLabel_2);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(160, 159, 104, 23);
		contentPane.add(btnModificar);
		
		btnAtras = new JButton("<---");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtras.setBounds(0, -4, 57, 23);
		btnAtras.setBackground(Color.red);
		contentPane.add(btnAtras);
		
		// Establece colores de fondo y fuente para los componentes
		setBackground(new Color(240, 248, 255)); // Color de fondo azul claro
		contentPane.setBackground(new Color(240, 248, 255));
		
		// Aplica colores y fuentes a los botones y etiquetas
		btnVerTabla.setForeground(new Color(25, 25, 112)); // Texto azul marino
		btnVerTabla.setBackground(new Color(173, 216, 230)); // Fondo azul claro
		btnAgregarRegistro.setForeground(new Color(25, 25, 112));
		btnAgregarRegistro.setBackground(new Color(173, 216, 230));
		btnEliminar.setForeground(new Color(25, 25, 112));
		btnEliminar.setBackground(new Color(173, 216, 230));
		btnBuscar.setForeground(new Color(25, 25, 112));
		btnBuscar.setBackground(new Color(173, 216, 230));
		btnModificar.setForeground(new Color(25, 25, 112));
		btnModificar.setBackground(new Color(173, 216, 230));
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblEliminaUnRegistro.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_2.setForeground(new Color(25, 25, 112));
	}


}

