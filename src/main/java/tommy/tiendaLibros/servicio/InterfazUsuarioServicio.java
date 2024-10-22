package tommy.tiendaLibros.servicio;

import tommy.tiendaLibros.entidades.Usuario;

public interface InterfazUsuarioServicio {

    //Método para registrar un usuario (o updatearlo)
    void registrarUsuario(Usuario usuario);

    //Método para buscar un usuario
    Usuario buscarUsuarioPorEmail(String email);

    //Método para eliminar un usuario
    void eliminarUsuario(Usuario usuario);
}
