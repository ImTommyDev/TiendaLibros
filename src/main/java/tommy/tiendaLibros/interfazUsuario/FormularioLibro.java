package tommy.tiendaLibros.interfazUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tommy.tiendaLibros.servicio.LibroServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Component
public class FormularioLibro extends JFrame {

    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private DefaultTableModel tablaModeloLibros;

    @Autowired
    public FormularioLibro(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciarFormulario();
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
        String[] nombreColumnas = {"Id","Libro","Autor","Precio","Existencias"};
        this.tablaModeloLibros.setColumnIdentifiers(nombreColumnas);

        this.tablaLibros = new JTable(tablaModeloLibros);
    }
}
