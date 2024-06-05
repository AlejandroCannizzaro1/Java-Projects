package View;

import Interfaces.Iview;
import Model.Entities.Vuelo;
import Model.Repositories.RepositorioVuelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class ViewVuelo implements Iview {
    private RepositorioVuelo repositorioVuelo;

    public ViewVuelo(RepositorioVuelo repositorioVuelo) {
        this.repositorioVuelo = repositorioVuelo;
    }

    public Object crearObject(){

        // Crea tipo de dato LocalTime para la hora
        LocalDate fechaLocalDate = null;
        LocalTime horaLocalTime = null;
        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm 'hs'");

        System.out.println("\n-------------------------------------------------------------");
        System.out.println("Registra vuelo");
        String nameAlfanumerico = askForData("Ingrese el tipo de codigo alfanumerico del  vuelo ");
        String origenVuelo = askForData("Ingrese el origen");
        String destinoVuelo = askForData("Ingrese el destino del vuelo");
        Integer cantidadDePasajeros = askForInteger("Ingrese cantidad de pasajeros");

// Pide fecha de llegada del vuelo y limpia con trim () cualquier espacio en blanco
        String fechaLlegadaVueloString = askForData(
                "\nAtencion !!! \nRecuerde el siguiente  formato para introducir la fecha  del vuelo" +
                        " a continuacion :\n" +
                " dd 'de' MMMM 'de' yyyy (31 de Agsosto de 2021, por ejemplo) , si no se producira un  error!! \n" +
                "\nIngrese la fecha de  llegada del  vuelo:" );

        // Convierte fecha String a minusculas
fechaLlegadaVueloString = fechaLlegadaVueloString.toLowerCase();

// Pide hora de llegada del vuelo y limpia con trim () cualquier espacio en blanco
        String horaDeLlegadaDelVueloString = askForData(
                "\nAtencion !!! \nRecuerde el siguiente formato para introducir la hora del  vuelo a continuacion " +
                        ":\nHH:mm " +
                "(15:45, por ejemplo), si no se producira un  error!\n" +
                "Ingrese la hora de llegada del vuelo:\n");

        // Covierte hora String y luego le agrega "hs" al String
        horaDeLlegadaDelVueloString = horaDeLlegadaDelVueloString.toLowerCase();
        horaDeLlegadaDelVueloString = horaDeLlegadaDelVueloString + " hs";

// Parsea de String a LocalDate
        try {
            fechaLocalDate = LocalDate.parse (fechaLlegadaVueloString , formatterFecha);
        } catch ( DateTimeParseException e){
            System.out.println("Error de formato en la fecha !! ");
            e.printStackTrace();
            return null;
        }
// Parsea de String a LocalTime
        try {
             horaLocalTime = LocalTime.parse(horaDeLlegadaDelVueloString, formatterHora);
            Vuelo vuelo = new Vuelo(nameAlfanumerico, origenVuelo, destinoVuelo,
                    cantidadDePasajeros,fechaLocalDate, horaLocalTime) ;
            System.out.println("\nVuelo registrado con exito!! \n");
            return vuelo;
        } catch (DateTimeException e ){
            System.out.println("Error en el parseado !! ");
            e.printStackTrace();
            return null;
        }

    }
    public Integer menuActualizarObject (){
        return null;
    }
    public void mostrarList (){
       ArrayList<Vuelo> listVuelo = this.repositorioVuelo.getListVuelos();
       if (!listVuelo.isEmpty()){
           System.out.println("--------------------------------------------------------------------------------");
           System.out.println("\nMuestra List de vuelos \n");
            for (Vuelo v : listVuelo){
                System.out.println(v.toString());
            }
           System.out.println("----------------------------------------------------------------------------------");
       } else {
           System.out.println("\nLa lista de vuelos esta vacia !! \n");
       }
    }
    public Integer askForInteger (String string){
        Integer elemento = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println(string);
        elemento = scanner.nextInt();
        return elemento;
    }
    public String askForData (String string){
        String data = " ";
        Scanner scanner = new Scanner(System.in);
        System.out.println(string);
        data = scanner.nextLine();
        return data;
    }

}
