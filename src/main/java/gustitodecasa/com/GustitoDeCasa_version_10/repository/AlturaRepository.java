package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Altura;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Diametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlturaRepository extends JpaRepository<Altura, Long> {
    Altura findAlturaByDescripcion(String descrip );
    @Query( value = "SELECT * FROM altura WHERE id <> '1'", nativeQuery = true )
    List<Altura> ListAll();
}
