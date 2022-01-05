package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    private String fechaPedido;
    @ManyToOne
    private Entrega entrega;
    @ManyToOne
    private Detalle detalle;
    @ManyToOne
    private Estado estado;
}
