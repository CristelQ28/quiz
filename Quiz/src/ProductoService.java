
import java.util.List;

public class ProductoService {

    private ProductoDAO dao = new ProductoDAOImpl();

    public void registrarProducto(Producto p) {
        if (p.getCantidad() < 0 || p.getPrecio() < 0) {
            System.out.println("Datos inválidos");
            return;
        }
        dao.agregar(p);
    }

    public List<Producto> listarProductos() {
        return dao.listar();
    }

    public Producto buscar(int id) {
        return dao.buscarPorId(id);
    }

    public void actualizarProducto(Producto p) {
        dao.actualizar(p);
    }

    public void eliminarProducto(int id) {
        dao.eliminar(id);
    }
}