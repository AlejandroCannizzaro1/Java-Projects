package Model.Repositories;
import Interfaces.IRepositorio;
import Model.Entitites.*;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAutomovil implements IRepositorio {
    private List<Automovil> listAutomoviles;

    public RepositorioAutomovil() {
        this.listAutomoviles = new ArrayList<>();
    }

    public List<Automovil> getListAutomoviles() {
        return listAutomoviles;
    }

    public void setListAutomoviles(List<Automovil> listAutomoviles) {
        this.listAutomoviles = listAutomoviles;
    }

    public void actualizar (Integer id, Object objectActualizado){
        Integer subIndice = buscaSubIndice(id);
        if(subIndice != -1){
            listAutomoviles.set(subIndice, (Automovil) objectActualizado);
        }
    }

    public void registrar (Object object){
        this.listAutomoviles.add((Automovil) object);
    }
    public void eliminar  (Integer id){
        Automovil automovil = (Automovil) consultar(id);
        if(automovil != null){
            listAutomoviles.remove(automovil);
        }
    }

    public Object consultar (Integer id){
    for (Automovil a: listAutomoviles){
    if(a.getId() == id  ){
        return a;
    }
    }
    return null;
    }

    public Integer buscaSubIndice (Integer id ){
        for (int i = 0 ; i<listAutomoviles.size();i++){
            if(listAutomoviles.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
