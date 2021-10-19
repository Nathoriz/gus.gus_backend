package gustitodecasa.com.GustitoDeCasa_version_10.controller;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Entrega;
import gustitodecasa.com.GustitoDeCasa_version_10.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EntregaController {
    @Autowired
    private EntregaService service;

    @GetMapping("/entregas")
    public List<Entrega> index(){
        return service.findAll();
    }

    @GetMapping("/entregas/{id}")
    public Entrega Buscar(@PathVariable Long id){
        return this.service.findById(id);
    }

    @PostMapping("/entregas")
    public Entrega Crear(@RequestBody Entrega entre){
        this.service.save(entre);
        return entre;
    }

    @PutMapping("entregas/{id}")
    public Entrega Actualizar(@RequestBody Entrega entre, @PathVariable Long id){
        Entrega entregaActualizado = this.service.findById(id);
        entregaActualizado.setFecha(entre.getFecha());
        entregaActualizado.setHora(entre.getHora());
        this.service.save(entregaActualizado);
        return entregaActualizado;
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        Entrega entregaActual = this.service.findById(id);
        this.service.delete(entregaActual);
    }
}