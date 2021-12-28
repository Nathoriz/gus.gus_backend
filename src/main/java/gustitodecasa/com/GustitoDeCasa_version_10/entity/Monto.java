package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Monto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Distrito distrito;
    @ManyToOne
    private Diametro diametro;
    private double precio;

}
