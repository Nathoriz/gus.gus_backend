package gustitodecasa.com.GustitoDeCasa_version_10.service;


import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Altura;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Insumo;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.AlturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlturaService {

    @Autowired
    private AlturaRepository alturaRepository;

    public Altura buscarPorNombre(String nombre){return alturaRepository.findAlturaByDescripcion(nombre);}

    public List<Altura> listar(){
        return alturaRepository.ListAll();
    }

    public Altura guardar(Altura altura){
        if(altura.getDescripcion().isEmpty())throw new BadRequest("Ingrese descripción");
        if(altura.getPrecio().isEmpty())throw new BadRequest("Ingrese precio");
        altura.setDescripcion(altura.getDescripcion());
        altura.setPrecio(altura.getPrecio());
        return alturaRepository.save(altura);
    }

    public ResponseEntity<?> actualizar(Altura altura){
        Altura object = alturaRepository.findById(altura.getId()).orElse(null);
        if(!object.equals(null)){
            object.setDescripcion(altura.getDescripcion());
            object.setPrecio(altura.getPrecio());
            alturaRepository.save(altura);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public Altura buscar(Long id){
        return alturaRepository.findById(id).orElse(null);
    }

    public ResponseEntity<?>  eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        Altura altura = alturaRepository.findById(id).orElse(null);
        if (altura.equals(null)) {
            message.put("Mensaje", "La altura no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        alturaRepository.deleteById(id);
        message.put("Mensaje", "Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
