package gustitodecasa.com.GustitoDeCasa_version_10.Utils.other;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.*;
import lombok.Data;

import java.util.List;

@Data
public class DetalleProductoDTO {
    private Producto producto;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Diametro> diametros;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Altura altura;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Sabor> sabores;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Relleno> rellenos;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cubierta cubierta;
}
