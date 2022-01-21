package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Proveedor;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listar() {return proveedorRepository.findAll();}
    public Proveedor guardar(Proveedor proveedor){
        if(proveedor.getNombre().isEmpty())throw new BadRequest("Ingrese nombre del proveedor");
        if(proveedor.getTelefono().isEmpty())throw new BadRequest("Ingrese telefono del proveedor");
        if(proveedor.getTelefono().length()<7)throw new BadRequest("El numero ingresado es incorrecto");
        proveedor.setNombre(proveedor.getNombre());
        proveedor.setTelefono(proveedor.getTelefono());
        return proveedorRepository.save(proveedor);
    }
    public ResponseEntity<?> actualizar(Proveedor proveedor){
        Proveedor object = proveedorRepository.findById(proveedor.getId()).orElse(null);
        if(!object.equals(null)){
            object.setNombre(proveedor.getNombre());
            object.setTelefono(proveedor.getTelefono());
            proveedorRepository.save(proveedor);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    public ResponseEntity<?>  eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
        if( proveedor.equals(null)) {
            message.put("Mensaje","El proveedor no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        proveedorRepository.deleteById(id);
        message.put("Mensaje","Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);}
    public Proveedor buscar(Long id ){
        return proveedorRepository.findById( id ).orElse(null);
    }
}
