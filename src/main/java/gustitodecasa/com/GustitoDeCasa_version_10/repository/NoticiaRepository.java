package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticiaRepository extends JpaRepository<Noticias,Long> {
    List<Noticias> findNoticiasByVisibilidad_Visible( Boolean aBoolean );
    List<Noticias> findAllByNombreContainingIgnoreCase( String nombre );
}
