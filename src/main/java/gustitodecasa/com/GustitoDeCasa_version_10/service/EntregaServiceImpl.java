package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.dao.entregaDao;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Entrega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaServiceImpl implements EntregaService{

    @Autowired
    private entregaDao entregaDao;

    @Override
    public List<Entrega> findAll() {
        return (List<Entrega>) entregaDao.findAll();
    }

    @Override
    public void save(Entrega entre) {
        entregaDao.save(entre);
    }

    @Override
    public Entrega findById(Long id) {
        return entregaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Entrega entre) {
        entregaDao.delete(entre);
    }
}
