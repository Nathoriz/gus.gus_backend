package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Tamanio;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.TamanioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TamanioService {

    @Autowired
    private TamanioRepository tamanioRepository;

    public Tamanio obtener(Long id){return tamanioRepository.getById(id);}

    public List<Tamanio> listarTamanio(){
        return tamanioRepository.findAll();
    }

    public Tamanio Guardar(Tamanio tamanio){
        return tamanioRepository.save(tamanio);

    }

    public ResponseEntity<?> Actualizar(Tamanio tamanio){
        Tamanio tamanio1 = tamanioRepository.findById(tamanio.getId()).orElse(null);
        tamanio1.setDescripcion(tamanio.getDescripcion());
        tamanioRepository.save(tamanio1);

        //para darle un mensaje
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Actualizacion exitosa");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public void Eliminar(Long id){
        tamanioRepository.deleteById(id);
    }

}
