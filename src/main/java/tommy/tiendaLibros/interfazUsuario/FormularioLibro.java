package tommy.tiendaLibros.interfazUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tommy.tiendaLibros.entidades.Libro;
import tommy.tiendaLibros.servicio.LibroServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Component
public class FormularioLibro extends JFrame {

    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private JLabel libroLabel;
    private JTextField libroTexto;
    private JLabel autorLabel;
    private JTextField autorTexto;
    private JLabel precioLabel;
    private JTextField precioTexto;
    private JLabel existenciasLabel;
    private JTextField existenciasTexto;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private DefaultTableModel tablaModeloLibros;

    @Autowired
    public FormularioLibro(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciarFormulario();
        addButton.addActionListener(e -> {
            addLibro();
        });
    }

    private void iniciarFormulario(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800,800);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimensionPantalla = toolkit.getScreenSize();
        int x = (dimensionPantalla.width - getWidth()) / 2;
        int y = (dimensionPantalla.height - getHeight()) / 2;
        setLocation(x,y);
    }

    private void createUIComponents() {
        this.tablaModeloLibros = new DefaultTableModel(0,5);
        String[] nombreColumnas = {"Id","libroLabel","Autor","Precio","Existencias"};
        this.tablaModeloLibros.setColumnIdentifiers(nombreColumnas);

        this.tablaLibros = new JTable(tablaModeloLibros);

        listarLibros();
    }

    private void listarLibros(){
        //Limpiamos la tabla
        tablaModeloLibros.setRowCount(0);
        //Obtenemos los libros
        var libros = libroServicio.mostrarLibros();
        libros.forEach((libro) -> {
            //Por cada libroLabel de la base de datos, rellenamos las columnas
            Object[] lineaLibro = {
                    libro.getIdLibro(),
                    libro.getNombreLibro(),
                    libro.getAutorLibro(),
                    libro.getPrecioLibro(),
                    libro.getCantidadLibro()
            };
            this.tablaModeloLibros.addRow(lineaLibro);
        });
    }

    private void addLibro(){
        //Primero leemos los valores del formulario
        if(libroTexto.getText().equals("")){
            mostrarMensaje("Debes indicar el nombre del libro");
            libroTexto.requestFocusInWindow();
            return;
        }

        //Guardamos los valores de los textField
        var nombreLibro = libroTexto.getText();
        var nombreAutor = autorTexto.getText();
        var precioLibro = Double.parseDouble(precioTexto.getText());
        var existencias = Integer.parseInt(existenciasTexto.getText());

        //Creamos el objeto libro
        var libro = new Libro();
        libro.setNombreLibro(nombreLibro);
        libro.setAutorLibro(nombreAutor);
        libro.setPrecioLibro(precioLibro);
        libro.setCantidadLibro(existencias);

        //Creamos el libro en la base de datos
        this.libroServicio.guardarLibro(libro);
        mostrarMensaje("Se ha añadido el libro correctamente!");
        limpiarFormulario();
        listarLibros(); //llamamos al método de listar libros para que se recargue la información de la base de datos
    }
    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje);
    }

    private void limpiarFormulario(){
        //Limpia cada uno de los elementos del formulario
        libroTexto.setText("");
        autorTexto.setText("");
        precioTexto.setText("");
        existenciasTexto.setText("");
    }
}
