package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.ModificarUsuarioView;
import vista.RegistroUsuarioView;
import vista.UsuarioView;
import vista.VentanaInicialView;



public class UsuarioController implements ActionListener{
	private UsuarioView vista;
	private UsuarioDAO modelo;
	private Usuario usuario;
	private RegistroUsuarioView registro;
	private ModificarUsuarioView modificar;
	private VentanaInicialView vi;
	public UsuarioController(UsuarioView vista, UsuarioDAO modelo,Usuario usuario, RegistroUsuarioView registro,
			ModificarUsuarioView modificar,VentanaInicialView vi) {
		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;
		
        this.registro=registro;
        this.registro.btnAgregar.addActionListener(this);
        this.registro.btnAtras.addActionListener(this);
        
        this.modificar=modificar;
        this.modificar.btnModificar.addActionListener(this);
        this.modificar.btnBuscar.addActionListener(this);
        this.modificar.btnAtras.addActionListener(this);
        
		this.vi=vi;
        this.vista.btnVerTabla.addActionListener(this);
        this.vista.btnAgregarRegistro.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnAtras.addActionListener(this);

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
		if(vista.btnModificar==e.getSource()) {
			modificar.setVisible(true);
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
		if(modificar.btnAtras==e.getSource()) {
			vista.setVisible(true);
			modificar.setVisible(false);
		}
		if(e.getSource()==modificar.btnBuscar) {
			int id = Integer.parseInt(modificar.txtIdBuscar.getText());
			usuario.setId(id);
			modelo.buscarXid(usuario);
			
			modificar.txtId.setText(String.valueOf(usuario.getId()));
			modificar.txtEmail.setText(usuario.getEmail());
			modificar.txtIdBuscar.setText(String.valueOf(usuario.getId()));
			modificar.txtNombre.setText(usuario.getNombre());
			modificar.txtTelefono.setText(usuario.getTelefono());
			
		}
		if(e.getSource()==modificar.btnModificar) {
			//obtengo los valores de los campos de las cajas de texto
			int id = Integer.parseInt(modificar.txtId.getText());
			String nombre=modificar.txtNombre.getText();
			String email=modificar.txtEmail.getText();
			String telefono =modificar.txtTelefono.getText();
			
			//doy los valores a los atributos de categoria
			usuario.setId(id);
			usuario.setNombre(nombre);
			usuario.setEmail(email);
			usuario.setTelefono(telefono);
			
			//llamo al metodo que me actualiza el registro en mi base de datos
			modelo.actualizarRegistroTabla(usuario);
			limpiarCajasTexto();
		}
		if(vista.btnEliminar==e.getSource()) {
			int id = Integer.parseInt(vista.txtId.getText());
			usuario.setId(id);
			modelo.eliminarRegistro(usuario);	
			limpiarCajasTexto();
		}
		if(vista.btnBuscar==e.getSource()) {
			String nombre = vista.txtNombre.getText();
			usuario.setNombre(nombre);
			
			modelo.buscarXnombre(usuario, vista.model);
			}
		  if (registro.btnAgregar == e.getSource()) {
	            String nombre = registro.txtNombre.getText();
	            String email = registro.txtEmail.getText();
	            String telefono = registro.txtTelefono.getText();
	            int id =Integer.parseInt(registro.txtId.getText());
	            // Asigna los valores al objeto usuario
	            usuario.setNombre(nombre);
	            usuario.setEmail(email);
	            usuario.setTelefono(telefono);
	            usuario.setId(id);

	            // Llama al m�todo en el modelo para registrar el usuario
	            modelo.registrarUsuario(usuario);
	            //limpia los txt
	            limpiarCajasTexto();
	        }

	}

	private void limpiarCajasTexto() {
		modificar.txtEmail.setText("");
		modificar.txtId.setText("");
		modificar.txtNombre.setText("");
		modificar.txtTelefono.setText("");
		registro.txtEmail.setText("");
		registro.txtId.setText("");
		registro.txtNombre.setText("");
		registro.txtTelefono.setText("");
	}
}
