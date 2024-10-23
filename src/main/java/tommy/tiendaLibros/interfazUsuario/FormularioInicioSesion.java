package tommy.tiendaLibros.interfazUsuario;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class FormularioInicioSesion extends JFrame{
    private JLabel labelInioSesion;
    private JPanel panel;
    private JTextField correoText;
    private JPasswordField passwdText;
    private JCheckBox mostrarPasswd;
    private JButton iniciarSesButton;
    private JButton registroButton;
    private JLabel correoLabel;
    private JLabel passwdLabel;

    public FormularioInicioSesion() {
        iniciarFormulario();
        mostrarPasswd.addActionListener(e -> mostrarOcultarPasswd());
        registroButton.addActionListener(e -> {
          accerderFromRegistro();
        });
    }

    private void accerderFromRegistro() {
        //TODO: Código para acceder al formulario de registro
    }

    private void mostrarOcultarPasswd() {
        if(mostrarPasswd.isSelected()){
            passwdText.setEchoChar('\u0000');
        }else{
            passwdText.setEchoChar('*');
        }
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this,mensaje);
    }

    private void iniciarFormulario(){
        // Configuramos el panel con GridBagLayout
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);  // Espaciado alrededor de los componentes
        constraints.fill = GridBagConstraints.HORIZONTAL; // Expandir en horizontal

        // Etiqueta de correo
        correoLabel = new JLabel("Correo:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(correoLabel, constraints);

        // Campo de texto para el correo
        correoText = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(correoText, constraints);

        // Etiqueta de contraseña
        passwdLabel = new JLabel("Contraseña:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(passwdLabel, constraints);

        // Campo de texto para la contraseña (JPasswordField)
        passwdText = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(passwdText, constraints);

        // Checkbox para "mostrar contraseña"
        mostrarPasswd = new JCheckBox("Mostrar constraseña");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(mostrarPasswd, constraints);

        // Botón para iniciar sesión
        iniciarSesButton = new JButton("Iniciar sesión");
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(iniciarSesButton, constraints);

        // Botón de registro
        registroButton = new JButton("Registrarme");
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(registroButton, constraints);

        // Ajustes de la ventana
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
        // Centrar la ventana
        setLocationRelativeTo(null);
    }
}
