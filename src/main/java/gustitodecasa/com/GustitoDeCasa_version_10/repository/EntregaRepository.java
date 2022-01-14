package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    Entrega findEntregaById( Long id );
}
