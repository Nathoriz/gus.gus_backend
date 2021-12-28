package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Noticias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imgurl;
    private String fechaCreación;
    private String observacion;
    @ManyToOne
    private Visibilidad visibilidad;
}
