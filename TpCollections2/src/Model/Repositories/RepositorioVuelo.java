package Model.Repositories;
import Model.Entities.*;

import java.util.ArrayList;

public class RepositorioVuelo {
private ArrayList<Vuelo> listVuelos;

    public RepositorioVuelo() {
        this.listVuelos = new ArrayList<>();
    }

    public ArrayList<Vuelo> getListVuelos() {
        return listVuelos;
    }

    public void setListVuelos(ArrayList<Vuelo> listVuelos) {
        this.listVuelos = listVuelos;
    }

    public Object consultar (String vueloAlfanumerico){
        for (int i = 0;i<listVuelos.size();i++){
            if (listVuelos.get(i).getVueloAlfanumerico().equals(vueloAlfanumerico)){
                return  listVuelos.get(i);
            }
        }
        return null;
    }
    public void eliminar (String vueloAlfanumerico){
        Vuelo vuelo = (Vuelo) consultar(vueloAlfanumerico);
        if (vuelo != null){
            listVuelos.remove(vuelo);
        }
    }
    public void registrar (Object object){
        this.listVuelos.add((Vuelo) object);
    }
    public void actualizar (String vueloAlfanumerico, Object objectUpdated){
        Vuelo vuelo = (Vuelo) consultar(vueloAlfanumerico);
        if (vuelo != null){
            Integer subIndice = getSubIndice(vueloAlfanumerico);
            if (subIndice != -1) {
                this.listVuelos.set(subIndice, (Vuelo) objectUpdated);
            }
        }
    }
    public Integer getSubIndice (String vueloAlfanumerico){
        Integer subIndice = -1;
        for (int i = 0;i<listVuelos.size();i++){
            if (listVuelos.get(i).getVueloAlfanumerico().equals(vueloAlfanumerico)){
                return  i;
            }
        }
        return -1;
    }



}
