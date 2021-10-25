package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    public Admin findAdminByDni( String dni );
}
