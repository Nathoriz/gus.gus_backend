package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Proveedor;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.ProveedorInsumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProveedorInsumoRepository extends JpaRepository<ProveedorInsumo,Long> {
    public void deleteAllByProveedorId(Long id);
    public Optional<List<ProveedorInsumo>> findAllByProveedorId(Long id);
}
