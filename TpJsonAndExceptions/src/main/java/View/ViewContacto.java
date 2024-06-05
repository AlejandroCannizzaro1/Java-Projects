package View;

import Excepciones.LosCamposNoPuedenEstarVaciosException;
import Model.Entitites.Contacto;
import Model.Repositories.RepositorioContactos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ViewContacto implements Interfaces.IView {
    RepositorioContactos repositorioAgenda = new RepositorioContactos();

    public ViewContacto(RepositorioContactos repositorioAgenda) {
        this.repositorioAgenda = repositorioAgenda;
    }

    public Object crearObject () throws LosCamposNoPuedenEstarVaciosException {
        // Este metodo cuando lo use me va a pedir que use un try and catch

        String nameContacto = askForData("\nIngrese el nombre del contacto\n");
        String telefono = askForData("\nIngrese el telefono del contacto\n");
        String email = askForData("\nIngrese el email del contacto\n");
        if (nameContacto.equalsIgnoreCase("") || telefono.equalsIgnoreCase("")
        || email.equalsIgnoreCase("")){
        throw new LosCamposNoPuedenEstarVaciosException("\nError, no puede ingresar campos sin ningun caracter.");
        } else {
        Contacto contacto = new Contacto(nameContacto, telefono, email);
        return contacto;
        }
    }

    public Object crearObjectSinThrows (){
        return null;
    }
    public Integer subMenuActualizarObject (){
        Integer opcion = -1;
        do {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("\nMenu actualiar object\n");
            System.out.println("1-Modifica name");
            System.out.println("2-Modifica telefono");
            System.out.println("3-Modifica email");
             opcion = askForInteger("Elija una opcion");
            if (opcion < 1 || opcion > 3) {
                System.out.println("\nError !! ");
            }
        }  while (opcion<1 || opcion>3);
        return  opcion;
    }
    public void mostrarColeccion (){
        LinkedList linkedListContactos = this.repositorioAgenda.getListContactos();
        if (!linkedListContactos.isEmpty()){
            Collections.sort(linkedListContactos);
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("\nMuestra coleccion de contactos\n");
            for (int i = 0 ;i<linkedListContactos.size();i++){
                System.out.println(linkedListContactos.get(i).toString());
            }
            System.out.println("-------------------------------------------------------------------------------");
        } else {
            System.out.println("\nLa lista de contactos esta vacia !!! \n");
        }
    }
    public String askForData (String string){
        Scanner scanner = new Scanner(System.in);
        System.out.println(string);
        String data =  scanner.nextLine();
       return data;
    }
    public Integer askForInteger (String string){
        Scanner scanner = new Scanner(System.in);
        System.out.println(string);
        Integer data =  scanner.nextInt();
        return data;
    }
}
