package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Visibilidad;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.VisibilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisibilidadService {
    @Autowired
    private VisibilidadRepository visibilidadRepository;

    public Visibilidad findByTryeOrFalse( Boolean aBoolean ){
        return visibilidadRepository.findVisibilidadByVisible( aBoolean );
    }
}
