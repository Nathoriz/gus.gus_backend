package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductoRespository extends JpaRepository<Producto, Long> {
    List<Producto> findAllByVisibilidadId(Long id);
    List<Producto> findAllByVisibilidad_IdAndCategoria_Nombre( Long id,String nombre );
    List<Producto> findAllByVisibilidad_IdAndNombreContainingIgnoreCase( Long id, String nombre );
    List<Producto> findProductoById( Long id );
    @Query(value="SELECT p from Producto AS p WHERE p.id = ?1")
    Optional<Producto> buscarPoID(Long id );
    List<Producto> findAllByNombreContainingIgnoreCase(String nombre );
}
