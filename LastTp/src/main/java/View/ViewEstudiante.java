package View;

import Interfaces.Iview;
import Model.Entities.*;
import excepciones.StringVacioException;

import java.util.Scanner;

public class ViewEstudiante implements Iview<Estudiante> {

    public Estudiante crearObject () throws StringVacioException {
        System.out.println("-------------------------------------------");
        System.out.println("\nCrear empleado \n");
        String name = askForData("\nIngrese el nombre del estudiante");
        String email = askForData("\nIngrese el email del estudiante\n");
        if (name.equals("") || email.equals("")){
            throw  new StringVacioException("\nNo puede ingresar Strings vacios !!\n");
        }
        Estudiante estudiante = new Estudiante(name, email);
        return  estudiante;
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
