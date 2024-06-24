package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Libro;
import modelo.LibroDAO;
import vista.LibroView;
import vista.ModificarLibroView;
import vista.RegistroLibroView;
import vista.VentanaInicialView;

public class LibroController implements ActionListener {
	private LibroView vista;
	private LibroDAO modelo;
	private Libro libro;
	private RegistroLibroView registro;
	private ModificarLibroView modificar;
	private VentanaInicialView vi;

	public LibroController(LibroView vista, LibroDAO modelo, Libro libro, RegistroLibroView registro,
			ModificarLibroView modificar, VentanaInicialView vi) {
		this.vista = vista;
		this.modelo = modelo;
		this.libro = libro;
		this.registro = registro;
		this.modificar = modificar;
		this.vi = vi;

		
        // Configuraciones visuales y de comportamiento de la vista LibroView
        configurarVistaLibro();

        // Configuraciones visuales y de comportamiento de la vista RegistroLibroView
        configurarVistaRegistro();

        // Configuraciones visuales y de comportamiento de la vista ModificarlibroView
        configurarVistaModificar();

	}

	private void configurarVistaModificar() {
		this.modificar.btnBuscar.addActionListener(this);
		this.modificar.btnModificar.addActionListener(this);
		this.modificar.btnAtras.addActionListener(this);
        // Centra la ventana en la pantalla y evita que se pueda maximizar
    	modificar.getContentPane().setBackground(new Color(240, 255, 240)); // Fondo verde claro
        modificar.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        modificar.setResizable(false); // Evita que se pueda maximizar la ventana
		
	}

	private void configurarVistaRegistro() {
		this.registro.btnAgregar.addActionListener(this);
		this.registro.btnAtras.addActionListener(this);
		//color de fondo,centra ventana y evita maximizar ventana
		registro.getContentPane().setBackground(new Color(240, 248, 255)); // Color de fondo suave
        registro.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        registro.setResizable(false); // Evita que se pueda maximizar la ventana
		
	}

	private void configurarVistaLibro() {
		this.vista.btnVerTabla.addActionListener(this);
		this.vista.btnAgregarRegistro.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnModificar.addActionListener(this);
		this.vista.btnAtras.addActionListener(this);
		//color de fondo,centra ventana y evita maximizar ventana
        vista.getContentPane().setBackground(new Color(240, 248, 255)); // Color de fondo azul claro
        vista.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        vista.setResizable(false); // Evita que se pueda maximizar la ventana
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.btnVerTabla) {
			modelo.cargarProductosTabla(vista.model);

		}
		if (e.getSource() == vista.btnAtras) {
			vi.setVisible(true);
			vista.setVisible(false);

		}
		if (e.getSource() == vista.btnAgregarRegistro) {
			registro.setVisible(true);
			vista.setVisible(false);
		}
		if(registro.btnAtras==e.getSource()) {
			vista.setVisible(true);
			registro.setVisible(false);
		}
		if (e.getSource() == modificar.btnBuscar) {
			String titulo = modificar.txtIdBuscar.getText();
			libro.setTitulo(titulo);
			modelo.buscarXid(libro);

			modificar.txtId.setText(String.valueOf(libro.getId()));
			modificar.txtTitulo.setText(libro.getTitulo());
			modificar.txtAutor.setText(libro.getAutor());
			modificar.txtEditorial.setText(libro.getEditorial());
			modificar.txtAnioPublicacion.setText(String.valueOf(libro.getAnioPublicacion()));
			modificar.txtIsbn.setText(libro.getIsbn());

		}
		if (e.getSource() == modificar.btnModificar) {
			// obtengo los valores de los campos de las cajas de texto
			int id = Integer.parseInt(modificar.txtId.getText());
			String titulo = modificar.txtTitulo.getText();
			String autor = modificar.txtAutor.getText();
			String editorial = modificar.txtEditorial.getText();
			int anioPublicacion = Integer.parseInt(modificar.txtAnioPublicacion.getText());
			String isbn = modificar.txtIsbn.getText();
			// doy los valores a los atributos de categoria
			libro.setId(id);
			libro.setTitulo(titulo);
			libro.setAutor(autor);
			libro.setEditorial(editorial);
			libro.setAnioPublicacion(anioPublicacion);
			libro.setIsbn(isbn);

			// llamo al metodo que me actualiza el registro en mi base de datos
			modelo.actualizarRegistroTabla(libro);
			limpiarCajasTexto();
		}
		if (e.getSource() == vista.btnModificar) {
			modificar.setVisible(true);
			vista.setVisible(false);
		}
		if (modificar.btnAtras == e.getSource()) {
			vista.setVisible(true);
			modificar.setVisible(false);
		}
		if (vista.btnEliminar == e.getSource()) {
			int id = Integer.parseInt(vista.txtId.getText());
			libro.setId(id);
			modelo.eliminarRegistro(libro);
			limpiarCajasTexto();
		}
		if (vista.btnBuscar == e.getSource()) {
			String titulo = vista.txtNombre.getText();
			libro.setTitulo(titulo);

			modelo.buscarXnombre(libro, vista.model);
		}
		if (registro.btnAgregar == e.getSource()) {
			String titulo = registro.txtTitulo.getText();
			String autor = registro.txtAutor.getText();
			String editorial = registro.txtEditorial.getText();
			int anioPublicacion = Integer.parseInt(registro.txtAnioPublicacion.getText());
			String isbn = registro.txtIsbn.getText();

			// Asigna valores al objeto libro
			libro.setTitulo(titulo);
			libro.setAutor(autor);
			libro.setEditorial(editorial);
			libro.setAnioPublicacion(anioPublicacion);
			libro.setIsbn(isbn);

			// Llama al método en el modelo para registrar el libro
			modelo.registrarLibro(libro);

			limpiarCajasTexto();
		}

	}

	public void limpiarCajasTexto() {
		modificar.txtId.setText("");
		modificar.txtTitulo.setText("");
		modificar.txtAutor.setText("");
		modificar.txtEditorial.setText("");
		modificar.txtAnioPublicacion.setText("");
		modificar.txtIsbn.setText("");
		registro.txtAnioPublicacion.setText("");
		registro.txtAutor.setText("");
		registro.txtEditorial.setText("");
		registro.txtIsbn.setText("");
		registro.txtTitulo.setText("");
	}
}
