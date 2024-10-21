package tommy.tiendaLibros.interfazUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tommy.tiendaLibros.entidades.Libro;
import tommy.tiendaLibros.servicio.LibroServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JTextField idTexto;

    @Autowired
    public FormularioLibro(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciarFormulario();
        addButton.addActionListener(e -> {
            addLibro();
        });
        tablaLibros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarLibroSeleccionado();
            }
        });
        updateButton.addActionListener(e -> {
            updateLibro();
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

        //Creamos un elemento IdTexto oculto
        this.tablaModeloLibros = new DefaultTableModel(0,5);
        String[] nombreColumnas = {"Id","libroLabel","Autor","Precio","Existencias"};
        this.tablaModeloLibros.setColumnIdentifiers(nombreColumnas);

        this.tablaLibros = new JTable(tablaModeloLibros);

        listarLibros();
    }

    private void listarLibros(){
        //Limpiamos la tabla
        idTexto = new JTextField("");
        idTexto.setVisible(false);


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

    private void updateLibro(){
        if(this.idTexto.getText().equals("")){
            mostrarMensaje("Debes de seleccionar un registro");
        }else{
            //Verificamos que el nombre de el libro no sea nulo
            if(libroTexto.getText().equals("")){
                mostrarMensaje("Debes proporcionar el nombre del libro");
                libroTexto.requestFocusInWindow();
                return;
            }
            //Llenamos el objeto libro
            int idLibro = Integer.parseInt(idTexto.getText());
            var nombreLibro = libroTexto.getText();
            var nombreAutor = autorTexto.getText();
            var precioLibro = Double.parseDouble(precioTexto.getText());
            var existencias = Integer.parseInt(existenciasTexto.getText());

            var libro = new Libro(idLibro, nombreLibro, nombreAutor, precioLibro, existencias);

            libroServicio.guardarLibro(libro);
            mostrarMensaje("Se ha modificado el libro correctamente");
            listarLibros();
        }
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

    private void cargarLibroSeleccionado(){
        //Los índices de las columnas de nuestra tabla empiezan en 0
        var renglon = tablaLibros.getSelectedRow();
        if(renglon != -1){
            //Llenamos los elementos del formulario con los datos seleccionados
            String idLibro = tablaLibros.getModel().getValueAt(renglon,0).toString();
            idTexto.setText(idLibro);

            String nombreLibro = tablaLibros.getModel().getValueAt(renglon,1).toString();
            libroTexto.setText(nombreLibro);

            String autorLibro = tablaLibros.getModel().getValueAt(renglon,2).toString();
            autorTexto.setText(autorLibro);

            String precio = tablaLibros.getModel().getValueAt(renglon,3).toString();
            precioTexto.setText(precio);

            String existencias = tablaLibros.getModel().getValueAt(renglon,4).toString();
            existenciasTexto.setText(existencias);
        }
    }
}
