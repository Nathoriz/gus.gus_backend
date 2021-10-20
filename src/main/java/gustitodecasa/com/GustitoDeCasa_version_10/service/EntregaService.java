package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Entrega;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EntregaService {



    @Autowired
    private EntregaRepository entregaRepository;

        public List<Entrega> listarEntrega(){
            return entregaRepository.findAll();
        }

        public Entrega Guardar(Entrega entrega){
            return entregaRepository.save(entrega);

        }

        public ResponseEntity<?> Actualizar(Entrega entrega){
            Entrega entrega1 = entregaRepository.findById(entrega.getId()).orElse(null);
            entrega1.setFecha(entrega.getFecha());
            entrega1.setHora(entrega.getHora());
            entregaRepository.save(entrega1);

            //para darle un mensaje
            Map<String, String> message = new HashMap<>();
            message.put("Mensaje","Actualizacion exitosa");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }

        public void Eliminar(Long id){
            entregaRepository.deleteById(id);
        }



}
