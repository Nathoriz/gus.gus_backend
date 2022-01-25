package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.Utils.other.DetalleProductoDTO;
import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.BadRequest;
import gustitodecasa.com.GustitoDeCasa_version_10.config.Error.exceptions.NotFound;
import gustitodecasa.com.GustitoDeCasa_version_10.entity.*;
import gustitodecasa.com.GustitoDeCasa_version_10.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductoService {

    @Autowired
    private ProductoRespository productoRespository;
    @Autowired
    private RecetaRepository recetaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AlturaRepository alturaRepository;
    @Autowired
    private CubiertaRepository cubiertaRepository;
    @Autowired
    private DiametroRepository diametroRepository;
    @Autowired
    private RellenoRepository rellenoRepository;
    @Autowired
    private SaborRepository saborRepository;

    @Autowired
    private ProductoAlturaRepository productoAlturaRepository;
    @Autowired
    private ProductoCubiertaRepository productoCubiertaRepository;
    @Autowired
    private ProductoDiametroRepository productoDiametroRepository;
    @Autowired
    private ProductoRellenoRepository productoRellenoRepository;
    @Autowired
    private ProductoSaborRepository productoSaborRepository;

    public List<Producto> listar(){
        return productoRespository.findAll();
    }

    public List<Producto> ListarProductosVisibles(){
        return productoRespository.findAllByVisibilidadId(1L);
    }

    public List<Producto> listarProductosVisiblesPorCategoria( String categoria ){
        List<Producto> producto =  productoRespository.findAllByVisibilidad_IdAndCategoria_Nombre(1L, categoria );

        if( producto.isEmpty() ){
            return producto;
        }

        return producto;
    }

    public List<Producto> filtroProductos( String nombre ){
        List<Producto>  lista = productoRespository.findAllByVisibilidad_IdAndNombreContainingIgnoreCase(1L, nombre );
        if( lista.isEmpty() ) throw new NotFound( "404" );
        return lista;
    }

    public ResponseEntity<?> detalleProducto(Long id){
        Map<String, Object> response = new HashMap<>();
        Producto producto = productoRespository.findById(id).orElse(null);
        DetalleProductoDTO detalleProductoDTO = new DetalleProductoDTO();

        if(producto!=null) {
            List<Diametro> diametros= new ArrayList<>();
            List<Sabor> sabores= new ArrayList<>();
            List<Relleno> rellenos= new ArrayList<>();

            ProductoAltura productoAltura = productoAlturaRepository.buscarPorProductoId(id);
            ProductoCubierta productoCubierta = productoCubiertaRepository.buscarPorProductoId(id);

            List<ProductoDiametro> productoDiametros = productoDiametroRepository.listarPorProductoId(id);
            List<ProductoSabor> productoSabores = productoSaborRepository.listarPorProductoId(id);
            List<ProductoRelleno> productoRellenos = productoRellenoRepository.listarPorProductoId(id);

            if(productoAltura == null) {detalleProductoDTO.setAltura(alturaRepository.getById(1L));}else{
                Altura altura = alturaRepository.findById(productoAltura.getAltura().getId()).orElse(alturaRepository.getById(1L));
                detalleProductoDTO.setAltura(altura);
            }

            if(productoCubierta == null) {detalleProductoDTO.setCubierta(cubiertaRepository.getById(1L));}else {
                Cubierta cubierta = cubiertaRepository.findById(productoCubierta.getCubierta().getId()).orElse(cubiertaRepository.getById(1L));
                detalleProductoDTO.setCubierta(cubierta);
            }

            if(productoDiametros.isEmpty()) {
               diametros.add(diametroRepository.getById(1L));
               detalleProductoDTO.setDiametros(diametros);
            }

            if(productoSabores.isEmpty()) {
                sabores.add(saborRepository.getById(1L));
                detalleProductoDTO.setSabores(sabores);
            }

            if(productoRellenos.isEmpty()) {
                rellenos.add(rellenoRepository.getById(1L));
                detalleProductoDTO.setRellenos(rellenos);
            }


            for(ProductoDiametro productoDiametro:productoDiametros){
                diametros.add(productoDiametro.getDiametro());
            }

            for(ProductoSabor productoSabor:productoSabores){
                sabores.add(productoSabor.getSabor());
            }

            for(ProductoRelleno productoRelleno:productoRellenos){
                rellenos.add(productoRelleno.getRelleno());
            }

            detalleProductoDTO.setProducto(producto);
            detalleProductoDTO.setDiametros(diametros);
            detalleProductoDTO.setSabores(sabores);
            detalleProductoDTO.setRellenos(rellenos);

            response.put("detalle",detalleProductoDTO);

            return new ResponseEntity<>( response, HttpStatus.OK );
        }else{
            return new ResponseEntity<>( "error", HttpStatus.BAD_REQUEST );
        }
    }

    public List<Producto> findForid( Long id ){
        return productoRespository.findProductoById( id );
    }

    public Producto guardar(Producto producto){
        if(producto.getDescripcion().isEmpty())throw new BadRequest("Ingrese descripcion");
        if(producto.getNombre().isEmpty())throw new BadRequest("Ingrese costo");
        if(producto.getPrecio()  == 0.0)throw new BadRequest("Ingrese descripcion");
        if(producto.getUrlimg().isEmpty())throw new BadRequest("Suba una imagen");

        Categoria categoria = categoriaRepository.findById(producto.getCategoria().getId()).orElse(null);
        Receta receta = recetaRepository.findById(producto.getReceta().getId()).orElse(null);

        if(categoria == null)throw new BadRequest("Ingrese la categoria");
        if(receta == null) producto.setReceta(null);

        producto.setDescripcion(producto.getDescripcion());
        producto.setNombre(producto.getNombre());
        producto.setPrecio(producto.getPrecio());
        producto.setUrlimg(producto.getUrlimg());
        producto.setCategoria(producto.getCategoria());
        producto.setReceta(producto.getReceta());
        return productoRespository.save(producto);
    }
    public ResponseEntity<?> actualizar(Producto producto){
        Producto object = productoRespository.findById(producto.getId()).orElse(null);
        if(!object.equals(null)){
            object.setDescripcion(producto.getDescripcion());
            object.setNombre(producto.getNombre());
            object.setPrecio(producto.getPrecio());
            object.setUrlimg(producto.getUrlimg());
            object.setCategoria(producto.getCategoria());
            object.setReceta(producto.getReceta());
            productoRespository.save(object);
        }
        Map<String, String> message = new HashMap<>();
        message.put("Mensaje","Ok");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    public ResponseEntity<?>  eliminar(Long id){
        Map<String, String> message = new HashMap<>();
        Producto producto = productoRespository.findById(id).orElse(null);
        if( producto.equals(null)) {
            message.put("Mensaje","El producto no existe");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else{
            List<ProductoDiametro> diametros= productoDiametroRepository.findAllByProducto_Id(producto.getId()).orElse(null);
            List<ProductoSabor> sabores= productoSaborRepository.findAllByProducto_Id(producto.getId()).orElse(null);
            List<ProductoRelleno> rellenos= productoRellenoRepository.findAllByProducto_Id(producto.getId()).orElse(null);

            ProductoAltura productoAltura = productoAlturaRepository.findProductoAlturaByProducto_Id(id).orElse(null);
            ProductoCubierta productoCubierta = productoCubiertaRepository.findByProducto_Id(id).orElse(null);

            if(!diametros.equals(null)){
                productoDiametroRepository.deleteAllByProductoId(producto.getId());
            }
            if(!sabores.equals(null)){
                productoSaborRepository.deleteAllByProductoId(producto.getId());
            }
            if(!rellenos.equals(null)){
                productoRellenoRepository.deleteAllByProductoId(producto.getId());
            }
            if(!productoAltura.equals(null)){
                productoAlturaRepository.deleteByProducto_Id(producto.getId());
            }
            if(!productoCubierta.equals(null)){
                productoCubiertaRepository.deleteByProducto_Id(producto.getId());
            }
                productoRespository.deleteById(id);
                message.put("Mensaje","Eliminado");
                return new ResponseEntity<>(message, HttpStatus.OK);

        }
    }
}
