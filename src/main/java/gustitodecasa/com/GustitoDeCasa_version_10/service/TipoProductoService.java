package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.TipoProducto;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TipoProductoService {
    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    public List<TipoProducto> listar(){return tipoProductoRepository.findAll();}

    public TipoProducto guardar(TipoProducto tipoProducto){
        if(tipoProducto.getNombre().isEmpty() || tipoProducto.getCubierta().isEmpty()){
            if(tipoProducto.getNombre().isEmpty()) throw new BadRequest("Ingrese el nombre");
            else throw new BadRequest("Ingrese tipo de cubierta para " + tipoProducto.getNombre());
        }
        tipoProducto.setNombre(tipoProducto.getNombre());
        tipoProducto.setCubierta(tipoProducto.getCubierta());
        tipoProducto.setListaSabores(tipoProducto.getListaSabores());
        tipoProducto.setListaDiametros(tipoProducto.getListaDiametros());
        tipoProducto.setListaTamanios(tipoProducto.getListaTamanios());
        tipoProducto.setListaRellenos(tipoProducto.getListaRellenos());
        return tipoProductoRepository.save(tipoProducto);
    }

    public ResponseEntity<?> actualizar(TipoProducto tipoProducto){
        TipoProducto object = tipoProductoRepository.findById(tipoProducto.getId()).orElse(null);
        if(!object.equals(null)){
            object.setNombre(tipoProducto.getNombre());
            object.setCubierta(tipoProducto.getCubierta());
            object.setListaSabores(tipoProducto.getListaSabores());
            object.setListaDiametros(tipoProducto.getListaDiametros());
            object.setListaTamanios(tipoProducto.getListaTamanios());
            object.setListaRellenos(tipoProducto.getListaRellenos());
            tipoProductoRepository.save(object);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public void eliminar(Long id){ tipoProductoRepository.deleteById(id);}
}
