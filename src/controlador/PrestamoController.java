package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Libro;
import modelo.LibroDAO;
import modelo.Prestamo;
import modelo.PrestamoDAO;
import vista.PrestamoView;
import vista.ModificarLibroView;
import vista.ModificarPrestamoView;
import vista.RegistroLibroView;
import vista.RegistroPrestamoView;
import vista.VentanaInicialView;

public class PrestamoController implements ActionListener{
	private PrestamoView vista;
	private PrestamoDAO modelo;
	private Prestamo prestamo;
	private RegistroPrestamoView registro;
	private ModificarPrestamoView modificar;
	private VentanaInicialView vi;

	public PrestamoController(PrestamoView vista, PrestamoDAO modelo,Prestamo prestamo, RegistroPrestamoView registro,
			ModificarPrestamoView modificar,VentanaInicialView vi) {
		this.vista = vista;
		this.modelo = modelo;
		this.prestamo = prestamo;
        this.registro=registro;
        this.modificar=modificar;
		this.vi=vi;
        

        // Configuraciones visuales y de comportamiento de la vista PrestamoView
        configurarVistaPrestamo();

        // Configuraciones visuales y de comportamiento de la vista RegistroPrestamoView
        configurarVistaRegistro();

        // Configuraciones visuales y de comportamiento de la vista ModificarprestamoView
        configurarVistaModificar();

	}

	private void configurarVistaModificar() {
		// TODO Auto-generated method stub
		 this.modificar.btnModificar.addActionListener(this);
	     this.modificar.btnBuscar.addActionListener(this);
	     this.modificar.btnAtras.addActionListener(this);
	     // Centra la ventana en la pantalla y evita que se pueda maximizar
	     modificar.getContentPane().setBackground(new Color(240, 255, 240)); // Fondo verde claro
	     modificar.setLocationRelativeTo(null); // Centra la ventana en la pantalla
	     modificar.setResizable(false); // Evita que se pueda maximizar la ventana

	}

	private void configurarVistaRegistro() {
		// TODO Auto-generated method stub
		this.registro.btnAgregar.addActionListener(this);
        this.registro.btnAtras.addActionListener(this);
		registro.getContentPane().setBackground(new Color(240, 248, 255)); // Color de fondo suave
        registro.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        registro.setResizable(false); // Evita que se pueda maximizar la ventana
	}

	private void configurarVistaPrestamo() {
		// TODO Auto-generated method stub
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
		if(e.getSource()==vista.btnAtras) {
			vi.setVisible(true);
			vista.setVisible(false);
			
		}
		if(registro.btnAtras==e.getSource()) {
			vista.setVisible(true);
			registro.setVisible(false);
		}
		if (e.getSource() == vista.btnAgregarRegistro) {
			registro.setVisible(true);
			vista.setVisible(false);
		}
		if(e.getSource()==vista.btnModificar) {
			modificar.setVisible(true);
			vista.setVisible(false);	
		}
		if(modificar.btnAtras==e.getSource()) {
			vista.setVisible(true);
			modificar.setVisible(false);
		}
		if(e.getSource()==modificar.btnBuscar) {
			int id = Integer.parseInt(modificar.txtIdBuscar.getText());
			prestamo.setId(id);
			modelo.buscarXid(prestamo);
			
			modificar.txtLibroId.setText(String.valueOf(prestamo.getLibro_id()));
			modificar.txtUsuarioId.setText(String.valueOf(prestamo.getUsuario_id()));
			modificar.txtFechaEntrega.setText(prestamo.getFecha_devolucion());
			modificar.txtFechaPrestamo.setText(prestamo.getFecha_prestamo());
			
		}
		if(e.getSource()==modificar.btnModificar) {
			//obtengo los valores de los campos de las cajas de texto
			int libro_id = Integer.parseInt(modificar.txtLibroId.getText());
			String fecha_prestamo=modificar.txtFechaPrestamo.getText();
			String fecha_devolucion=modificar.txtFechaEntrega.getText();
			int usuario_id =Integer.parseInt(modificar.txtUsuarioId.getText());
			int id= Integer.parseInt(modificar.txtIdBuscar.getText());
			//doy los valores a los atributos de categoria
			prestamo.setLibro_id(libro_id);
			prestamo.setFecha_devolucion(fecha_devolucion);
			prestamo.setFecha_prestamo(fecha_prestamo);
			prestamo.setUsuario_id(usuario_id);
			prestamo.setId(id);
			
			
			//llamo al metodo que me actualiza el registro en mi base de datos
			modelo.actualizarRegistroTabla(prestamo);
			limpiarCajasTexto();
		}
		if(vista.btnEliminar==e.getSource()) {
			int id = Integer.parseInt(vista.txtId.getText());
			prestamo.setId(id);
			modelo.eliminarRegistro(prestamo);	
			limpiarCajasTexto();
		}
		if(vista.btnBuscar==e.getSource()) {
			int libro_id = Integer.parseInt(vista.txtIdLibro.getText());
			prestamo.setLibro_id(libro_id);
			
			modelo.buscarXlibroId(prestamo, vista.model);
			}
		if (registro.btnAgregar == e.getSource()) {
            int libroId = Integer.parseInt(registro.txtLibroId.getText());
            int usuarioId = Integer.parseInt(registro.txtUsuarioId.getText());
            String fechaPrestamo = registro.txtFechaPrestamo.getText();
            String fechaDevolucion = registro.txtFechaDevolucion.getText();

            // valores al objeto prestamo
            prestamo.setLibro_id(libroId);
            prestamo.setUsuario_id(usuarioId);
            prestamo.setFecha_prestamo(fechaPrestamo);
            prestamo.setFecha_devolucion(fechaDevolucion);

            // Llama al método en el modelo para registrar el préstamo
            modelo.registrarPrestamo(prestamo);

            // limpia los txt
            limpiarCajasTexto();

	}
}
	private void limpiarCajasTexto() {
		modificar.txtFechaEntrega.setText("");
		modificar.txtFechaPrestamo.setText("");
		modificar.txtIdBuscar.setText("");
		modificar.txtLibroId.setText("");
		modificar.txtUsuarioId.setText("");
		registro.txtFechaDevolucion.setText("");
		registro.txtFechaPrestamo.setText("");
		registro.txtLibroId.setText("");
		registro.txtUsuarioId.setText("");
	}
}
