package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PersonalizacionPiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Personalizacion personalizacion;
    @ManyToOne
    private Piso piso;
    @ManyToOne
    private Sabor sabor;
    @ManyToOne
    private Relleno relleno;
    @ManyToOne
    private Diametro diametro;
    private double precio;
}
