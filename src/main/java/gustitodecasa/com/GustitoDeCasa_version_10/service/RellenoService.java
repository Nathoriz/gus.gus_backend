package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Relleno;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Sabor;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.RellenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RellenoService {
    @Autowired
    private RellenoRepository rellenoRepository;

    public List<Relleno> listar(){
        return rellenoRepository.ListAll();
    }

    public Relleno guardar(Relleno relleno){
        if(relleno.getDescripcion().isEmpty())throw new BadRequest("Ingrese descripción");
        relleno.setDescripcion(relleno.getDescripcion());
        return rellenoRepository.save(relleno);
    }

    public ResponseEntity<?> actualizar(Relleno relleno){
        Relleno object = rellenoRepository.findById(relleno.getId()).orElse(null);
        if(!object.equals(null)){
            object.setDescripcion(relleno.getDescripcion());
            rellenoRepository.save(relleno);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public ResponseEntity<?> eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        Relleno relleno = rellenoRepository.findById(id).orElse(null);
        if (relleno.equals(null)) {
            message.put("Mensaje", "El relleno no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        rellenoRepository.deleteById(id);
        message.put("Mensaje", "Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public Relleno buscar(Long id){
        return rellenoRepository.findById(id).orElse(null);
    }
}
