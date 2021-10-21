package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Sabor;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Tamanio;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.TipoProducto;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TipoProductoService {
    @Autowired
    private TipoProductoRepository tipoProductoRepository;
    @Autowired
    private SaborService saborService;
    @Autowired
    private RellenoService rellenoService;
    @Autowired
    private DiametroService diametroService;
    @Autowired
    private TamanioService tamanioService;

    public List<TipoProducto> listar(){return tipoProductoRepository.findAll();}

    public TipoProducto guardar(TipoProducto tipoProducto){
//        if(tipoProducto.getNombre().isEmpty() || tipoProducto.getCubierta().isEmpty() ||
//                obtenerObjeto(tipoProducto,"sabor") == null ||
//                obtenerObjeto(tipoProducto,"diametro") == null ||
//                obtenerObjeto(tipoProducto,"tamanio") == null ||
//                obtenerObjeto(tipoProducto,"relleno") == null){
//            if(tipoProducto.getNombre().isEmpty()) throw new BadRequest("Ingrese el nombre");
//            else if (tipoProducto.getCubierta().isEmpty()) throw new BadRequest("Ingrese tipo de cubierta para " + tipoProducto.getNombre());
//            else if (obtenerObjeto(tipoProducto,"sabor") == null) throw new BadRequest("Ingrese sabor");
//            else if (obtenerObjeto(tipoProducto,"diametro") == null) throw new BadRequest("Ingrese diametro");
//            else if (obtenerObjeto(tipoProducto,"tamanio") == null) throw new BadRequest("Ingrese tamanio");
//            else if (obtenerObjeto(tipoProducto,"relleno") == null) throw new BadRequest("Ingrese relleno");
//            else throw new BadRequest("Parece que algo salio mal");
//        }

        if(tipoProducto.getNombre().isEmpty() || tipoProducto.getCubierta().isEmpty()){
            if(tipoProducto.getNombre().isEmpty()) throw new BadRequest("Ingrese el nombre");
            else throw new BadRequest("Ingrese tipo de cubierta para " + tipoProducto.getNombre());
        }

        tipoProducto.setNombre(tipoProducto.getNombre());
        tipoProducto.setCubierta(tipoProducto.getCubierta());
//        tipoProducto.setSabor(tipoProducto.getSabor());
//        tipoProducto.setDiametro(tipoProducto.getDiametro());
//        tipoProducto.setTamanio(tipoProducto.getTamanio());
//        tipoProducto.setRelleno(tipoProducto.getRelleno());
        return tipoProductoRepository.save(tipoProducto);
    }

    public ResponseEntity<?> actualizar(TipoProducto tipoProducto){
        TipoProducto object = tipoProductoRepository.findById(tipoProducto.getId()).orElse(null);
        if(!object.equals(null)){
            object.setNombre(tipoProducto.getNombre());
            object.setCubierta(tipoProducto.getCubierta());
//            object.setSabor(tipoProducto.getSabor());
//            object.setDiametro(tipoProducto.getDiametro());
//            object.setTamanio(tipoProducto.getTamanio());
//            object.setRelleno(tipoProducto.getRelleno());
            tipoProductoRepository.save(object);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public void eliminar(Long id){ tipoProductoRepository.deleteById(id);}

//    private Object obtenerObjeto(TipoProducto tipoProducto, String objectname){
//        if(objectname.equals("tamanio")) return tamanioService.obtener(tipoProducto.getSabor().getId());
//        else if(objectname.equals("sabor")) return saborService.obtener(tipoProducto.getSabor().getId());
//        else if(objectname.equals("relleno")) return rellenoService.obtener(tipoProducto.getSabor().getId());
//        else if(objectname.equals("diametro")) return diametroService.obtener(tipoProducto.getSabor().getId());
//        else return null;
//    }
}
