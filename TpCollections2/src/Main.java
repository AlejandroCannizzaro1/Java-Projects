import Controller.ControllerVuelo;
import Model.Entities.Vuelo;
import Model.Repositories.RepositorioVuelo;
import View.ViewVuelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        RepositorioVuelo repositorioVuelo = new RepositorioVuelo();
        ViewVuelo viewVuelo = new ViewVuelo(repositorioVuelo);
        ControllerVuelo controllerVuelo = new ControllerVuelo (viewVuelo, repositorioVuelo);

        ArrayList <LocalTime> listHorasDeLlegada = new ArrayList<>();
        ArrayList <LocalDate> listFechasDeLlegada = new ArrayList<>();

        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm 'hs'");

        ArrayList<String> listCodigoVuelos = new ArrayList<>(Arrays.asList("AAL 933", "LAT 755", "SKU 621", "DAL 147",
                "AVA 241", "AMX 10", "IBE 6833", "LAT 2479", "SKU 803", "LAT 533", "LAT 1447",
                "CMP 111", "LAT 705", "AAL 957", "ARG 5091", "LAT 1283", "LAT 579", "AAL 945", "LAT 501", "LAT 405"));
        ArrayList<String> listOrigenVuelos = new ArrayList<>(Arrays.asList("New York", "Sao Paulo",
                "Rio De Janeiro", "Atlanta", "Bogota", "Mexico City", "Londres", "Frankfurt",
                "Lima", "Los Ángeles", "Guayaquil", "Panama City", "Madrid", "Miami", "Buenos Aires",
                "Cancún", "Barcelona", "Dallas-Fort Worth", "París", "Montevideo"));
        ArrayList<String> lisDestinosVuelos = new ArrayList<>();
        for (int i = 0; i < listOrigenVuelos.size(); i++) {
            lisDestinosVuelos.add("Santiago");
        }
        ArrayList<Integer> listCantidadDePasajeros = new ArrayList<>(Arrays.asList(62, 47, 25, 59, 25, 29, 55
                , 51, 48, 59, 31, 29, 47,
                60, 32, 35, 61, 58, 49, 39));

        ArrayList<String> fechasString = new ArrayList<>(Arrays.asList("29 de agosto de 2021",
                "31 de agosto de 2021", "30 de agosto de 2021", "29 de agosto de 2021",
                "31 de agosto de 2021", "31 de agosto de 2021", "30 de agosto de 2021",
                "29 de agosto de 2021", "30 de agosto de 2021", "29 de agosto de 2021",
                "31 de agosto de 2021", "31 de agosto de 2021", "30 de agosto de 2021",
                "29 de agosto de 2021", "31 de agosto de 2021", "31 de agosto de 2021",
                "29 de agosto de 2021", "30 de agosto de 2021", "29 de agosto de 2021",
                    "30 de agosto de 2021"));

        ArrayList<String> horasString = new ArrayList<>(Arrays.asList("05:39 hs", "04:45 hs",
                "16:00 hs", "13:22 hs", "14:05 hs", "05:20 hs", "08:45 hs", "07:41 hs",
                "10:35 hs", "09:14 hs", "08:33 hs", "15:15 hs", "08:14 hs", "22:53 hs",
                "09:57 hs", "04:00 hs", "07:45 hs", "07:12 hs", "18:29 hs", "15:45 hs"));




        for (int i = 0 ; i<fechasString.size(); i++) {
            try {
                LocalDate fecha = LocalDate.parse(fechasString.get(i), formatterFecha);
                listFechasDeLlegada.add(fecha);

            } catch (DateTimeParseException e) {
                System.out.println("\nError en el parseado !! \n");
                e.printStackTrace();
                System.exit(0);
            }
        }
        for (int i = 0 ; i<horasString.size(); i++) {
            try {
                LocalTime hora = LocalTime.parse(horasString.get(i), formatterHora);
                listHorasDeLlegada.add(hora);
            } catch (DateTimeParseException e) {
                System.out.println("\nError en el parseado !! \n");
                e.printStackTrace();
            }
        }
        for (int i = 0;i<listCodigoVuelos.size();i++){
            String codigoVuelo = listCodigoVuelos.get(i);
            String origenVuelo = listOrigenVuelos.get(i);
            String destinoVuelo = lisDestinosVuelos.get(i);
            Integer cantidadDePasajeros = listCantidadDePasajeros.get(i);
            LocalDate fecha = listFechasDeLlegada.get(i);
            LocalTime hora = listHorasDeLlegada.get(i);
            Vuelo vuelo = new Vuelo(codigoVuelo, origenVuelo, destinoVuelo, cantidadDePasajeros,
                    fecha, hora);
            controllerVuelo.registrarController(vuelo);
        }
        controllerVuelo.ordenaListaConSort();
        viewVuelo.mostrarList();

        Vuelo lastVuelo = controllerVuelo.getLastVuelo();
        System.out.println("\n\n\nMuestra ultimo vuelo en salir");
        System.out.println(lastVuelo.toString());
        System.out.println("-------------------------------------------------------------------------");


        ArrayList<Vuelo> listVuelosMenores = controllerVuelo.getVueloConMenorNumeroDePasajeros();
        System.out.println("\n\n\nMuestra vuelos con menor cantidad de pasajeros");
        for (Vuelo v: listVuelosMenores){
            System.out.println(v.toString());
            System.out.println("-----------------------------------------------------------------------");
        }

        System.out.println("\n\n");
        controllerVuelo.crearController();
        viewVuelo.mostrarList();
}
}