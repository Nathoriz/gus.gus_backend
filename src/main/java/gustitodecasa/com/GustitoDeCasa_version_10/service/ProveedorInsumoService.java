package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Insumo;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Proveedor;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProveedorInsumo;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.InsumoRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProveedorInsumoRepository;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProveedorInsumoService {
    @Autowired
    private ProveedorInsumoRepository repository;
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private InsumoRepository insumoRepository;

    public List<ProveedorInsumo> listarPorProveedorId(Long id) {return repository.findAllByProveedorId(id).orElse(null);}
    public ResponseEntity<?> eliminarTodoPorProveedorId(Long id){
        Map<String, String> message = new HashMap<>();
        Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
        if( proveedor.equals(null)) {
            message.put("Mensaje","El proveedor no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.deleteAllByProveedorId(id);
        message.put("Mensaje","Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    public ProveedorInsumo guardar(ProveedorInsumo proveedorInsumo){
        Proveedor proveedor = proveedorRepository.findById(proveedorInsumo.getProveedor().getId()).orElse(null);
        Insumo insumo = insumoRepository.findById(proveedorInsumo.getInsumo().getId()).orElse(null);

        if(proveedor == null) throw new BadRequest("Ingresar proveedor");
        if(insumo == null) throw new BadRequest("Ingresar insumo");
        if(proveedorInsumo.getPrecio()==0)throw new BadRequest("Ingrese el precio");

        proveedorInsumo.setProveedor(proveedor);
        proveedorInsumo.setInsumo(insumo);
        proveedorInsumo.setPrecio(proveedorInsumo.getPrecio());
        return repository.save(proveedorInsumo);
    }
    public ResponseEntity<?> actualizar(ProveedorInsumo proveedorInsumo){
        ProveedorInsumo object = repository.findById(proveedorInsumo.getId()).orElse(null);
        if(!object.equals(null)){
            object.setProveedor(proveedorInsumo.getProveedor());
            object.setInsumo(proveedorInsumo.getInsumo());
            object.setPrecio(proveedorInsumo.getPrecio());
            repository.save(object);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    public ResponseEntity<?>  eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        ProveedorInsumo proveedorInsumo = repository.findById(id).orElse(null);
        if( proveedorInsumo.equals(null)) {
            message.put("Mensaje","El insumo del proveedor no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        repository.deleteById(id);
        message.put("Mensaje","Eliminado");
        return new ResponseEntity<>(message, HttpStatus.OK);}
    public ProveedorInsumo buscar(Long id ){
        return repository.findById( id ).orElse(null);
    }

}
