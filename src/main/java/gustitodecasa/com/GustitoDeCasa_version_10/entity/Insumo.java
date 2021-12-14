package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne
    private Proveedor proveedor;
    private String tipoUnidad;
    private double  costoPorUnidad;
    private double costoPorMayor;
    private int cantUnidad;
    private int cantMayor;
}
