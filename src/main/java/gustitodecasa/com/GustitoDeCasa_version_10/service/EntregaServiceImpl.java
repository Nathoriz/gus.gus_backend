package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.dao.entregaDao;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.entrega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaServiceImpl implements EntregaService{

    @Autowired
    private entregaDao entregaDao;

    @Override
    public List<entrega> findAll() {
        return (List<entrega>) entregaDao.findAll();
    }

    @Override
    public void save(entrega entre) {
        entregaDao.save(entre);
    }

    @Override
    public entrega findById(Long id) {
        return entregaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(entrega entre) {
        entregaDao.delete(entre);
    }
}
