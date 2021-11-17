package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Sabor;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.SaborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaborService {
    @Autowired
    private SaborRepository saborRepository;

    public List<Sabor> listar(){return saborRepository.findAll();}

    public Sabor guardar(Sabor sabor){
        if(sabor.getNombre().isEmpty() || sabor.getColor().isEmpty()){
            if(sabor.getNombre().isEmpty()) throw new BadRequest("Ingrese el nombre");
            else if (sabor.getColor().isEmpty()) throw new BadRequest("Ingrese el RGB (color)");
        }
        sabor.setNombre(sabor.getNombre());
        sabor.setColor(sabor.getColor());
        return saborRepository.save(sabor);
    }

    public ResponseEntity<?> actualizar(Sabor sabor){
        Sabor object = saborRepository.findById(sabor.getId()).orElse(null);
        if(!object.equals(null)){
            object.setNombre(sabor.getNombre());
            object.setColor(sabor.getColor());
            saborRepository.save(sabor);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public void eliminar(Long id){ saborRepository.deleteById(id);}
}
