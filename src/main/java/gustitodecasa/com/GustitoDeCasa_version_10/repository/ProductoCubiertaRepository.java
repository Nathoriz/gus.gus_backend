package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoCubierta;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProductoDiametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductoCubiertaRepository extends JpaRepository<ProductoCubierta,Long> {
    @Query(value="SELECT p FROM ProductoCubierta AS p WHERE p.producto.id = ?1")
    ProductoCubierta buscarPorProductoId(Long id);
    Optional<ProductoCubierta> findByProducto_Id(Long id);
    public void deleteByProducto_Id(Long id);

    public Optional<List<ProductoCubierta>> findAllByProducto_Id(Long id);

    @Query(value="select * from producto_cubierta as ps where ps.producto_id = ?1 And ps.cubierta_id <> 1", nativeQuery = true)
    List<ProductoCubierta> litarbyProductoId(Long id);
}
