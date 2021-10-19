package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.relleno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface rellenoRepository extends JpaRepository<relleno, Long> {
    public List<relleno> findAll();
}
