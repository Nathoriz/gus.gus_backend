package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Categoria;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listar(){return categoriaRepository.findAll();}

    public Categoria guardar(Categoria categoria){
        if(categoria.getNombre().isEmpty() || categoria.getUrlimg().isEmpty()){
            if(categoria.getNombre().isEmpty()) throw new BadRequest("Ingrese el nombre");
            else throw new BadRequest("Ingrese una imagen para " + categoria.getNombre());
        }
        categoria.setNombre(categoria.getNombre());
        categoria.setUrlimg(categoria.getUrlimg());
        return categoriaRepository.save(categoria);
    }

    public ResponseEntity<?> actualizar(Categoria categoria){
        Categoria object = categoriaRepository.findById(categoria.getId()).orElse(null);
        if(!object.equals(null)){
            object.setNombre(categoria.getNombre());
            object.setUrlimg(categoria.getUrlimg());
            categoriaRepository.save(object);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public void eliminar(Long id){ categoriaRepository.deleteById(id);}
}
