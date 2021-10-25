package gustitodecasa.com.GustitoDeCasa_version_10.Utils.other;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Admin;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Rol;
import lombok.Data;

@Data
public class AdminDTO {
    private String contrasenia;
    private String usuario;
    private Admin admin;
    private Rol rol;
}
