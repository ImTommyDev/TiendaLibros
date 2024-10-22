package tommy.tiendaLibros.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import tommy.tiendaLibros.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer> {

    Usuario findByEmail(String email);
}
