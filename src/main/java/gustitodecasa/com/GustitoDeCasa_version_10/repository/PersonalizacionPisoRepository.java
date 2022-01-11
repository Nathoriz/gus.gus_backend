package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.PersonalizacionPiso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalizacionPisoRepository extends JpaRepository<PersonalizacionPiso,Long> {
    public List<PersonalizacionPiso> findAllByPersonalizacion_Id(Long id);

}
