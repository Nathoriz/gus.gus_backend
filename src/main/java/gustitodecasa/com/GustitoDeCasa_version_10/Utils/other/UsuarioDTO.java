package gustitodecasa.com.GustitoDeCasa_version_10.Utils.other;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Cliente;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Rol;
import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String contrasenia;
    private String usuario;
    private Cliente cliente;
    private Rol rol;
}
