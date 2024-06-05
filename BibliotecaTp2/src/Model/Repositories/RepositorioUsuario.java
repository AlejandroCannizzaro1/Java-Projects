package Model.Repositories;

import Interfaces.IRepositorio;

import java.util.ArrayList;
import Model.Entities.*;
public class RepositorioUsuario implements IRepositorio {
    ArrayList<Usuario> listUsuario;

    public RepositorioUsuario() {
        this.listUsuario = new ArrayList<>();
    }

    public ArrayList<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(ArrayList<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public void actualizar (Integer id, Object objectUpdated){
        Usuario usuario = (Usuario) consultar(id);
        if(usuario != null) {
            Integer subIndice = getSubIndice(id);
            if (subIndice != -1) {
listUsuario.set(subIndice, (Usuario) objectUpdated);
            }
        }
    }
    public Object consultar (Integer id){
        for (int i = 0 ;i<listUsuario.size();i++){
            if(listUsuario.get(i).getId() == id){
                return listUsuario.get(i);
            }
        }
        return  null;
    }
    public void registar (Object object){
        listUsuario.add((Usuario)object);
    }
    public void eliminar (Integer id){
        Usuario usuario = (Usuario) consultar(id);
        if(usuario != null){
            listUsuario.remove(usuario);
        }
    }
    public Integer getSubIndice (Integer id){
        Usuario usuario = (Usuario) consultar(id);
        if(usuario != null){
            for (int i = 0 ;i<listUsuario.size();i++){
                if(usuario.getId() == id){
                    Integer subIndice = i;
                    return i;
                }
            }
        }
        return -1;
    }
}
