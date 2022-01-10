package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Pedido pedido;
    @ManyToOne(optional = true)
    @JoinColumn(nullable = true)
    private Producto producto;
    @ManyToOne(optional = true)
    @JoinColumn(nullable = true)
    private Personalizacion personalizacion;
    private int cantidad;
    private double subtotal;
}
