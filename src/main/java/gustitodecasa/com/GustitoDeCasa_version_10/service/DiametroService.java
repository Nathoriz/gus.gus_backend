package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Diametro;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.DiametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class DiametroService {
    @Autowired
    private DiametroRepository diametroRepository;

    public List<Diametro> listar(){
        return diametroRepository.ListAll();
    }

    public Diametro guardar(Diametro diametro){
        if(diametro.getDescripcion().isEmpty())throw new BadRequest("Ingrese descripción");
        diametro.setDescripcion(diametro.getDescripcion());
        return diametroRepository.save(diametro);
    }

    public ResponseEntity<?> actualizar(Diametro diametro){
        Diametro object = diametroRepository.findById(diametro.getId()).orElse(null);
        if(!object.equals(null)){
            object.setDescripcion(diametro.getDescripcion());
            diametroRepository.save(diametro);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public void eliminar(Long id){ diametroRepository.deleteById(id);}
}
