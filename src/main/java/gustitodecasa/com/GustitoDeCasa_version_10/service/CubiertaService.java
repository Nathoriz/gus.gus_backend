package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Cubierta;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Insumo;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.CubiertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CubiertaService {
    @Autowired
    private CubiertaRepository cubiertaRepository;
    public List<Cubierta> listar(){ return cubiertaRepository.findAll();}

    public Cubierta buscarPorNombre(String nombre){return cubiertaRepository.findCubiertaByNombre(nombre);}

    public Cubierta guardar(Cubierta cubierta){
        if(cubierta.getNombre().isEmpty())throw new BadRequest("Ingrese nombre");
        cubierta.setNombre(cubierta.getNombre());
        return cubiertaRepository.save(cubierta);
    }

    public ResponseEntity<?> actualizar(Cubierta cubierta){
        Cubierta object = cubiertaRepository.findById(cubierta.getId()).orElse(null);
        if(!object.equals(null)){
            object.setNombre(cubierta.getNombre());
            cubiertaRepository.save(cubierta);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public ResponseEntity<?> eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        Cubierta cubierta = cubiertaRepository.findById(id).orElse(null);
        if (cubierta.equals(null)) {
            message.put("Mensaje", "La cubierta no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        cubiertaRepository.deleteById(id);
        message.put("Mensaje", "Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public Cubierta buscar(Long id){
        return cubiertaRepository.findById(id).orElse(null);
    }

    public Cubierta buscarByNombre( String nombre ){
        return cubiertaRepository.findCubiertaByNombre( nombre );
    }
}
