package View;

import Interfaces.IView;
import Model.Entities.Libro;
import Model.Entities.Usuario;

import java.util.Scanner;

public class ViewLibro implements IView {
    public Integer askForIdToRemove (){
        Integer id = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del libro que desea eliminar");
        id = scanner.nextInt();
        return id;
    }
    public Integer askForIdToUpdate (){
        Integer id = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del libro que desea actualizar");
        id = scanner.nextInt();
        return id;
    }
    public Integer askForIdToConsult(){
        Integer id = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del libro que desea consultar");
                id = scanner.nextInt();
        return id;
    }
    public Integer actualizarMenuObject  (){
        Scanner scanner = new Scanner(System.in);
        Integer opcion = -1;

        do {
            System.out.println("SubMenu actualizar campos de libro");
            System.out.println("1-Titulo");
            System.out.println("2-Autor ");
            System.out.println("3-Genero");
            System.out.println("4-Cantidad de copias ");
            System.out.println("\nElija una opcion");
            opcion = scanner.nextInt();
            if (opcion<1 || opcion>4){
                System.out.println("\n Error, elija una opcion valida !! \n");
            }
        } while (opcion<1 || opcion>4);
        return opcion;
    }
    public Object crearObject (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Registrar Libro");
        String titulo = askForData(" titulo");
        String autor = askForData(" autor ");
        String genero = askForData(" genero ");
        Integer cantidadDeCopias = askForInteger(" cantidad de copias  ");
        Libro libro  = new Libro(titulo, autor, genero, cantidadDeCopias );
        return libro;

    }

    public String askForData (String string){
        Scanner scanner = new Scanner(System.in);
        String dato = " ";
        System.out.println("Ingrese el " +string+ " del libro ");
        dato = scanner.nextLine();
        return  dato;
    }
    public Integer askForInteger (String string){
        Scanner scanner = new Scanner(System.in);
        Integer dato = -1;
        System.out.println("Ingrese el " +string+ " del libro ");
        dato = scanner.nextInt();
        return  dato;
    }
}
