package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Relleno;
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

    public Relleno obtener(Long id){return rellenoRepository.getById(id);}

    public List<Relleno> listar(){return rellenoRepository.findAll();}

    public Relleno guardar(Relleno relleno){
        if(relleno.getDescripcion().isEmpty())throw new BadRequest("Ingrese descripción");
        relleno.setDescripcion(relleno.getDescripcion());
        return rellenoRepository.save(relleno);
    }

    public ResponseEntity<?> actualizar(Relleno relleno){
        Relleno object = rellenoRepository.findById(relleno.getId()).orElse(null);
        if(!object.equals(null)){
            object.setDescripcion(relleno.getDescripcion());
            rellenoRepository.save(object);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public void eliminar(Long id){ rellenoRepository.deleteById(id);}
}
