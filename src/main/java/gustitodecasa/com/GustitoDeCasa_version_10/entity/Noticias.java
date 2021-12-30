package gustitodecasa.com.GustitoDeCasa_version_10.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Noticias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imgurl;
    @PrePersist
    void Prepersist(){
        fechaCreacion = new Date();
    }
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    private String observacion;
    @ManyToOne
    private Visibilidad visibilidad;
}
