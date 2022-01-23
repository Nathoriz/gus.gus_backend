package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SaborRepository extends JpaRepository<Sabor, Long> {
    Sabor findSaborByNombre( String nombre );

    @Query( value = "SELECT * FROM sabor WHERE id <> '1'", nativeQuery = true )
    List<Sabor> ListAll();
}
