package Model.Repositories;

import Interfaces.IRepositorio;

import java.util.ArrayList;
import Model.Entities.*;
public class RepositorioPrestamo implements IRepositorio {
    ArrayList<Prestamo> listPrestamos;
    public RepositorioPrestamo() {
        this.listPrestamos = new ArrayList<>();
    }

    public ArrayList<Prestamo> getListPrestamos() {
        return listPrestamos;
    }

    public void setListPrestamos(ArrayList<Prestamo> listPrestamos) {
        this.listPrestamos = listPrestamos;
    }

    // No lo voy a usar
    public void actualizar (Integer id, Object objectUpdated){
        Prestamo prestamo = (Prestamo) consultar(id);
        if (prestamo!= null){
            Integer subIndice = getSubIndice(id);
            if (subIndice != -1){
                listPrestamos.set(subIndice, (Prestamo) objectUpdated);
            }
        }
    }
    public Object consultar (Integer id){
        for (int i = 0 ;i<listPrestamos.size();i++){
            if (listPrestamos.get(i).getId() == id){
                return getListPrestamos().get(i);
            }
        }
        return null;
    }
    public void registar (Object object){
        listPrestamos.add((Prestamo) object);
    }
    public void eliminar (Integer id){
        Prestamo prestamo = (Prestamo) consultar(id);
        if(prestamo != null){
           listPrestamos.remove(prestamo);
        }
    }
    public Integer getSubIndice (Integer id){
        Prestamo prestamo = (Prestamo) consultar(id);
        if (prestamo != null){
            for (int i = 0 ; i<listPrestamos.size();i++){
                if (listPrestamos.get(i).getId() == id){
                    return i;
                }
            }
        }
        return -1;
    }

}
