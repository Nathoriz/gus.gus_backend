package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Entrega;

import java.util.List;

public interface EntregaService  {
    public List<Entrega> findAll();
    public void save (Entrega entre);
    public Entrega findById(Long id);
    public void delete (Entrega entre);

}
