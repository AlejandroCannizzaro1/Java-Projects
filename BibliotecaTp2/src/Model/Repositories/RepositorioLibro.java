package Model.Repositories;

import Interfaces.IRepositorio;

import java.util.ArrayList;
import java.util.List;

import Model.Entities.*;

public class RepositorioLibro implements IRepositorio {
private ArrayList <Libro> listLibros;

    public RepositorioLibro() {
        this.listLibros = new ArrayList<>();
    }

    public ArrayList<Libro> getListLibros() {
        return listLibros;
    }

    public void setListLibros(ArrayList<Libro> listLibros) {
        this.listLibros = listLibros;
    }

    public void actualizar (Integer id, Object objectUpdated){
        Libro libro = (Libro) consultar(id);
        if(libro != null){
            Integer subIndice = getSubIndice(id);
            if (subIndice != -1){
                listLibros.set(subIndice, (Libro) objectUpdated);
            }
        }
    }
    public Object consultar (Integer id){
        for (int i = 0 ;i<listLibros.size();i++){
            if(listLibros.get(i).getId() == id){
                return listLibros.get(i);
            }
        }
        return  null;
    }
    public void registar (Object object){
        listLibros.add((Libro)object);
    }
    public void eliminar (Integer id){
        Libro libro = (Libro) consultar(id);
        if(libro != null){
            listLibros.remove(libro);
        }
    }
    public Integer getSubIndice (Integer id){
        Libro libro = (Libro) consultar(id);
        if(libro != null ){
            for (int i = 0 ;i<listLibros.size();i++){
                if (listLibros.get(i).getId() == id){
                    return i;
                }
            }
        }
        return -1;
    }
}
