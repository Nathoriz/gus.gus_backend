package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Insumo;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Receta;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.RecetaInsumo;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.RecetaInsumoRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecetaService {
    @Autowired
    private RecetaRepository repository;
    @Autowired
    private RecetaInsumoRepository recetaInsumoRepository;

    public List<Receta> listar() {return repository.findAll();}
    public Receta guardar(Receta receta){
        if(receta.getDescripcion().isEmpty())throw new BadRequest("Ingrese descripcion");
        if(receta.getCostoProduccion() == 0.0)throw new BadRequest("Ingrese costo");
        if(receta.getTiempoProduccion() == 0)throw new BadRequest("Ingrese tiempo de produccion");
        receta.setDescripcion(receta.getDescripcion());
        receta.setCostoProduccion(receta.getCostoProduccion());
        receta.setTiempoProduccion(receta.getTiempoProduccion());
        return repository.save(receta);
    }
    public ResponseEntity<?> actualizar(Receta receta){
        Receta object = repository.findById(receta.getId()).orElse(null);
        if(!object.equals(null)){
            object.setDescripcion(receta.getDescripcion());
            object.setCostoProduccion(receta.getCostoProduccion());
            object.setTiempoProduccion(receta.getTiempoProduccion());
            repository.save(object);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    public ResponseEntity<?>  eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        Receta receta = repository.findById(id).orElse(null);
        if( receta.equals(null)) {
            message.put("Mensaje","La receta");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else{
            List<RecetaInsumo> recetaInsumoList = recetaInsumoRepository.findAllByRecetaId(receta.getId()).orElse(null);
            if(!recetaInsumoList.equals(null)){
                recetaInsumoRepository.deleteAllByRecetaId(receta.getId());
                repository.deleteById(id);
                message.put("Mensaje","Eliminado");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }else{
                repository.deleteById(id);
                message.put("Mensaje","Eliminado");
                return new ResponseEntity<>(message, HttpStatus.OK);
            }
        }
    }
    public Receta buscar(Long id ){
        return repository.findById( id ).orElse(null);
    }
}
