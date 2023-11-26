package acceso;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.transaction.Transactional;
import modelo.Usuario;

import java.util.List;

public class AccesoUsuario  implements PanacheRepository<Usuario> {

    @Transactional
    public Usuario crear(boolean adm, String nombre, String email){

        Usuario usuario = new Usuario(adm,nombre,email);

        persistAndFlush(usuario);

        return usuario;
    }

    public Usuario obtenerPorId(Long id){
        return find("id", id).firstResult();
    }

    public List<Usuario> obtenerTodos(){
        return  listAll();
    }


}
