package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Visibilidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisibilidadRepository extends JpaRepository<Visibilidad, Long> {
    Visibilidad findVisibilidadById( Long id);
}
