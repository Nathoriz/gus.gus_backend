package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class tipoproducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String cubierta;
    @ManyToOne
    private sabor sabor;
    @ManyToOne
    private diametro diametro;
    @ManyToOne
    private tamaño tamaño;
    @ManyToOne
    private relleno relleno;
}
