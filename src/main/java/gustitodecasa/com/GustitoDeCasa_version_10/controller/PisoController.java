package gustitodecasa.com.GustitoDeCasa_version_10.controller;
import gustitodecasa.com.GustitoDeCasa_version_10.service.PisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/piso" )
public class PisoController {
    @Autowired
    private PisoService pisoService;

    @GetMapping( "/listar" )
    public ResponseEntity<?> ListAll(){
        return ResponseEntity.status( HttpStatus.OK ).body( pisoService.ListAll() );
    }
}
