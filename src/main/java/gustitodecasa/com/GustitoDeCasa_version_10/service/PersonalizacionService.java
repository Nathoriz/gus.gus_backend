package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.*;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PersonalizacionService {
    @Autowired
    private PersonalizacionRepository repository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CubiertaRepository cubiertaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private VisibilidadRepository visibilidadRepository;

    public Personalizacion buscar(Long id){ return repository.findPersonalizacionById(id);}

    public List<Personalizacion> listar(){return repository.findAll();}

    public List<Personalizacion> listarPorClienteID(Long id) {
        Cliente cliente = clienteRepository.findClienteById(id);
        if(cliente!=null) return repository.findAllByCliente_Id(cliente.getId());
        else throw new BadRequest("Cliente no existe");
    }

    public Personalizacion guardar(Personalizacion personalizacion){
        Cliente cliente = clienteRepository.findClienteById(personalizacion.getCliente().getId());
        if(cliente!=null) personalizacion.setCliente(cliente);
        else throw new BadRequest("Ingrese cliente");

        personalizacion.setNombre(personalizacion.getNombre());
        personalizacion.setDescripcion(personalizacion.getDescripcion());
        personalizacion.setUrlimg(personalizacion.getUrlimg());
        personalizacion.setPrecio(personalizacion.getPrecio());

        Cubierta cubierta = cubiertaRepository.findById(personalizacion.getCubierta().getId()).orElse(null);
        if(cubierta!=null) personalizacion.setCubierta(cubierta);
        else throw new BadRequest("Ingrese cubierta");

        Categoria categoria = categoriaRepository.findCategoriaByNombre("Personalizacion").orElse(null);
        if(categoria.getNombre().equals("Personalizacion")) personalizacion.setCategoria(categoria);
        else if(categoria.equals(null)) personalizacion.setCategoria(categoria);
        else throw new BadRequest("La categoria solo puede ser Personalizacion");

        Visibilidad visibilidad = visibilidadRepository.findVisibilidadByVisible(personalizacion.getVisibilidad().getVisible());
        if(!visibilidad.equals(null)) personalizacion.setVisibilidad(visibilidad);
        else personalizacion.setVisibilidad(visibilidadRepository.findVisibilidadByVisible(true));

        return repository.save(personalizacion);
    }

    public ResponseEntity<?> actualizar(Personalizacion personalizacion){
        Map<String, String> message = new HashMap<>();
        Personalizacion object = repository.findById(personalizacion.getId()).orElse(null);
        if(object != null){
            object.setCliente(personalizacion.getCliente());
            object.setNombre(personalizacion.getNombre());
            object.setDescripcion(personalizacion.getDescripcion());
            object.setUrlimg(personalizacion.getUrlimg());
            object.setPrecio(personalizacion.getPrecio());
            object.setCubierta(personalizacion.getCubierta());
            object.setCategoria(personalizacion.getCategoria());
            object.setVisibilidad(personalizacion.getVisibilidad());
            repository.save(object);
            message.put("Mensaje","Ok");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        message.put("Mensaje","La personalización no existe");
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> eliminar(Long id){
        Map<String, String> message = new HashMap<>();

        Personalizacion personalizacion = repository.findById(id).orElse(null);
        if(personalizacion.equals(null)) {
            message.put("Mensaje","L personalizacion no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.deleteById(id);
        message.put("Mensaje","Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
