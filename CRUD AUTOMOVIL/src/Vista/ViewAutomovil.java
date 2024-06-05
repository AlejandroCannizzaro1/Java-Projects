package Vista;

import Model.Entitites.Automovil;

import java.util.Scanner;

public class ViewAutomovil {
    public void mostrarAutomovil (Automovil automovil){
        System.out.println("-------------------------------------------------");
        System.out.println("Marca:" +automovil.getMarca());
        System.out.println("Modelo:" +automovil.getModelo());
        System.out.println("Motor:" +automovil.getMotor());
        System.out.println("Cantidad de ruedas: " +automovil.getRuedas());
        System.out.println("Cierre centralizado: " +automovil.isCierreCentralizado());
        System.out.println("Id: " + automovil.getId());
        System.out.println("--------------------------------------------------");
    }
    public Automovil cargaAutomovilManual () {
        boolean cierreCentralizado = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Modificar auto ");
        System.out.println("Ingrese marca del vehiculo:");
        String marca = scanner.nextLine();
        System.out.println("Ingrese motor del vehiculo");
        String motor = scanner.nextLine();
        System.out.println("Ingrese modelo del vehiculo");
        String modelo = scanner.nextLine();
        System.out.println("Ingrese true si tiene cierre centralizado, false si no tiene ");
        String cierreCentralizadoString = scanner.nextLine();
        cierreCentralizado = cierreCentralizadoString.equalsIgnoreCase("true") ? true : false;
        System.out.println("Ingrese cantida de ruedas  del vehiculo");
        Integer cantRuedas = scanner.nextInt();
        Automovil automovil = new Automovil(marca, motor, cantRuedas, modelo, cierreCentralizado);
        System.out.println("Vehiculo creado con exito !!! ");
      return automovil;
    }
    public Integer pideIdParaActualizar (){
        System.out.println("\nIngrese el id del automovil a actualizar");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        return id;
    }

    public Integer pideIdParaEliminar (){
        System.out.println("\nIngrese el id del automovil a eliminar");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        return id;
    }


    public Integer opcionCampoAActualiar (){
        Integer opcion = 0;
        do {
            System.out.println("\nIngrese la opcion que desea modificar ");
            System.out.println("1-Modelo");
            System.out.println("2-Marca");
            System.out.println("3-Motor");
            System.out.println("4-Cantidad de ruedas");
            System.out.println("5-Cierre centralizado");
            Scanner scanner = new Scanner(System.in);
           opcion = scanner.nextInt();
           if(opcion<0 || opcion>5){
               System.out.println("\n incorrecta.Reintente!!\n ");
           }
        } while (opcion<0 || opcion>5);
        return opcion;
    }
public String pideDatoYloRetorna (){
    System.out.println("\nIngrese el nuevo texto a asignar a este campo");
    Scanner scanner = new Scanner(System.in);
    String dato = scanner.nextLine();
    return dato;
}

    public Integer pideDatoEnteroYloRetorna (){
        System.out.println("\nIngrese el nuevo entero a asignar a este campo");
        Scanner scanner = new Scanner(System.in);
        Integer  dato = scanner.nextInt();
        return dato;
    }
}
