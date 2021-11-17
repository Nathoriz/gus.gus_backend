package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Personalizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Categoria categoria;
    private String nombre;
    private String descripcion;
    private String urlimg;
    @ManyToOne
    private Visibilidad visibilidad;
    private double precio;
}
