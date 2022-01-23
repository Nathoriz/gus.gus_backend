package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Diametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiametroRepository extends JpaRepository<Diametro, Long> {

    @Query( value = "SELECT * FROM diametro WHERE id <> '1'", nativeQuery = true )
    List<Diametro> ListAll();
}
