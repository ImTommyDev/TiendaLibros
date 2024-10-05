package tommy.tiendaLibros.servicio;

import tommy.tiendaLibros.entidades.Libro;

import java.util.List;

public interface InterfazLibroServicio {

    //Método para mostrar todos los libros
    public List<Libro> mostrarLibros();

    //Método para buscar un libro por su id
    public Libro buscarLibroById(Integer idLibro);

    //Método para guardar un libro (insertar uno nuevo o updatear alguno) (hibernate lo hace de forma automática)
    public void guardarLibro(Libro libro);

    //Método para eliminar un libro
    public void eliminarLibro(Libro libro);

}
