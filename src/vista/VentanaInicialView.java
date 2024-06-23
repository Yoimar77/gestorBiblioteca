package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class VentanaInicialView extends JFrame {

    private JPanel contentPane;
	public JButton btnTitulo;
	public JButton btnCategoria;
	public JButton btnLibro;
	public JButton btnPrestamo;
	public JButton btnUsuario;
	public JButton btnSalir;

    public VentanaInicialView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 248, 255)); // Color de fondo suave
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null); // Uso de layout absoluto para posicionar los componentes

        // Título de la ventana
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(70, 130, 180)); // Color de fondo azul oscuro
        panelTitulo.setBounds(0, 0, 434, 50);
        contentPane.add(panelTitulo);
        panelTitulo.setLayout(null);

        btnTitulo = new JButton("Sistema de Gestión Bibliotecaria");
        btnTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        btnTitulo.setForeground(Color.WHITE);
        btnTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnTitulo.setBounds(10, 10, 414, 30);
        btnTitulo.setContentAreaFilled(false); // Botón sin fondo
        btnTitulo.setBorderPainted(false); // Sin borde visible
        panelTitulo.add(btnTitulo);

        // Botones para las opciones
        btnCategoria = new JButton("Categor\u00EDas");
        btnCategoria.setForeground(new Color(25, 25, 112)); // Color de texto azul marino
        btnCategoria.setBackground(new Color(173, 216, 230)); // Color de fondo azul claro
        btnCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCategoria.setBounds(61, 80, 120, 40);
        contentPane.add(btnCategoria);

        btnLibro = new JButton("Libros");
        btnLibro.setForeground(new Color(25, 25, 112));
        btnLibro.setBackground(new Color(173, 216, 230));
        btnLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnLibro.setBounds(61, 140, 120, 40);
        contentPane.add(btnLibro);

        btnPrestamo = new JButton("Pr\u00E9stamos");
        btnPrestamo.setForeground(new Color(25, 25, 112));
        btnPrestamo.setBackground(new Color(173, 216, 230));
        btnPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnPrestamo.setBounds(251, 80, 120, 40);
        contentPane.add(btnPrestamo);

        btnUsuario = new JButton("Usuarios");
        btnUsuario.setForeground(new Color(25, 25, 112));
        btnUsuario.setBackground(new Color(173, 216, 230));
        btnUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnUsuario.setBounds(251, 140, 120, 40);
        contentPane.add(btnUsuario);
        
        btnSalir = new JButton("SALIR");
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSalir.setBounds(153, 205, 120, 45);
        btnSalir.setBackground(Color.red);
        contentPane.add(btnSalir);
    }
}
