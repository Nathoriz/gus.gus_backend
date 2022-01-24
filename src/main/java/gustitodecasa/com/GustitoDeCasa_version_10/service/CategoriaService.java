package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Categoria;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Visibilidad;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.CategoriaRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.VisibilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private VisibilidadRepository visibilidadRepository;

    public List<Categoria> listar(){return categoriaRepository.findAll();}

    public Categoria guardar(Categoria categoria){
        if(categoria.getNombre().isEmpty() || categoria.getUrlimg().isEmpty()){
            if(categoria.getNombre().isEmpty()) throw new BadRequest("Ingrese el nombre");
            else throw new BadRequest("Ingrese una imagen para " + categoria.getNombre());
        }
        Visibilidad visibilidad = visibilidadRepository.findById(categoria.getVisibilidad().getId()).orElse(visibilidadRepository.findVisibilidadByVisible(false));
        categoria.setNombre(categoria.getNombre());
        categoria.setUrlimg(categoria.getUrlimg());
        categoria.setVisibilidad(visibilidad);
        return categoriaRepository.save(categoria);
    }

    public ResponseEntity<?> actualizar(Categoria categoria){
        Categoria object = categoriaRepository.findById(categoria.getId()).orElse(null);
        if(!object.equals(null)){
            object.setNombre(categoria.getNombre());
            object.setUrlimg(categoria.getUrlimg());
            object.setVisibilidad(categoria.getVisibilidad());
            categoriaRepository.save(object);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public ResponseEntity<?> eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        if (categoria.equals(null)) {
            message.put("Mensaje", "La categoria no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        categoriaRepository.deleteById(id);
        message.put("Mensaje", "Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public Categoria buscar(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }

}
