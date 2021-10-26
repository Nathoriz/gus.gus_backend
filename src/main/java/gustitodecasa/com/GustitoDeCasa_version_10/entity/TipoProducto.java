package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TipoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String cubierta;
<<<<<<< HEAD

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tipoProducto")
    private List<TipoProductoSabor> tipoProductoSabores;

    @ManyToOne
    private Diametro diametro;
    @ManyToOne
    private Tamanio tamanio;
    @ManyToOne
    private Relleno relleno;
=======
    @OneToMany
    private List<Sabor> listaSabores;
    @OneToMany
    private List<Diametro> listaDiametros;
    @OneToMany
    private List<Tamanio> listaTamanios;
    @OneToMany
    private List<Relleno> listaRellenos;
>>>>>>> d94f9593bc8525f29328e24769078b14c14eb299
}
