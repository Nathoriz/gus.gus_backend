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
    @OneToOne
    private Sabor sabor;
    @OneToOne
    private Relleno relleno;
    @OneToOne
    private Diametro diametro;
    @OneToOne
    private Cubierta cubierta;
    private double precio;
}
