package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.*;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.InsumoRepository;
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
public class RecetaInsumoService {
    @Autowired
    private RecetaInsumoRepository repository;
    @Autowired
    private RecetaRepository recetaRepository;
    @Autowired
    private InsumoRepository insumoRepository;

    public List<RecetaInsumo> listarPorRecetaId(Long id) {return repository.findAllByRecetaId(id).orElse(null);}
    public RecetaInsumo guardar(RecetaInsumo recetaInsumo){
        Receta receta = recetaRepository.findById(recetaInsumo.getReceta().getId()).orElse(null);
        Insumo insumo = insumoRepository.findById(recetaInsumo.getInsumo().getId()).orElse(null);

        if(receta == null) throw new BadRequest("Ingresar receta");
        if(insumo == null) throw new BadRequest("Ingresar insumo");
        if(recetaInsumo.getCantidadUso().isEmpty())throw new BadRequest("Ingrese cantida de uso");

        recetaInsumo.setReceta(receta);
        recetaInsumo.setInsumo(insumo);
        recetaInsumo.setCantidadUso(recetaInsumo.getCantidadUso());
        return repository.save(recetaInsumo);
    }
    public ResponseEntity<?> actualizar(RecetaInsumo recetaInsumo){
        RecetaInsumo object = repository.findById(recetaInsumo.getId()).orElse(null);
        if(!object.equals(null)){
            object.setReceta(recetaInsumo.getReceta());
            object.setInsumo(recetaInsumo.getInsumo());
            object.setCantidadUso(recetaInsumo.getCantidadUso());
            repository.save(object);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    public ResponseEntity<?>  eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        RecetaInsumo recetaInsumo = repository.findById(id).orElse(null);
        if( recetaInsumo.equals(null)) {
            message.put("Mensaje","El insumo no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.deleteById(id);
        message.put("Mensaje","Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);}
    public RecetaInsumo buscar(Long id ){
        return repository.findById( id ).orElse(null);
    }

}
