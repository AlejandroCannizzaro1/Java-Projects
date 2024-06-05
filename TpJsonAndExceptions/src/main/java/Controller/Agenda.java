package Controller;

import Excepciones.LosCamposNoPuedenEstarVaciosException;
import View.ViewContacto;

public class Agenda {
    private ContactosController contactosController;
    private ViewContacto viewContacto;

    public Agenda(ContactosController contactosController, ViewContacto viewContacto) {
        this.contactosController = contactosController;
        this.viewContacto = viewContacto;

    }

    public void menuPrincipal () {
        Integer opcion = -1;

        do {
            do {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println("\n---------------------------------------------------------------------------------");
                System.out.println("------------------------------ Menu Principal -----------------------------------");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("\n1-Registrar un contacto");
                System.out.println("\n2-Actualizar un contacto");
                System.out.println("\n3-Eliminar un contacto");
                System.out.println("\n4-Mostrar lista de contactos");
                System.out.println("\n5.Cargar contactos from File");
                System.out.println("\n0-Salir del sistema");
                opcion = viewContacto.askForInteger("\nElija una opcion");
                if (opcion < 0 || opcion > 5) {
                    System.out.println("\nOpcion incorrecta, reintente por favor !! \n");

                }
            } while (opcion < 0 || opcion > 5);

            switch (opcion) {
                case 0:
                    System.out.println("\nSaliendo del sistema .........\n");
                    System.exit(0);
                    break;
                case 1:
                    contactosController.crearController();
                    break;
                case 2:
                    contactosController.actualizarController();
                    break;
                case 3:
                    contactosController.eliminarController();
                    break;
                case 4:
                    contactosController.mostrarColeccionController();
                    break;
                case 5:
                    contactosController.cargarContactosFromFile();
                    break;
                default:
                    break;
            }
        } while (true);
    }
}
