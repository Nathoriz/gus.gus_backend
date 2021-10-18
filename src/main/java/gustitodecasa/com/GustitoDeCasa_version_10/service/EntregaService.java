package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.entrega;

import java.util.List;

public interface EntregaService  {
    public List<entrega> findAll();
    public void save (entrega entre);
    public entrega findById(Long id);
    public void delete (entrega entre);

}
