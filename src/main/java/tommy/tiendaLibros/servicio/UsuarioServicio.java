package tommy.tiendaLibros.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import tommy.tiendaLibros.entidades.Usuario;
import tommy.tiendaLibros.repositorio.UsuarioRepositorio;

public class UsuarioServicio implements InterfazUsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) {

        Usuario usuario = usuarioRepositorio.findByEmail(email);

        return usuario;
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioRepositorio.delete(usuario);
    }
}
