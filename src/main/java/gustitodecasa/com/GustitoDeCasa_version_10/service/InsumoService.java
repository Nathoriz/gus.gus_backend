package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Insumo;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InsumoService {
    @Autowired
    private InsumoRepository insumoRepository;

    public List<Insumo> listar(){return insumoRepository.findAll();}

    public Insumo buscarPorNombre(String nombre){return insumoRepository.findInsumoByNombre(nombre);}

    public Insumo guardar(Insumo insumo){
        if(insumo.getNombre().isEmpty() || insumo.getImg().isEmpty()){
            if(insumo.getNombre().isEmpty()) throw new BadRequest("Ingrese el nombre");
            else throw new BadRequest("Ingrese una imagen para " + insumo.getNombre());
        }

        insumo.setNombre(insumo.getNombre());
        insumo.setImg(insumo.getImg());
        return insumoRepository.save(insumo);
    }

    public ResponseEntity<?> actualizar(Insumo insumo){
        Insumo object = insumoRepository.findById(insumo.getId()).orElse(null);
        if(!object.equals(null)){
            object.setNombre(insumo.getNombre());
            object.setImg(insumo.getImg());
            insumoRepository.save(object);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public ResponseEntity<?> eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        Insumo insumo = insumoRepository.findById(id).orElse(null);
        if (insumo.equals(null)) {
            message.put("Mensaje", "La insumo no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        insumoRepository.deleteById(id);
        message.put("Mensaje", "Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public Insumo buscar(Long id){
        return insumoRepository.findById(id).orElse(null);
    }

}
