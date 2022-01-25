package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoRelleno;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoSabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductoRellenoRepository extends JpaRepository<ProductoRelleno,Long> {
    @Query(value="SELECT p FROM ProductoRelleno AS p WHERE p.producto.id = ?1")
    List<ProductoRelleno> listarPorProductoId(Long id);

    public void deleteAllByProductoId(Long id);
    public Optional<List<ProductoRelleno>> findAllByProducto_Id(Long id);
}
