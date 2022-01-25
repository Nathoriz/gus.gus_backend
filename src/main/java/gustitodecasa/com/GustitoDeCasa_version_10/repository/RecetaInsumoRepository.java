package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.RecetaInsumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecetaInsumoRepository extends JpaRepository<RecetaInsumo,Long> {
    public void deleteAllByRecetaId(Long id);
    public Optional<List<RecetaInsumo>> findAllByRecetaId(Long id);
}
