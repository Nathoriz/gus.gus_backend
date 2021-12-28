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
    private Cliente cliente;
    private String nombre;
    private String descripcion;
    private String urlimg;
    private double precio;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Visibilidad visibilidad;
}
