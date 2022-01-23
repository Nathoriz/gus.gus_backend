package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Piso;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.PisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PisoService {
    @Autowired
    private PisoRepository pisoRepository;

    public List<Piso> ListAll(){
        return pisoRepository.findAll();
    }
}
