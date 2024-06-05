package Model.Repositories;

import Interfaces.IRepositorio;
import Model.Entitites.*;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCategoria implements Interfaces.IRepositorio {
private List<Categoria> listCategoria;

    public RepositorioCategoria() {
        this.listCategoria = new ArrayList<>();
    }

    public List<Categoria> getListCategoria() {
        return listCategoria;
    }

    public void setListCategoria(List<Categoria> listCategoria) {
        this.listCategoria = listCategoria;
    }

    public void registrar (Object object){
        this.listCategoria.add((Categoria)object);
    }
    public Object consultar (Integer id){
        if(!this.listCategoria.isEmpty()){
            for (Categoria c: listCategoria){
                if(c.getId() == id){
                    return (Categoria) c;
                }
            }
        }
        return  null;
    }
    public void actualizar (Integer id, Object object){
        Integer i = getSubIndice(id);
        if(i != -1){
            listCategoria.set(i, (Categoria)object);
        }
    }
    public void eliminar (Integer id){
        Categoria categoria = (Categoria) consultar(id);
        if(categoria != null){
            listCategoria.remove(categoria);
        }
    }

    public Integer getSubIndice (Integer id){
        if(!listCategoria.isEmpty()){
            for(int i = 0 ; i<listCategoria.size();i++){
                if(listCategoria.get(i).getId() == id){
                    return i;
                }
            }
        }
        return -1;
    }

}
