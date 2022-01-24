package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Cubierta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CubiertaRepository extends JpaRepository<Cubierta,Long> {
    Cubierta findCubiertaByNombre( String nombre );
}
