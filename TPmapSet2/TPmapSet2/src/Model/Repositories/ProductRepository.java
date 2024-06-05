package Model.Repositories;
import java.util.*;

import Interfaces.IRepositorio;
import Model.Entities.Producto;

public class ProductRepository implements IRepositorio {
     private Map <Integer, Producto> mapProductos;

    public ProductRepository () {
        this.mapProductos = new HashMap<>();
    }

    public Map< Integer,Producto> getMapProductos() {
        return mapProductos;
    }

    public void setMapProductos( Map<Integer,Producto> mapProductos) {
        this.mapProductos = mapProductos;
    }

    public Object consultar (Integer id ){

        if (mapProductos.containsKey(id)){
            return mapProductos.get(id);
        }
        return null;
    }
    public boolean eliminar (Integer id){
        Boolean elimino = false;
        Producto producto = (Producto) consultar(id);
        if (producto != null){
            elimino = this.mapProductos.remove(id, producto);
        }
        return elimino;
    }
    public boolean registrar (Object object){

        if (object instanceof Producto){
            Producto producto = (Producto) object;
            this.mapProductos.put(producto.getIdProducto(), producto);
            return true;
            } else {
            System.out.println("\nNo es una instancia de producto el objeto pasado por parametro !1 \n");
        }
        return false;
    }
    public boolean actualizar (Integer id, Object objectUpdated){
            boolean existe = false;
        if (containsKey(id)) {
            Producto productoUpdated = (Producto) objectUpdated;
            Producto producto = this.mapProductos.put(productoUpdated.getIdProducto(), productoUpdated);
            if (producto != null) {
                existe = true;
            }
        }
        return  existe;
    }

    public boolean containsKey (Integer key){
        return this.mapProductos.containsKey(key);
    }

}
