package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Distrito;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DistritoService {
    @Autowired
    private DistritoRepository distritoRepository;

    public List<Distrito> listar(){return distritoRepository.findAll();}

    public Distrito guardar(Distrito distrito){
        if(distrito.getNombre().isEmpty())throw new BadRequest("Ingrese descripción");
        distrito.setNombre(distrito.getNombre());
        return distritoRepository.save(distrito);
    }

    public ResponseEntity<?> actualizar(Distrito distrito){
        Distrito object = distritoRepository.findById(distrito.getId()).orElse(null);
        if(!object.equals(null)){
            object.setNombre(distrito.getNombre());
            distritoRepository.save(distrito);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public void eliminar(Long id){ distritoRepository.deleteById(id);}
}
