package gustitodecasa.com.GustitoDeCasa_version_10.service;

import gustitodecasa.com.GustitoDeCasa_version_10.Utils.other.DetalleProductoDTO;
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


    public List<Producto> ListarProductos(){
        return productoRespository.findAll();
    }

    public List<Producto> listaPorCategoria( String categoria ){
        List<Producto> producto =  productoRespository.findProductoByCategoriaNombre( categoria );

        if( producto.isEmpty() ){
            return producto;
        }

        return producto;
    }

    public List<Producto> filtroProductos( String nombre ){
        List<Producto>  lista = productoRespository.findAllByNombreContainingIgnoreCase( nombre );
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

            ProductoAltura productoAltura = productoAlturaRepository.findProductoAlturaByProducto_Id(id);
            ProductoCubierta productoCubierta = productoCubiertaRepository.findByProducto_Id(id);

            List<ProductoDiametro> productoDiametros = productoDiametroRepository.findAllByProducto_Id(id);
            List<ProductoSabor> productoSabores = productoSaborRepository.findAllByProducto_Id(id);
            List<ProductoRelleno> productoRellenos = productoRellenoRepository.findAllByProducto_Id(id);

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
}
