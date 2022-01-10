package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Personalizacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalizacionRepository extends JpaRepository<Personalizacion,Long> {
    public Personalizacion findPersonalizacionById (Long id);
    public List<Personalizacion> findAllByCliente_Id(Long id);
}
