package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByUsuario( String username );
    boolean existsUsuarioByUsuarioAndContrasenia( String username, String password );
    boolean existsUsuarioByUsuario( String username );
    boolean existsUsuarioByContrasenia( String password );
}
