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
public class PersonalizacionPisoService {
    @Autowired
    private PersonalizacionPisoRepository repository;
    @Autowired
    private PersonalizacionRepository personalizacionRepository;
    @Autowired
    private PisoRepository pisoRepository;
    @Autowired
    private SaborRepository saborRepository;
    @Autowired
    private RellenoRepository rellenoRepository;
    @Autowired
    private DiametroRepository diametroRepository;

    public List<PersonalizacionPiso> listar() {
        return repository.findAll();
    }

    public List<PersonalizacionPiso> listarPorPersonalizacionID(Long id) {
        return repository.findAllByPersonalizacion_Id(id);
    }

    public PersonalizacionPiso buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public PersonalizacionPiso guardar(PersonalizacionPiso personalizacionPiso) {
        Personalizacion personalizacion = personalizacionRepository.findPersonalizacionById(personalizacionPiso.getPersonalizacion().getId());
        if (personalizacion != null) personalizacionPiso.setPersonalizacion(personalizacion);
        else throw new BadRequest("Ingresar personalizacion");

        Piso piso = pisoRepository.findById(personalizacionPiso.getPiso().getId()).orElse(null);
        if (piso != null) personalizacionPiso.setPiso(piso);
        else throw new BadRequest("Ingresar Piso");

        Sabor sabor = saborRepository.findById(personalizacionPiso.getSabor().getId()).orElse(null);
        if (sabor != null) personalizacionPiso.setSabor(sabor);
        else throw new BadRequest("Ingresar Sabor");

        Relleno relleno = rellenoRepository.findById(personalizacionPiso.getRelleno().getId()).orElse(null);
        if (relleno != null) personalizacionPiso.setRelleno(relleno);
        else throw new BadRequest("Ingresar Relleno");

        Diametro diametro = diametroRepository.findById(personalizacionPiso.getDiametro().getId()).orElse(null);
        if (diametro != null) personalizacionPiso.setDiametro(diametro);
        else throw new BadRequest("Ingresar Diametro");

        if (personalizacionPiso.getPrecio() != 0.0) personalizacionPiso.setPrecio(personalizacionPiso.getPrecio());
        else throw new BadRequest("Ingresar precio");

        return repository.save(personalizacionPiso);
    }

    public ResponseEntity<?> actualizar(PersonalizacionPiso personalizacionPiso) {
        Map<String, String> message = new HashMap<>();
        PersonalizacionPiso object = repository.findById(personalizacionPiso.getId()).orElse(null);
        if (object != null) {
            object.setPersonalizacion(personalizacionPiso.getPersonalizacion());
            object.setPiso(personalizacionPiso.getPiso());
            object.setSabor(personalizacionPiso.getSabor());
            object.setRelleno(personalizacionPiso.getRelleno());
            object.setDiametro(personalizacionPiso.getDiametro());
            object.setPrecio(personalizacionPiso.getPrecio());
            repository.save(object);
            message.put("Mensaje", "Ok");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        message.put("Mensaje", "La personalizacion piso no existe");
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> eliminar(Long id) {
        Map<String, String> message = new HashMap<>();
        PersonalizacionPiso personalizacionPiso = repository.findById(id).orElse(null);
        if (personalizacionPiso.equals(null)) {
            message.put("Mensaje", "El piso de la personalizacion no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.deleteById(id);
        message.put("Mensaje", "Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
