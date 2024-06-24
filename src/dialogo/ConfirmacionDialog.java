package dialogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmacionDialog extends JDialog {

    private boolean respuesta; // Variable para almacenar la respuesta del usuario

    public ConfirmacionDialog(JFrame parent, String mensaje, String titulo) {
        super(parent, titulo, true); // Modalidad y título del diálogo
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(357, 158);
        setLocationRelativeTo(parent); // Centrar respecto al padre
        setResizable(false); // No se puede redimensionar

        // Calcula la posición vertical para que aparezca un poco más abajo
        int parentY = parent.getY();
        int dialogY = parentY + 150; 
        
        int parentX = parent.getX();
        int dialogX = parentX + 50; 
        
        
        // Configura la posición del diálogo
        setLocation(dialogX, dialogY);

        // Crear componentes del diálogo
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel(mensaje);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAceptar = new JButton("Salir de la biblioteca");
        btnAceptar.setForeground(Color.RED);
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                respuesta = true;
                dispose(); // Cerrar el diálogo
            }
        });
        panelBotones.add(btnAceptar);

        JButton btnCancelar = new JButton("Quedarme en la biblioteca");
        btnCancelar.setForeground(new Color(51, 102, 0));
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                respuesta = false;
                dispose(); // Cerrar el diálogo
            }
        });
        panelBotones.add(btnCancelar);

        panel.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(panel);
    }

    // Método para obtener la respuesta del diálogo
    public boolean getRespuesta() {
        return respuesta;
    }
}