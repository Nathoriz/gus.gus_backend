package gustitodecasa.com.GustitoDeCasa_version_10.repository;

import gustitodecasa.com.GustitoDeCasa_version_10.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    public List<Pedido> findAllByCliente_Id(Long id);
    public List<Pedido> findAllByEstado_NombreAndCliente_Id(String estado, Long id);
}
