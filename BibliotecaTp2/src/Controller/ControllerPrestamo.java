package Controller;

import Interfaces.IController;
import Interfaces.IPrestable;
import Model.Repositories.RepositorioLibro;
import Model.Repositories.RepositorioPrestamo;
import Model.Repositories.RepositorioUsuario;
import View.ViewPrestamo;
import Model.Entities.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerPrestamo implements  IPrestable {
    private ControllerLibro controllerLibro;
    private RepositorioPrestamo repositorioPrestamo;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioLibro repositorioLibro;
    private ViewPrestamo viewPrestamo;

    public ControllerPrestamo(RepositorioPrestamo repositorioPrestamo, ViewPrestamo viewPrestamo,
                              RepositorioLibro repositorioLibro, RepositorioUsuario repositorioUsuario,
                              ControllerLibro controllerLibro) {
        this.repositorioPrestamo = repositorioPrestamo;
        this.viewPrestamo = viewPrestamo;
        this.repositorioLibro = repositorioLibro;
        this.repositorioUsuario = repositorioUsuario;
        this.controllerLibro = controllerLibro;
    }

    public void registrarPrestamoController (Prestamo prestamo){
        this.repositorioPrestamo.registar(prestamo);
    }
    public void actualizarController (Prestamo prestamo){
        this.repositorioPrestamo.actualizar(prestamo.getId(), prestamo);
    }
    public void mostrarListController (){
        System.out.println("\nMuestra lista de prestamos\n");

        ArrayList<Prestamo> listPrestamo = this.repositorioPrestamo.getListPrestamos();
        int i = 1 ;
        if (!listPrestamo.isEmpty()) {
            for (Prestamo p : listPrestamo){
                System.out.println("--------------------------------------------------------");
                System.out.println(i+ "-");
                System.out.println(p.toString());
                System.out.println("--------------------------------------------------------");
                i++;
            }
        } else {
            System.out.println("\nLa lista esta vacia !! \n");
        }
    }

    public void realizarPrestamo(){
        Integer idLibro = -1;
        Integer idUsuario = -1;
        idUsuario = viewPrestamo.askForIdUsuario();
        Usuario usuario = (Usuario)this.repositorioUsuario.consultar(idUsuario);
        if (usuario != null) {
            System.out.println("\nEl usuario es valido !! \n");
            idLibro = viewPrestamo.askForIdLibro();
            Libro libro = (Libro) this.repositorioLibro.consultar(idLibro);
            if (libro != null){
                System.out.println("\nEl libro es valido !! ");
                Boolean prestado = libro.getPrestado();
                Prestamo prestamo = new Prestamo(libro, usuario);
                prestamo = registrarFechas(prestamo);

                if(!prestado){

                     libro.setPrestado(true);
                     this.controllerLibro.actualizarControllerDisponibilidadLibro(libro);
                     this.registrarPrestamoController(prestamo);

                    System.out.println("\n--------------------------- MUESTRA PRESTAMO ---------------------------------");
                    System.out.println(prestamo.toString());
                    System.out.println("---------------------------------------------------------------------------------");
                    System.out.println("\n¡¡ Prestamo registrado con exito !!");
                } else {
                    System.out.println(" El libro fue alquilado !! ");
                }
            } else {
                System.out.println("\n El id del libro ingresado no existe !! \n");
            }
        } else {
            System.out.println("\nEl usuario no existe !!! \n");
        }
    }
    public Prestamo  registrarFechas (Prestamo prestamo ){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaDevolucion = fechaActual.plusDays(5);
        prestamo.setFechaPrestamo(fechaActual);
        prestamo.setFechaDevolucion(fechaDevolucion);
         return  prestamo;
    }
    public  void permitirDevoluciones () {
        Integer id = viewPrestamo.askForIdToDevolver();
        Prestamo prestamo = (Prestamo) repositorioPrestamo.consultar(id);
        Boolean devuelto = false;

            if (prestamo != null) {
                devuelto = prestamo.getFueDevuelto();
                if (!devuelto) {
                    System.out.println(" El id del prestamo es valido ");
                    Libro libro = prestamo.getLibroPrestado();
                    libro.setPrestado(false);
                    prestamo.setFueDevuelto(true);
                    actualizarController(prestamo);
                    System.out.println("\nDevolucion efectuada con exito !!\n");
                } else {
                    System.out.println("\nEl libro ya fue devuelto!!!!");
                }
            } else {
                System.out.println("\n El id del prestamo no existe !! \n");
            }
    }
}
