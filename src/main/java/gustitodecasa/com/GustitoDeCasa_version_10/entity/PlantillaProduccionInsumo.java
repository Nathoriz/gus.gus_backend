package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PlantillaProduccionInsumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private PlantillaProduccion plantillaProduccion;
    @ManyToOne
    private Insumo insumo;
    private String tipoUnidad;
    private int cantidadUso;
    private double costo;
}
