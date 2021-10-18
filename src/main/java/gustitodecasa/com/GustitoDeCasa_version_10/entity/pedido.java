package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private cliente cliente;
    @OneToOne
    private entrega entrega;
    private String fecha;
    private Double monto;
    private String estado;
}
