package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProductoSabor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @JoinColumn(name = "sabor_id", referencedColumnName = "id")
    private Sabor sabor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private Producto producto;
}
