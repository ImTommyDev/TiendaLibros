package tommy.tiendaLibros.interfazUsuario;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class FormularioRegistro extends JFrame {
    private JLabel labelRegistro;
    private JPanel panel;
    private JTextField nombreText;
    private JTextField correoText;
    private JPasswordField passwdText;
    private JPasswordField repetirPasswdText;
    private JButton registrarButton;
    private JButton volverAtrasButton;

    public FormularioRegistro() {
        iniciarFormulario();
        volverAtrasButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                volverAtras();
            }
        });
        registrarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registrarUsuario(nombreText.getText(),correoText.getText(),passwdText.getText());
            }
        });
    }

    private void iniciarFormulario() {
        // Configuración del formulario de registro
        setTitle("Registrarme");

        // Crear el panel y configurar el layout
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);  // Espaciado alrededor de los componentes
        constraints.fill = GridBagConstraints.HORIZONTAL; // Expandir en horizontal

        // Etiqueta de nombre
        JLabel nombreLabel = new JLabel("Nombre:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nombreLabel, constraints);

        // Campo de texto para el nombre
        nombreText = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(nombreText, constraints);

        // Etiqueta de correo
        JLabel correoLabel = new JLabel("Correo:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(correoLabel, constraints);

        // Campo de texto para el correo
        correoText = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(correoText, constraints);

        // Etiqueta de contraseña
        JLabel passwdLabel = new JLabel("Contraseña:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(passwdLabel, constraints);

        // Etiqueta de contraseña
        JLabel repetirPasswdLabel = new JLabel("Repetir contraseña:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(repetirPasswdLabel, constraints);

        // Campo de texto para la contraseña (JPasswordField)
        passwdText = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(passwdText, constraints);

        // Campo de texto para la contraseña (JPasswordField)
        repetirPasswdText = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(repetirPasswdText, constraints);

        // Botón de registro
        registrarButton = new JButton("Registrar");
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(registrarButton, constraints);

        // Botón de ir atrás
        volverAtrasButton = new JButton("Volver atrás");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(volverAtrasButton, constraints);

        // Ajustes de la ventana
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setVisible(false);
        // Centrar la ventana
        setLocationRelativeTo(null);
    }

    private void volverAtras(){
        FormularioInicioSesion formularioInicioSesion = new FormularioInicioSesion();
        this.setVisible(false);
        formularioInicioSesion.setVisible(true);
    }

    private void registrarUsuario(String nombre, String correo, String passwd){
        //TODO: Primero se debe de comprobar si los textos no están vacíos (comprobaciones varias antes del insert)
        //TODO: Añadir checkbox para mostrar contraseñas
        //TODO: Crear método que compruebe si el nombre, correo y contraseña ya existen en la base de datos
    }
}
