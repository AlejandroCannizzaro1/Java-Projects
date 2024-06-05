package Controller;

import Model.Entitites.Contacto;
import Model.Repositories.RepositorioContactos;
import View.ViewContacto;
import Excepciones.LosCamposNoPuedenEstarVaciosException;

import java.util.Scanner;

public class ContactosController {
    private ViewContacto viewContacto;
    private RepositorioContactos repositorioContactos;

    public ContactosController(ViewContacto viewContacto, RepositorioContactos repositorioContactos) {
        this.viewContacto = viewContacto;
        this.repositorioContactos = repositorioContactos;
    }

    public void crearController() {
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("Crea contacto");
        try {
            Contacto contacto = (Contacto) viewContacto.crearObject();
            this.registrarController(contacto);

        } catch (LosCamposNoPuedenEstarVaciosException e) {
            System.out.println("\n" + e.getMessage() );
            e.printStackTrace();
        }

    }

    public void registrarController(Object object) {
        boolean exito = this.repositorioContactos.registrar((Contacto) object);
        if (exito)
            System.out.println("\nRegistracion exitosa !!\n");
        else
            System.out.println("\nError al registrar el contacto!! \n");
    }

    public void eliminarController() {
        boolean exito = false;

        System.out.println("----------------------------------------------------------------------");
        System.out.println("\nElimina contacto\n");
        Integer idContacto = viewContacto.askForInteger("Ingrese el id del contacto que desea eliminar");
        Contacto contacto = (Contacto) this.repositorioContactos.consultar(idContacto);

        if (contacto != null) {
            if (this.repositorioContactos.eliminar(idContacto))
                System.out.println("\nContacto eliminado de la lista exitosamente!! \n");
            else
                System.out.println("\nError al eliminar contacto\n");
        } else {
            System.out.println("\nError, el contacto no existe !! \n");
        }
    }

    public String askForData2(String string) throws LosCamposNoPuedenEstarVaciosException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(string);
        String data = scanner.nextLine();
        if (data.isEmpty()) {
            throw new LosCamposNoPuedenEstarVaciosException("\nError, no puede ingresar String vacios");
        } else {
            return data;
        }
    }

    public void actualizarController() {

        boolean exito = false;
        boolean exitoAlCargar = false;
        System.out.println("----------------------------------------------------------------------");
        System.out.println("\nActualiza contacto\n");
        Integer id = viewContacto.askForInteger("\nIngerse el id del contacto que desea eliminar");
        Contacto contactoAUpdatear = (Contacto) this.repositorioContactos.consultar(id);

        if (contactoAUpdatear != null) {
            System.out.println("\nContacto valido !! \n");
            Integer opcion = viewContacto.subMenuActualizarObject();
            switch (opcion) {
                case 1:
                    try {
                        String name = askForData2("\nIngrese el nuevo nombre de el contacto");
                        contactoAUpdatear.setNombre(name);
                        exito = true;
                    } catch (LosCamposNoPuedenEstarVaciosException e) {

                        System.out.println("\n" + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        String telefono = askForData2("\nIngrese el nuevo telefono de el contacto");
                        contactoAUpdatear.setNombre(telefono);
                        exito = true;
                    } catch (LosCamposNoPuedenEstarVaciosException e) {
                        System.out.println("\n" + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        String email = askForData2("\nIngrese el nuevo email de el contacto");
                        contactoAUpdatear.setNombre(email);
                        exito = true;
                    } catch (LosCamposNoPuedenEstarVaciosException e) {
                        System.out.println("\n" + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
            }

            if (contactoAUpdatear != null && exito) {

                exitoAlCargar = this.repositorioContactos.actualizar(contactoAUpdatear.getId(), contactoAUpdatear);
                if (exitoAlCargar){
                    System.out.println("\nActualizacion exitosa !! \n");
                } else {
                    System.out.println("\nNo se ha actualizado correctamente el contacto !! \n");
                }
            } else {
                System.out.println("\nActualizacion interrumpida por excepcion !! Intente nuevamente !\n");
            }
        } else {
            System.out.println("\nEl id ingresado no pertenece a ningun contacto de la lista !! \n");
        }
    }
   public void cargarContactosFromFile (){
        boolean exito = false;
       System.out.println("--------------------------------------------------------------------------------");
       System.out.println("\nCargar contactos from File\n");
       System.out.println("\nEspere .... ");
       if(this.repositorioContactos.loadClientesFromFile()){
           System.out.println("\nExito al cargar los archivos del file !! ");
       } else {
           System.out.println("\nEl File esta vacio !! \n");
       }

   }
    public void mostrarColeccionController (){
        this.viewContacto.mostrarColeccion();
    }
}
