package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Admin;
import gustitodecasa.com.GustitoDeCasa_version_10.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/admin" )
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping( "/registrar" )
    public ResponseEntity<?> resgitrarAdmin(@RequestBody Admin admin){
        return ResponseEntity.status( HttpStatus.OK ).body( adminService.RegistrarAdmin(admin) );
    }
}
