package Dao;


import Entidad.Producto;
import java.util.List;

public interface ProductoDAO {
    void agregar(Producto producto);
    List<Producto> listar();
    Producto buscarPorId(int id);
    void actualizar(Producto producto);
    void eliminar(int id);
}



