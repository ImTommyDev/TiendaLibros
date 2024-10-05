package tommy.tiendaLibros.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import tommy.tiendaLibros.entidades.Libro;

public interface LibroRepositorio extends JpaRepository<Libro,Integer> {

}
