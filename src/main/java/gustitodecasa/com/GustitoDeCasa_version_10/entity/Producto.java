package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String urlimg;
    private String descripcion;
    @ManyToOne
    private Categoria categoria;
    private double precio;
    private int stock;
    @ManyToOne
    private Estado estado;
    @ManyToOne
    private Visibilidad visibilidad;
}
