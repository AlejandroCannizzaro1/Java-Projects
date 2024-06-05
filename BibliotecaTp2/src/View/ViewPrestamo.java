package View;

import Interfaces.IView;
import Model.Entities.Prestamo;

import java.util.Scanner;

public class ViewPrestamo implements IView {

    public Integer askForIdUsuario (){
        Integer id = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del usuario al que desea prestar un libro");
        id = scanner.nextInt();
        return id;
    }
 public Integer askForIdToRemove (){
        return null;
 }
    public Integer askForIdToUpdate (){
        return null;
    }

public String askForData (String string){
        return null;
}
    public Integer actualizarMenuObject() {
        return null;
    }

    public Integer askForIdLibro (){
        Integer id = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del libro que desea prestar ");
        id = scanner.nextInt();
        return id;
    }
    public Integer askForIdToConsult(){
        Integer id = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del prestamo que desea consultar");
                id = scanner.nextInt();
        return id;
    }

    public Integer askForIdToDevolver(){
        Integer id = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del prestamo para realizar la devolucion ");
        id = scanner.nextInt();
        return id;
    }


    public Object crearObject (){
        return null;
    }


    public Integer askForInteger (String string){
        Scanner scanner = new Scanner(System.in);
        Integer dato = -1;
        System.out.println("Ingrese el "  + string + "del prestamo  ");
        dato = scanner.nextInt();
        return  dato;
    }
}
