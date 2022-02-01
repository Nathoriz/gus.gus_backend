package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoDiametro;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoSabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductoDiametroRepository extends JpaRepository<ProductoDiametro, Long> {
    @Query(value="SELECT p FROM ProductoDiametro AS p WHERE p.producto.id = ?1")
    List<ProductoDiametro> listarPorProductoId(Long id);

    public void deleteAllByProductoId(Long id);
    public Optional<List<ProductoDiametro>> findAllByProducto_Id(Long id);

    @Query(value="select * from producto_diametro as ps where ps.producto_id = ?1 And ps.diametro_id <> 1", nativeQuery = true)
    List<ProductoDiametro> listarByProductoId(Long id);
}
