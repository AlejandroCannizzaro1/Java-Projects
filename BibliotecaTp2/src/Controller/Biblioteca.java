package Controller;

import java.util.Scanner;

public class Biblioteca {
private  ControllerUsuario controllerUsuario;
private ControllerLibro controllerLibro;
private ControllerPrestamo controllerPrestamo;

    public Biblioteca(ControllerUsuario controllerUsuario,
                      ControllerLibro controllerLibro, ControllerPrestamo controllerPrestamo) {
        this.controllerUsuario = controllerUsuario;
        this.controllerLibro = controllerLibro;
        this.controllerPrestamo = controllerPrestamo;
    }

    public void menuPrincipal () {

        Scanner scanner = new Scanner(System.in);
        Integer opcion = 0 ;

        System.out.println("\n ---------------------Welcome to the library -------------------------");


        do {
            do {
                System.out.println("\n--------------------------Menu Principal-------------------------------");
                System.out.println("1-Registrar usuario");
                System.out.println("2-Actualizar usuario");
                System.out.println("3-Eliminar usuario");
                System.out.println("4-Mostrar lista de usuarios ");
                System.out.println("5-Registrar libro");
                System.out.println("6-Actualizar libro");
                System.out.println("7-Eliminar libro");
                System.out.println("8-Mostrar lista de libros");
                System.out.println("9-Realizar prestamo");
                System.out.println("10-Realizar devolucion");
                System.out.println("11-Mostrar lista de prestamos");
                System.out.println("0-Salir del sistema");
                System.out.println("\nElija una opcion ");
                opcion = scanner.nextInt();
                if (opcion < 0 || opcion > 11) {
                    System.out.println("\nOpcion incorrecta !! Reintente !! \n");
                }
            } while (opcion < 0 || opcion > 11);

            switch (opcion) {
                case 0:
                    System.out.println("\nSaliendo del sistema .... ");
                    System.exit(0);
                    break;
                case 1:
                    controllerUsuario.crearController();
                    break;
                case 2:
                    controllerUsuario.actualizarController();
                    break;
                case 3:
                    controllerUsuario.eliminarController();
                    break;
                case 4:
                    controllerUsuario.mostrarListController();

                    break;
                case 5:
                    controllerLibro.crearController();
                    break;
                case 6:
                    controllerLibro.actualizarController();
                    break;
                case 7:
                    controllerLibro.eliminarController();
                    break;
                case 8:
                    controllerLibro.mostrarListController();

                    break;
                case 9:
                    controllerPrestamo.realizarPrestamo();
                    break;
                case 10:
                    controllerPrestamo.permitirDevoluciones();
                    break;
                case 11:
                    controllerPrestamo.mostrarListController();
                    break;
                default:
                    System.out.println(" Error !! ");
                    break;
            }
        } while (true);
    }
}
