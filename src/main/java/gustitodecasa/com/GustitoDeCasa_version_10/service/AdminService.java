package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.Admin;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin RegistrarAdmin( Admin admin ){
        if( admin.getNombre().isEmpty() ) throw new BadRequest( "Ingrese un nombre" );
        if( admin.getNombre() == null ) throw new BadRequest( "Ingrese un nombre" );
        admin.setNombre( admin.getNombre() );

        if( admin.getApellido().isEmpty() ) throw new BadRequest( "Ingrese un apellido" );
        if( admin.getApellido() == null ) throw new BadRequest( "Ingrese un apellido" );
        admin.setApellido( admin.getApellido() );

        if( admin.getDni().isEmpty() ) throw new BadRequest( "Ingrese un DNI" );
        if( admin.getDni() == null ) throw new BadRequest( "Ingrese un DNI" );
        else {
            if( admin.getDni().length() < 8 ) throw new BadRequest( "Ingrese correctamente el DNI (8 dígitos mínimo).");
            if( admin.getDni().length() > 8 ) throw new BadRequest( "Ingrese correctamente el DNI (8 dígitos mínimo).");
            Admin dni = adminRepository.findAdminByDni( admin.getDni() );
            if( dni != null ) throw new BadRequest( "El DNI ya está registrado en otra cuenta.");
            admin.setDni( admin.getDni() );
        }
        return adminRepository.save( admin );
    }
}
