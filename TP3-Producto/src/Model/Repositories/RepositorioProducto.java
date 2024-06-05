package Model.Repositories;

import Interfaces.IRepositorio;
import Model.Entitites.*;

import java.util.ArrayList;
import java.util.List;

public class RepositorioProducto implements Interfaces.IRepositorio  {

    private List<Producto> listProducto;

    public  RepositorioProducto() {
        this.listProducto = new ArrayList<>();
    }

    public List<Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(List<Producto> listProducto) {
        this.listProducto = listProducto;
    }

    public void registrar (Object object){
        listProducto.add((Producto)object);
    }
    public Object consultar (Integer id){
        if(!listProducto.isEmpty()){
            for (Producto p: listProducto){
                if(p.getId() == id){
                    return  p;
                }
            }
        }
        return null;
    }
    public void actualizar (Integer id, Object object){
        Integer subIndice = getSubIndice(id);
        if(subIndice != -1){
            listProducto.set(subIndice, (Producto) object);
        }
    }
    public void eliminar (Integer id){
        Producto producto = (Producto) consultar(id);
        if(producto != null){
            listProducto.remove(producto);
        }
    }
    public Integer getSubIndice (Integer id){
        if(!listProducto.isEmpty()){
            for(int i = 0 ;i<listProducto.size();i++){
                if(listProducto.get(i).getId() == id){
                    return i;
                }
            }
        }
        return -1;
    }
}
