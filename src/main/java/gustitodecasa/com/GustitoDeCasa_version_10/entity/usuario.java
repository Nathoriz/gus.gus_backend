package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contrasenia;
    private String usuario;
    @OneToOne
    private admin admin;
    @OneToOne
    private cliente cliente;
    @OneToOne
    private rol rol;
}
