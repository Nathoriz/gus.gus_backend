package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TipoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String cubierta;
    @ManyToOne
    private Sabor sabor;
    @ManyToOne
    private Diametro diametro;
    @ManyToOne
    private Tamanio tamanio;
    @ManyToOne
    private Relleno relleno;
}
