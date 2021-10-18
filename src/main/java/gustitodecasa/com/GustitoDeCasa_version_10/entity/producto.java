package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int  stock;
    private double precio;
    private String descripcion;
    private String url;
    private String estado;
    @OneToOne
    private tipoproducto tipoproducto;

}
