package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		ventanaPrincipal.btnCategoria.addActionListener(this);
		ventanaPrincipal.btnLibro.addActionListener(this);
		ventanaPrincipal.btnPrestamo.addActionListener(this);
		ventanaPrincipal.btnUsuario.addActionListener(this);
		ventanaPrincipal.btnSalir.addActionListener(this);

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
			int confirm = JOptionPane.showConfirmDialog(ventanaPrincipal, "¿Estás seguro de que quieres salir?", "Confirmación",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				ventanaPrincipal.dispose();
				System.exit(0); // Termina el program
			}

		}

	}
}
