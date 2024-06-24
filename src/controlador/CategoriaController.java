package controlador;

import java.awt.Color;
import java.awt.Font;
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

    // Constructor del controlador
    public CategoriaController(CategoriaView vista, CategoriaDAO modelo, Categoria categoria, RegistroCategoriaView registro,
            ModificarCategoriaView modificar, VentanaInicialView vi) {
        this.vista = vista;
        this.modelo = modelo;
        this.categoria = categoria;
        this.registro = registro;
        this.modificar = modificar;
        this.vi = vi;

        // Configuraciones visuales y de comportamiento de la vista CategoriaView
        configurarVistaCategoria();

        // Configuraciones visuales y de comportamiento de la vista RegistroCategoriaView
        configurarVistaRegistro();

        // Configuraciones visuales y de comportamiento de la vista ModificarCategoriaView
        configurarVistaModificar();
    }

    // Método privado para configurar la vista CategoriaView
    private void configurarVistaCategoria() {
        // Establece el color de fondo y centra la ventana en la pantalla
        vista.getContentPane().setBackground(new Color(240, 248, 255)); // Color de fondo azul claro
        vista.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        vista.setResizable(false); // Evita que se pueda maximizar la ventana

        // Configuración de los botones y otros componentes visuales en CategoriaView
        vista.btnVerTabla.setFont(new Font("Tahoma", Font.BOLD, 11));
        vista.btnVerTabla.setForeground(new Color(25, 25, 112));
        vista.btnVerTabla.setBackground(new Color(173, 216, 230));

        vista.btnAgregarRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
        vista.btnAgregarRegistro.setForeground(new Color(25, 25, 112));
        vista.btnAgregarRegistro.setBackground(new Color(173, 216, 230));

        vista.btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
        vista.btnEliminar.setForeground(new Color(25, 25, 112));
        vista.btnEliminar.setBackground(new Color(173, 216, 230));

        vista.btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
        vista.btnBuscar.setForeground(new Color(25, 25, 112));
        vista.btnBuscar.setBackground(new Color(173, 216, 230));

        vista.btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
        vista.btnModificar.setForeground(new Color(25, 25, 112));
        vista.btnModificar.setBackground(new Color(173, 216, 230));

        vista.btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
        vista.btnAtras.setBackground(Color.red);

        // Asignación de listeners a los botones y otros componentes en CategoriaView
        vista.btnVerTabla.addActionListener(this);
        vista.btnAgregarRegistro.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnModificar.addActionListener(this);
        vista.btnAtras.addActionListener(this);
    }

    // Método privado para configurar la vista RegistroCategoriaView
    private void configurarVistaRegistro() {
        // Centra la ventana en la pantalla y evita que se pueda maximizar
    	registro.getContentPane().setBackground(new Color(240, 248, 255)); // Color de fondo suave
        registro.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        registro.setResizable(false); // Evita que se pueda maximizar la ventana

        // Configuración de los botones y otros componentes visuales en RegistroCategoriaView
        registro.btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 14)); // Fuente y tamaño del botón
        registro.btnAgregar.setBackground(new Color(70, 130, 180)); // Color de fondo del botón
        registro.btnAgregar.setForeground(Color.WHITE); // Color del texto del botón

        registro.btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
        registro.btnAtras.setBackground(Color.RED);

        // Asignación de listeners a los botones y otros componentes en RegistroCategoriaView
        registro.btnAgregar.addActionListener(this);
        registro.btnAtras.addActionListener(this);
    }

    // Método privado para configurar la vista ModificarCategoriaView
    private void configurarVistaModificar() {
        // Centra la ventana en la pantalla y evita que se pueda maximizar
    	modificar.getContentPane().setBackground(new Color(240, 255, 240)); // Fondo verde claro
        modificar.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        modificar.setResizable(false); // Evita que se pueda maximizar la ventana

        // Configuración de los botones y otros componentes visuales en ModificarCategoriaView
        modificar.btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12)); // Fuente y tamaño del botón
        
        
        modificar.btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12)); // Fuente y tamaño del botón
        
        
        modificar.btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11)); // Fuente y tamaño del botón
        modificar.btnAtras.setBackground(Color.RED); // Color de fondo del botón

        // Asignación de listeners a los botones y otros componentes en ModificarCategoriaView
        modificar.btnModificar.addActionListener(this);
        modificar.btnBuscar.addActionListener(this);
        modificar.btnAtras.addActionListener(this);
    }

    // Método de ActionListener para manejar eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnVerTabla) {
            // Carga los productos en la tabla desde el modelo
            modelo.cargarProductosTabla(vista.model);
        }
        if (e.getSource() == vista.btnAtras) {
            // Muestra la ventana inicial y oculta la vista de categorías
            vi.setVisible(true);
            vista.setVisible(false);
        }
        if (e.getSource() == modificar.btnBuscar) {
            // Obtiene el ID ingresado y busca la categoría correspondiente en el modelo
            int id = Integer.parseInt(modificar.txtId.getText());
            categoria.setId(id);
            modelo.buscarXid(categoria);

            // Muestra los datos de la categoría encontrada en los campos de texto de ModificarCategoriaView
            modificar.txtId.setText(String.valueOf(categoria.getId()));
            modificar.txtNombre.setText(categoria.getNombre());
        }
        if (registro.btnAtras == e.getSource()) {
            // Muestra la vista de categorías y oculta la vista de registro de categoría
            vista.setVisible(true);
            registro.setVisible(false);
        }
        if (e.getSource() == vista.btnAgregarRegistro) {
            // Muestra la vista de registro de categoría y oculta la vista de categorías
            registro.setVisible(true);
            vista.setVisible(false);
        }
        if (e.getSource() == modificar.btnModificar) {
            // Obtiene los valores de los campos de texto de ModificarCategoriaView
            int id = Integer.parseInt(modificar.txtId.getText());
            String nombre = modificar.txtNombre.getText();
            // Actualiza los datos de la categoría en el modelo
            categoria.setId(id);
            categoria.setNombre(nombre);
            modelo.actualizarRegistroTabla(categoria);
            limpiarCajasTexto();
        }
        if (e.getSource() == vista.btnModificar) {
            // Muestra la vista de modificar categoría y oculta la vista de categorías
            modificar.setVisible(true);
            vista.setVisible(false);
        }
        if (modificar.btnAtras == e.getSource()) {
            // Muestra la vista de categorías y oculta la vista de modificar categoría
            vista.setVisible(true);
            modificar.setVisible(false);
        }

        if (vista.btnEliminar == e.getSource()) {
            // Elimina la categoría con el ID ingresado del modelo
            int id = Integer.parseInt(vista.txtId.getText());
            categoria.setId(id);
            modelo.eliminarRegistro(categoria);
            limpiarCajasTexto();
        }
        if (vista.btnBuscar == e.getSource()) {
            // Busca la categoría por nombre en el modelo y actualiza la tabla en CategoriaView
            String nombre = vista.txtCategoria.getText();
            categoria.setNombre(nombre);
            modelo.buscarXnombre(categoria, vista.model);
        }
        if (registro.btnAgregar == e.getSource()) {
            // Registra la nueva categoría en el modelo
            String nombre = registro.txtCategoria.getText();
            categoria.setNombre(nombre);
            modelo.registrarCategoria(categoria);
            limpiarCajasTexto();
        }
    }

    // Método para limpiar los campos de texto en ModificarCategoriaView y CategoriaView
    public void limpiarCajasTexto() {
        modificar.txtId.setText("");
        modificar.txtNombre.setText("");
        vista.txtId.setText("");
        registro.txtCategoria.setText("");
    }

}
