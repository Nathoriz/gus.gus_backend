package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    public List<Pedido> findAllByCliente_Id(Long id);
    public List<Pedido> findAllByEstado_NombreAndCliente_Id(String estado, Long id);

    @Query(value="SELECT p.* FROM pedido as p inner join cliente as c on p.cliente_id =c.id inner join estado as e on p.estado_id = e.id where c.id = ?1 and e.nombre=?2 and CAST( p.id AS CHAR(50)) LIKE CONCAT('%',?3,'%') ",nativeQuery = true)
    public List<Pedido> buscarPedidoClientePorID(Long id, String nombreEstado,String pedidoid);

    @Query(value="SELECT p.* FROM pedido as p inner join estado as e on p.estado_id = e.id where e.nombre=?1 and CAST( p.id AS CHAR(50)) LIKE CONCAT('%',?2,'%') ",nativeQuery = true)
    public List<Pedido> buscarPedidoPorEstadoAndID(String nombreEstado,String pedidoid);

    @Query(value="SELECT p.* FROM pedido as p where CAST( p.id AS CHAR(50)) LIKE CONCAT('%',?1,'%') ",nativeQuery = true)
    public List<Pedido> buscarPedidoPorID(String pedidoid);
}
