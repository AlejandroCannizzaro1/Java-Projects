package View;


import java.util.Scanner;
import Model.Entities.*;
import excepciones.StringVacioException;

public class ViewCurso {

    public Curso crearObject () throws StringVacioException {
        System.out.println("-------------------------------------------");
        System.out.println("\nCrear curso \n");
        String codigoProyecto =  askForData("\nIngrese el codigo del curso");
        String name = askForData("\nIngrese el nombre del curso");
        if (name.equals("") || codigoProyecto.equals("")){
            throw  new StringVacioException("\nNo puede ingresar Strings vacios !!\n");
        }
        Curso proyecto = new Curso(name, codigoProyecto);
        return  proyecto;
    }




    public Integer askForInteger (String string){
        Scanner scanner = new Scanner(System.in);
        System.out.println(string);
        Integer opcion = scanner.nextInt();
        return opcion;
    }
    public String askForData (String string){
        Scanner scanner = new Scanner(System.in);
        System.out.println(string);
        String data  = scanner.nextLine();
        return data;
    }
}
