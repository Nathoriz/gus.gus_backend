package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Noticias;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Visibilidad;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.NoticiaRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.VisibilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticiasService {
    @Autowired
    private NoticiaRepository repository;

    @Autowired
    private VisibilidadRepository visibilidadRepository;

    public List<Noticias> listar(){return repository.findAll();}

    public Noticias guardar(Noticias noticias){
        if(noticias.getNombre().isEmpty())throw new BadRequest("Ingrese nombre");
        noticias.setNombre(noticias.getNombre());

        if(noticias.getImgurl().isEmpty())throw new BadRequest("Ingresar una imagen");
        noticias.setImgurl(noticias.getImgurl());

        if(noticias.getObservacion().isEmpty())throw new BadRequest("Ingrese descripción");
        noticias.setObservacion(noticias.getObservacion());

        if( noticias.getVisibilidad() == null ){
            Visibilidad visibilidad = visibilidadRepository.findVisibilidadById( 1L );
            noticias.setVisibilidad( visibilidad );
        }
        return repository.save(noticias);
    }

    public ResponseEntity<?> actualizar(Noticias noticias){
        Noticias object = repository.findById(noticias.getId()).orElse(null);
        if(!object.equals(null)){
            object.setNombre(noticias.getNombre());
            object.setImgurl(noticias.getImgurl());
            object.setObservacion(noticias.getObservacion());

            repository.save(noticias);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public void eliminar(Long id){ repository.deleteById(id);}
}
