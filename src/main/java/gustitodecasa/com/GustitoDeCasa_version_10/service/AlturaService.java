package gustitodecasa.com.GustitoDeCasa_version_10.service;


import gustitodecasa.com.GustitoDeCasa_version_10.entity.Altura;
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

    public List<Altura> listarTamanio(){
        return alturaRepository.findAll();
    }

    public Altura Guardar(Altura altura){
        return alturaRepository.save(altura);

    }

    public ResponseEntity<?> Actualizar(Altura altura){
        Altura altura1 = alturaRepository.findById(altura.getId()).orElse(null);
        altura1.setDescripcion(altura.getDescripcion());
        alturaRepository.save(altura1);

        //para darle un mensaje
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Actualizacion exitosa");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public void Eliminar(Long id){
        alturaRepository.deleteById(id);
    }

}
