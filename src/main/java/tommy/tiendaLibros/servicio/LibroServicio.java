package tommy.tiendaLibros.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tommy.tiendaLibros.entidades.Libro;
import tommy.tiendaLibros.repositorio.LibroRepositorio;

import java.util.List;

@Service
public class LibroServicio implements InterfazLibroServicio{

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Override
    public List<Libro> mostrarLibros() {
        return libroRepositorio.findAll(); //retorna todos los libros que esten en la base de datos
    }

    @Override
    public Libro buscarLibroById(Integer idLibro) {
        Libro libro = libroRepositorio.findById(idLibro).orElse(null);
        return libro;
    }

    @Override
    public void guardarLibro(Libro libro) {
        libroRepositorio.save(libro);
    }

    @Override
    public void eliminarLibro(Libro libro) {
        libroRepositorio.delete(libro);
    }
}
