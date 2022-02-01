package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Altura;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    public Optional<Categoria> findCategoriaByNombre(String nombre);
    @Query( value = "SELECT * FROM categoria WHERE nombre <> 'Todo'", nativeQuery = true )
    List<Categoria> ListAll();
}
