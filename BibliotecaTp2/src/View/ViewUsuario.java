package View;

import Interfaces.IView;

import java.util.Scanner;
import Model.Entities.*;

// AskForId, actualizarMenu, crearObject, askForDate
/// C.A.A.A
public class ViewUsuario implements IView {
    public Integer askForIdToRemove (){
        Integer id = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del usuario que desea eliminar");
                id = scanner.nextInt();
        return id;
    }
    public Integer askForIdToUpdate (){
        Integer id = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del usuario que desea actualizar");
                id = scanner.nextInt();
        return id;
    }
    public Integer askForIdToConsult(){
        Integer id = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del usuario que desea consultar");
                id = scanner.nextInt();
        return id;
    }
    public Integer actualizarMenuObject  (){
        Scanner scanner = new Scanner(System.in);
        Integer opcion = -1;

      do {
          System.out.println("SubMenu actualizar campos de usuario");
          System.out.println("1-Nombre");
          System.out.println("2-Apellido");
          System.out.println("3-Tipo de Usuario");
          System.out.println("\nElija una opcion");
          opcion = scanner.nextInt();
          if (opcion<1 || opcion>3){
              System.out.println("\n Error, elija una opcion valida !! \n");
          }
      } while (opcion<1 || opcion>3);
        return opcion;
    }
    public Object crearObject (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistar Usuario");
        String name = askForData(" nombre");
        String lastName = askForData(" apellido ");
        String tipoDeUsuario = askForData(" tipo de usuario ");
        Usuario usuario = new Usuario (name, lastName, tipoDeUsuario);
       return usuario;

    }

    public String askForData (String string){
        Scanner scanner = new Scanner(System.in);
        String dato = " ";
        System.out.println("Ingrese el" +string+ " del usuario ");
        dato = scanner.nextLine();
       return dato;
    }
    public Integer askForInteger (String string){
        Scanner scanner = new Scanner(System.in);
        Integer dato = -1;
        System.out.println("Ingrese el " +string+ "del usuario ");
        dato = scanner.nextInt();
        return  dato;
    }
}
