package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Relleno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RellenoRepository extends JpaRepository<Relleno, Long> {

    @Query( value = "SELECT * FROM relleno WHERE id <> '1'", nativeQuery = true )
    List<Relleno> ListAll();
}
