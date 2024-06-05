package Controller;

import Model.Entitites.Automovil;
import Model.Repositories.RepositorioAutomovil;
import Vista.ViewAutomovil;

import java.util.List;
import java.util.Scanner;

public class AutomovilController {
    private RepositorioAutomovil repositorioAutomovil;
    private ViewAutomovil viewAutomovil;

    public AutomovilController(RepositorioAutomovil repositorioAutomovil, ViewAutomovil viewAutomovil) {
        this.repositorioAutomovil = repositorioAutomovil;
        this.viewAutomovil = viewAutomovil;
    }

    public  void crearAuto (){
        this.cargarAutoEnList( viewAutomovil.cargaAutomovilManual());
    }
    public void cargarAutoEnList (Automovil automovil){
repositorioAutomovil.getListAutomoviles().add(automovil);
    }
public  void eliminarAuto () {
    Integer id = viewAutomovil.pideIdParaEliminar();
    Automovil automovil = (Automovil) repositorioAutomovil.consultar(id);
    if(automovil != null){
        repositorioAutomovil.eliminar(id);
        System.out.println("Vehiculo eliminado\n");
        try {
            System.out.println("Cargando datos en sistema .... ");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Maneja la excepción si la interrupción del hilo ocurre mientras el hilo está dormido
            e.printStackTrace();
        }
    } else {
        System.out.println("El id del automovil no existe !!\n");
    }
}

public  void mostrarListAutomoviles (){
    List<Automovil> listAutomoviles = repositorioAutomovil.getListAutomoviles();
    if(!listAutomoviles.isEmpty()){
        for (Automovil a : listAutomoviles){
            viewAutomovil.mostrarAutomovil(a);
        }
    } else {
        System.out.println("La lista esta vacia !! \n ");
    }
}

    public void actualizarAutomovil () {
        Integer opcion = 0;
        Integer id = viewAutomovil.pideIdParaActualizar();
        String dato = " ";
        Integer cantidadDeRuedas = 0;
        Automovil automovil = (Automovil) repositorioAutomovil.consultar(id);
        if (automovil != null) {
            opcion = viewAutomovil.opcionCampoAActualiar();
            switch (opcion) {
                case 1:
                    System.out.println("Cambia modelo ");
                    dato = viewAutomovil.pideDatoYloRetorna();
                    automovil.setModelo(dato);
                    break;
                case 2:
                    System.out.println("Cambia marca ");
                    dato = viewAutomovil.pideDatoYloRetorna();
                    automovil.setMarca(dato);
                    break;
                case 3:
                    System.out.println("Cambia motor  ");
                    dato = viewAutomovil.pideDatoYloRetorna();
                    automovil.setMotor(dato);
                    break;
                case 4:
                    System.out.println("Cambia cantidad de ruedas ");
                    cantidadDeRuedas = viewAutomovil.pideDatoEnteroYloRetorna();
                    automovil.setRuedas(cantidadDeRuedas);
                    break;
                case 5:
                    System.out.println("\n El estado actual de su cierre centralizado es: " + automovil.isCierreCentralizado());
                    System.out.println("Si desea poner que tiene, tipee True, si no False\n");
                    Scanner scanner = new Scanner(System.in);
                    String datoCierre = scanner.nextLine();
                    Boolean booleano = datoCierre.equalsIgnoreCase("true") ? true : false;
                    automovil.setCierreCentralizado(booleano);
                    break;
            }
            repositorioAutomovil.actualizar(automovil.getId(), automovil);
            System.out.println("Automovil actualizado !!\n");
            try {
                System.out.println("\nCargando datos en sistema .... ");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // Maneja la excepción si la interrupción del hilo ocurre mientras el hilo está dormido
                e.printStackTrace();
            }
        } else {
            System.out.println("El id del automovil ingresado no existe !! \n ");
        }
    }

    }

