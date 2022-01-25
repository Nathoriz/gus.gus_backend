package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoSabor;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.RecetaInsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductoSaborRepository extends JpaRepository<ProductoSabor,Long> {
    @Query(value="SELECT p FROM ProductoSabor AS p WHERE p.producto.id = ?1")
    List<ProductoSabor> listarPorProductoId(Long id);

    public void deleteAllByProductoId(Long id);
    public Optional<List<ProductoSabor>> findAllByProducto_Id(Long id);
}
