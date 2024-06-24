package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import dialogo.ConfirmacionDialog;
import vista.CategoriaView;
import vista.LibroView;
import vista.PrestamoView;
import vista.UsuarioView;
import vista.VentanaInicialView;

public class VentanaInicialController implements ActionListener {
	private VentanaInicialView ventanaPrincipal;
	private CategoriaView ventanaCategoria;
	private UsuarioView ventanaUsuario;
	private PrestamoView ventanaPrestamo;
	private LibroView ventanaLibro;

	public VentanaInicialController(VentanaInicialView ventanaPrincipal, CategoriaView ventanaCategoria,
			UsuarioView ventanaUsuario, PrestamoView ventanaPrestamo, LibroView ventanaLibro) {
		this.ventanaPrincipal = ventanaPrincipal;
		this.ventanaCategoria = ventanaCategoria;
		this.ventanaLibro = ventanaLibro;
		this.ventanaPrestamo = ventanaPrestamo;
		this.ventanaUsuario = ventanaUsuario;
		

		configurarVistaVentanaPrincipal();

	}



	private void configurarVistaVentanaPrincipal() {
		// TODO Auto-generated method stub
		ventanaPrincipal.btnCategoria.addActionListener(this);
		ventanaPrincipal.btnLibro.addActionListener(this);
		ventanaPrincipal.btnPrestamo.addActionListener(this);
		ventanaPrincipal.btnUsuario.addActionListener(this);
		ventanaPrincipal.btnSalir.addActionListener(this);
		
		ventanaPrincipal.getContentPane().setBackground(new Color(240, 248, 255)); // Color de fondo suave
		ventanaPrincipal.setLocationRelativeTo(null); // Centra la ventana en la pantalla
		ventanaPrincipal.setResizable(false); // Evita que se pueda maximizar la ventana
		ventanaPrincipal.setTitle("Ventana Inicio");
		
		ventanaPrincipal.panelTitulo.setBackground(new Color(70, 130, 180)); // Color de fondo azul oscuro del panel titulo
		
		ventanaPrincipal.btnTitulo.setContentAreaFilled(false); // Botón sin fondo
		ventanaPrincipal.btnTitulo.setBorderPainted(false); // Sin borde visible
		ventanaPrincipal.btnTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		ventanaPrincipal.btnTitulo.setForeground(Color.WHITE);
		ventanaPrincipal.btnTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        
		ventanaPrincipal.btnCategoria.setForeground(new Color(25, 25, 112)); // Color de texto azul marino
		ventanaPrincipal.btnCategoria.setContentAreaFilled(false); // Botón sin fondo
		ventanaPrincipal.btnCategoria.setBorderPainted(false); // Sin borde visible
		ventanaPrincipal.btnCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
		ventanaPrincipal.btnLibro.setForeground(new Color(25, 25, 112)); // Color de texto azul marino
		ventanaPrincipal.btnLibro.setContentAreaFilled(false); // Botón sin fondo
		ventanaPrincipal.btnLibro.setBorderPainted(false); // Sin borde visible
		ventanaPrincipal.btnLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
		ventanaPrincipal.btnPrestamo.setForeground(new Color(25, 25, 112)); // Color de texto azul marino
		ventanaPrincipal.btnPrestamo.setContentAreaFilled(false); // Botón sin fondo
		ventanaPrincipal.btnPrestamo.setBorderPainted(false); // Sin borde visible
		ventanaPrincipal.btnPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
		ventanaPrincipal.btnUsuario.setForeground(new Color(25, 25, 112)); // Color de texto azul marino
		ventanaPrincipal.btnUsuario.setContentAreaFilled(false); // Botón sin fondo
		ventanaPrincipal.btnUsuario.setBorderPainted(false); // Sin borde visible
		ventanaPrincipal.btnUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
		ventanaPrincipal.btnSalir.setForeground(Color.RED); // Color de texto rojo
		ventanaPrincipal.btnSalir.setContentAreaFilled(false); // Botón sin fondo
		ventanaPrincipal.btnSalir.setBorderPainted(false); // Sin borde visible
		ventanaPrincipal.btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
        
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (ventanaPrincipal.btnCategoria == e.getSource()) {
			ventanaCategoria.setVisible(true);
			ventanaPrincipal.setVisible(false);

		}
		if (ventanaPrincipal.btnLibro == e.getSource()) {
			ventanaLibro.setVisible(true);
			ventanaPrincipal.setVisible(false);

		}
		if (ventanaPrincipal.btnPrestamo == e.getSource()) {
			ventanaPrestamo.setVisible(true);
			ventanaPrincipal.setVisible(false);

		}
		if (ventanaPrincipal.btnUsuario == e.getSource()) {
			ventanaUsuario.setVisible(true);
			ventanaPrincipal.setVisible(false);

		}
		if (ventanaPrincipal.btnSalir == e.getSource()) {
            // Utilizar el diálogo personalizado
            ConfirmacionDialog dialogo = new ConfirmacionDialog(ventanaPrincipal, "¿Vas a salir de Yoimar's Book Nook?",
                    "Confirmación");
            dialogo.setVisible(true); // Mostrar el diálogo

            // Obtener la respuesta del diálogo
            boolean confirm = dialogo.getRespuesta();

            if (confirm) {
                ventanaPrincipal.dispose();
                System.exit(0);
            }

		}

	}
}
