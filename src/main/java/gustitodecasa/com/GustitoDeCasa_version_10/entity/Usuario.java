package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contrasenia;
    private String usuario;
    @OneToOne
    private Admin admin;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Rol rol;
}
