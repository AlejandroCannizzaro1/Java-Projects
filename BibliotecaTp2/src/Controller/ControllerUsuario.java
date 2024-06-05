package Controller;

import Interfaces.IController;
import Model.Repositories.RepositorioUsuario;
import View.ViewMessages;
import View.ViewUsuario;
import Model.Entities.*;

import java.util.ArrayList;

public class ControllerUsuario implements IController {
    private RepositorioUsuario repositorioUsuario;
    private ViewUsuario viewUsuario;

    public ControllerUsuario(RepositorioUsuario repositorioUsuario, ViewUsuario viewUsuario) {
        this.repositorioUsuario = repositorioUsuario;
        this.viewUsuario = viewUsuario;
    }

public void crearController (){
        registrarController(viewUsuario.crearObject());
    System.out.println("\nUsuario registrado con exito !!! \n");
}


    public void registrarController (Object object){
        this.repositorioUsuario.registar((Usuario)object);
    }
    public void eliminarController (){
        Integer id = viewUsuario.askForIdToRemove();
        Usuario usuario = (Usuario) this.repositorioUsuario.consultar(id);
        if(usuario != null){
            this.repositorioUsuario.eliminar(id);
            ViewMessages.okRemovingMessage(" usuario ");
        } else {
            System.out.println("\nEl usuario no existe !! \n");
        }
    }
    public void mostrarListController () {
        Integer i = 1 ;
        System.out.println("\nMuestra lista de usuarios \n");

        ArrayList<Usuario> listUsuario = this.repositorioUsuario.getListUsuario();
        if (!listUsuario.isEmpty()) {
            for (Usuario u : listUsuario) {
                System.out.println("--------------------------------------------------------");
                System.out.println(i+"-");
                System.out.println(u.toString());
                System.out.println("--------------------------------------------------------");
                i++;
            }
        }
      else  {
            System.out.println("\n La lista esta vacia !!! \n");
        }
    }
    public void actualizarController() {
        Integer id = viewUsuario.askForIdToUpdate();
        Usuario usuario = (Usuario) this.repositorioUsuario.consultar(id);
        Integer opcion = -1;
        if (usuario != null) {
            opcion = viewUsuario.actualizarMenuObject();
            switch (opcion) {
                case 1:
                    String name = viewUsuario.askForData(" nuevo nombre ");
                    usuario.setName(name);
                    break;
                case 2:
                    String lastName = viewUsuario.askForData(" nuevo apellido  ");
                    usuario.setLastName(lastName);
                    break;
                case 3:
                    String tipoDeUsuario = viewUsuario.askForData(" nuevo tipo de usuario ");
                    usuario.setTipoDeUsuario(tipoDeUsuario);
                    break;

                default:
                    System.out.println("No chances to be here !! ");
                    break;
            }
            this.repositorioUsuario.actualizar(id, usuario);
            ViewMessages.okUpdatingMessage(" usuario ");
        } else {
            System.out.println("\n El usuario que quiere actualizar no existe !! \n");

        }
    }
}
