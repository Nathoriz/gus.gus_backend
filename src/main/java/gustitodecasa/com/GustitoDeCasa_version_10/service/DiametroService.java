package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Diametro;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Distrito;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.DiametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DiametroService {
    @Autowired
    private DiametroRepository diametroRepository;

    public List<Diametro> listar(){ return diametroRepository.findAll();}

    public Diametro guardar(Diametro diametro){
        if(diametro.getDescripcion().isEmpty())throw new BadRequest("Ingrese descripción");
        if(diametro.getPrecio().isEmpty())throw new BadRequest("Ingrese precio");
        diametro.setDescripcion(diametro.getDescripcion());
        diametro.setPrecio(diametro.getPrecio());
        return diametroRepository.save(diametro);
    }

    public ResponseEntity<?> actualizar(Diametro diametro){
        Diametro object = diametroRepository.findById(diametro.getId()).orElse(null);
        if(!object.equals(null)){
            object.setDescripcion(diametro.getDescripcion());
            object.setPrecio(diametro.getPrecio());
            diametroRepository.save(diametro);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public ResponseEntity<?> eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        Diametro diametro = diametroRepository.findById(id).orElse(null);
        if (diametro.equals(null)) {
            message.put("Mensaje", "El diametro no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        diametroRepository.deleteById(id);
        message.put("Mensaje", "Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public Diametro buscar(Long id){
        return diametroRepository.findById(id).orElse(null);
    }
}
