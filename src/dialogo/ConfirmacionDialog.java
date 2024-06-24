package dialogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmacionDialog extends JDialog {

    private boolean respuesta; // Variable para almacenar la respuesta del usuario

    public ConfirmacionDialog(JFrame parent, String mensaje, String titulo) {
        super(parent, titulo, true); // Modalidad y t�tulo del di�logo
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(357, 158);
        setLocationRelativeTo(parent); // Centrar respecto al padre
        setResizable(false); // No se puede redimensionar

        // Calcula la posici�n vertical para que aparezca un poco m�s abajo
        int parentY = parent.getY();
        int dialogY = parentY + 150; 
        
        int parentX = parent.getX();
        int dialogX = parentX + 50; 
        
        
        // Configura la posici�n del di�logo
        setLocation(dialogX, dialogY);

        // Crear componentes del di�logo
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
                dispose(); // Cerrar el di�logo
            }
        });
        panelBotones.add(btnAceptar);

        JButton btnCancelar = new JButton("Quedarme en la biblioteca");
        btnCancelar.setForeground(new Color(51, 102, 0));
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                respuesta = false;
                dispose(); // Cerrar el di�logo
            }
        });
        panelBotones.add(btnCancelar);

        panel.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(panel);
    }

    // M�todo para obtener la respuesta del di�logo
    public boolean getRespuesta() {
        return respuesta;
    }
}