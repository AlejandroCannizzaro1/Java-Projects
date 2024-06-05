import Controller.AutomovilController;
import Model.Repositories.RepositorioAutomovil;
import Vista.ViewAutomovil;

import java.nio.channels.ScatteringByteChannel;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ViewAutomovil viewAutomovil = new ViewAutomovil();
        RepositorioAutomovil repositorioAutomovil = new RepositorioAutomovil();
        AutomovilController automovilController = new AutomovilController(repositorioAutomovil, viewAutomovil);

        Integer opcion = -1;
        Scanner scanner = new Scanner(System.in);
        Integer i = 0 ;
        do{
        do {
            if( i == 0 ) {
                try {
                    System.out.println("\n\n  Cargando sistema de CRUD AUTOMOVIL");
                    System.out.println("  Aguarde... \n  ");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // Maneja la excepción si la interrupción del hilo ocurre mientras el hilo está dormido
                    e.printStackTrace();
                }
            }

            System.out.println("\nMenu Principal\n");
            System.out.println("Ingrese una opcion: ");
            System.out.println("1-Registrar automovil");
            System.out.println("2-Eliminar automovil");
            System.out.println("3-Mostrar lista de automovil");
            System.out.println("4-Actualizar datos de automovil");
            System.out.println("0-Salir del sistema ");
            opcion = scanner.nextInt();
            if(opcion<0 || opcion>4) {
                System.out.println("Opcion incorrecta. Reintente !!! ");
            }
        } while (opcion<0 || opcion>4);

                switch (opcion) {
                    case 0:
                        System.out.println("\n\n\n\n\n");
                        System.out.println("Saliendo del sistema ...... ");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            // Maneja la excepción si la interrupción del hilo ocurre mientras el hilo está dormido
                            e.printStackTrace();
                        }
                        System.out.println(" Bye !!! ");
                        System.exit(0);
                break;
                    case 1:
                        automovilController.crearAuto();
                        break;
                    case 2:
                        automovilController.eliminarAuto();

                        break;
                    case 3:
                        automovilController.mostrarListAutomoviles();
                        break;
                    case 4:
                        automovilController.actualizarAutomovil();
                        break;
                    default:
                        System.out.println("\nOpcion incorrecta !! ");
                        break;
                }
                i++;
        } while (true);

    }
}