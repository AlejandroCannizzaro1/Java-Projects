package Model.Repositories;
import java.util.*;

import Interfaces.IRepositorio;
import Model.Entities.Categoria;

import java.util.HashSet;

public class CategoryRepository implements IRepositorio {
    // C.E.R.A.S.
    private HashSet <Categoria> hashSetCategorias;

    public CategoryRepository() {
        this.hashSetCategorias = new HashSet<>();
    }

    public HashSet<Categoria> getHashSetCategorias() {
        return hashSetCategorias;
    }

    public void setListCategorias(HashSet<Categoria> hashSetCategorias) {
        this.hashSetCategorias = hashSetCategorias;
    }
    public Object consultar (Integer id ) {
    Iterator <Categoria> iterator = hashSetCategorias.iterator();
        for (int i = 0 ;i<hashSetCategorias.size();i++){
            Categoria categoria = iterator.next();
            if (categoria.getIdCategoria() == id){
            return categoria;
            }
        }
        return null;
    }
    public boolean consultarConContainsSiExisteCategoria (Integer id){

        Categoria categoria = new Categoria("", id);
        return  this.hashSetCategorias.contains(categoria);
    }
    public Categoria consultarConForEach (Integer id){
        for (Categoria c : hashSetCategorias){
            if (c.getIdCategoria() == id ){
                return c;
            }
        }
        return null;
    }



    public boolean eliminar (Integer id){
        Categoria categoria = (Categoria) consultar(id);
        if (categoria != null){
           return  hashSetCategorias.remove(categoria);
        }
        return  false;
    }
    public boolean registrar (Object object){
        return this.hashSetCategorias.add((Categoria)object);
    }
    public boolean actualizar (Integer id, Object objectUpdated) {
        Categoria categoria = (Categoria) consultarConForEach(id);
        if (categoria != null) {
            boolean borro = hashSetCategorias.removeIf(p -> p.getIdCategoria() == id);
            if (borro) {
                hashSetCategorias.add((Categoria) objectUpdated);
                return true;
            }
        }
        return false;
    }
    public int getValorDeHash (Integer id){

        Iterator <Categoria> iterator = hashSetCategorias.iterator();
        while (iterator.hasNext()){
            Categoria categoria = iterator.next();
            if (categoria.getIdCategoria() == id){
                return categoria.hashCode();
            }
        }
        return -1;
     }

     public Categoria getByHashCode (Integer hashObjectBuscado){
        if(!hashSetCategorias.isEmpty()){
            for (Categoria c : hashSetCategorias){
                if (c.hashCode() == hashObjectBuscado){
                    return  c;
                }
            }
        }
         return null;
     }

}
