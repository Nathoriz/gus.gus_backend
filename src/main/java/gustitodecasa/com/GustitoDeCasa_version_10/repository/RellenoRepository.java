package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Relleno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RellenoRepository extends JpaRepository<Relleno, Long> {
    public List<Relleno> findAll();
}
