package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.NotFound;
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

        if( noticias.getVisibilidad() == null ) throw new BadRequest( "Ingrese visibilidad" );
        noticias.setVisibilidad( noticias.getVisibilidad() );

        return repository.save(noticias);
    }

    public ResponseEntity<?> actualizar(Noticias noticias){
        Map<String, String> message = new HashMap<>();
        Noticias object = repository.findById(noticias.getId()).orElse(null);
        if(!object.equals(null)){
            object.setNombre(noticias.getNombre());
            object.setImgurl(noticias.getImgurl());
            object.setObservacion(noticias.getObservacion());
            object.setVisibilidad(noticias.getVisibilidad() );

            repository.save(object);
            message.put("Mensaje","Ok");
        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public void eliminar(Long id){ repository.deleteById(id);}

    public List<Noticias> listaVisible( Boolean aBoolean ){
        return repository.findNoticiasByVisibilidad_Visible( aBoolean );
    }

    public List<Noticias> filtroNoticia( String nombre ){
        List<Noticias> lista = repository.findAllByNombreContainingIgnoreCase( nombre );
        if( lista.isEmpty() ) throw new NotFound( "404" );
        return lista;
    }
}
