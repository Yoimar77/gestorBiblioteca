package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Categoria;
import modelo.CategoriaDAO;
import vista.CategoriaView;
import vista.ModificarCategoriaView;
import vista.RegistroCategoriaView;
import vista.VentanaInicialView;

public class CategoriaController implements ActionListener {
	
    private CategoriaView vista;
    private CategoriaDAO modelo;
    private Categoria categoria;
    private RegistroCategoriaView registro;
    private ModificarCategoriaView modificar;
    private VentanaInicialView vi;

    public CategoriaController(CategoriaView vista, CategoriaDAO modelo,Categoria categoria,RegistroCategoriaView registro,
    		ModificarCategoriaView modificar,VentanaInicialView vi) {
        this.vista = vista;
        this.modelo = modelo;
        this.categoria=categoria;
        
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
		if(e.getSource()==vista.btnVerTabla) {
			modelo.cargarProductosTabla(vista.model);
			
		}
		if(e.getSource()==vista.btnAtras) {
			vi.setVisible(true);
			vista.setVisible(false);
			
		}
		if(e.getSource()==modificar.btnBuscar) {
			int id = Integer.parseInt(modificar.txtId.getText());
			categoria.setId(id);
			modelo.buscarXid(categoria);
			
			modificar.txtId.setText(String.valueOf(categoria.getId()));
			modificar.txtNombre.setText(categoria.getNombre());
		}
		if(registro.btnAtras==e.getSource()) {
			vista.setVisible(true);
			registro.setVisible(false);
		}
		if(e.getSource()==vista.btnAgregarRegistro) {
			registro.setVisible(true);
			vista.setVisible(false);
		}
		if(e.getSource()==modificar.btnModificar) {
			//obtengo los valores de los campos de las cajas de texto
			int id = Integer.parseInt(modificar.txtId.getText());
			String nombre=modificar.txtNombre.getText();
			//doy los valores a los atributos de categoria
			categoria.setId(id);
			categoria.setNombre(nombre);
			//llamo al metodo que me actualiza el registro en mi base de datos
			modelo.actualizarRegistroTabla(categoria);
			limpiarCajasTexto();
		}
		if(e.getSource()==vista.btnModificar) {
			modificar.setVisible(true);
			vista.setVisible(false);	
		}
		if(modificar.btnAtras==e.getSource()) {
			vista.setVisible(true);
			modificar.setVisible(false);
		}
		
		if(vista.btnEliminar==e.getSource()) {
			int id = Integer.parseInt(vista.txtId.getText());
			categoria.setId(id);
			modelo.eliminarRegistro(categoria);	
			limpiarCajasTexto();
		}
		if(vista.btnBuscar==e.getSource()) {
			String nombre = vista.txtCategoria.getText();
			categoria.setNombre(nombre);
			
			modelo.buscarXnombre(categoria, vista.model);
			}
        if (registro.btnAgregar == e.getSource()) {
            String nombre = registro.txtCategoria.getText();
            categoria.setNombre(nombre);

            // Llama al método en el modelo para registrar la categoría
            modelo.registrarCategoria(categoria);

            // limpia los txt
            limpiarCajasTexto();
        }
        
		
	}
	public void limpiarCajasTexto() {
		modificar.txtId.setText("");
		modificar.txtNombre.setText("");
		vista.txtId.setText("");
		registro.txtCategoria.setText("");
	}

}
