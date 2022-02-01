package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Distrito;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Sabor;
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
        distrito.setPrecio(distrito.getPrecio());
        return distritoRepository.save(distrito);
    }

    public ResponseEntity<?> actualizar(Distrito distrito){
        Distrito object = distritoRepository.findById(distrito.getId()).orElse(null);
        if(!object.equals(null)){
            object.setNombre(distrito.getNombre());
            object.setPrecio( distrito.getPrecio() );
            distritoRepository.save(distrito);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public ResponseEntity<?> eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        Distrito distrito = distritoRepository.findById(id).orElse(null);
        if (distrito.equals(null)) {
            message.put("Mensaje", "El distrito no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        distritoRepository.deleteById(id);
        message.put("Mensaje", "Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public Distrito buscarPorNombre( String nombre ){
        return distritoRepository.findDistritoByNombre( nombre );
    }

    public Distrito buscar( Long id ){
        return distritoRepository.findDistritoById(id);
    }
}
