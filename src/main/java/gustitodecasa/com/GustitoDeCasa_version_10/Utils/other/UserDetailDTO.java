package gustitodecasa.com.GustitoDeCasa_version_10.Utils.other;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Admin;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Cliente;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Rol;
import lombok.Data;

@Data
public class UserDetailDTO {
    private Long id;
    private String usuario;
    private Admin admin;
    private Cliente cliente;
    private Rol rol;
}
