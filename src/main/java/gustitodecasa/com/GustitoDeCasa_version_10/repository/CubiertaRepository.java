package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Cubierta;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Diametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CubiertaRepository extends JpaRepository<Cubierta,Long> {
    Cubierta findCubiertaByNombre( String nombre );
    @Query( value = "SELECT * FROM cubierta WHERE id <> '1'", nativeQuery = true )
    List<Cubierta> ListAll();
}
