package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaInicialView extends JFrame {

    public JPanel contentPane;
	public JButton btnTitulo;
	public JButton btnCategoria;
	public JButton btnLibro;
	public JButton btnPrestamo;
	public JButton btnUsuario;
	public JButton btnSalir;
	public JPanel panelTitulo;

    public VentanaInicialView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null); // Uso de layout absoluto para posicionar los componentes

        // Título de la ventana
        panelTitulo = new JPanel();
        panelTitulo.setBounds(0, 0, 434, 50);
        contentPane.add(panelTitulo);
        panelTitulo.setLayout(null);

        btnTitulo = new JButton("Gestor bibliotecario Yoimar's Book Nook");
        btnTitulo.setBounds(10, 10, 414, 30);
        panelTitulo.add(btnTitulo);

        // Botones para las opciones
        btnCategoria = new JButton("Categor\u00EDas");
        btnCategoria.setBounds(61, 80, 120, 40);
        contentPane.add(btnCategoria);

        btnLibro = new JButton("Libros");
        btnLibro.setBounds(61, 140, 120, 40);
        contentPane.add(btnLibro);

        btnPrestamo = new JButton("Pr\u00E9stamos");
        btnPrestamo.setBounds(251, 80, 120, 40);
        contentPane.add(btnPrestamo);

        btnUsuario = new JButton("Usuarios");
        btnUsuario.setBounds(251, 140, 120, 40);
        contentPane.add(btnUsuario);
        
        btnSalir = new JButton("SALIR");
        btnSalir.setBounds(153, 205, 120, 45);
        contentPane.add(btnSalir);
    }
}
