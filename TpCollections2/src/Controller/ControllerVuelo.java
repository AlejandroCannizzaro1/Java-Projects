package Controller;

import javax.swing.text.View;

import Model.Repositories.RepositorioVuelo;
import View.ViewVuelo;
import Model.Entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ControllerVuelo {
    private ViewVuelo viewVuelo;
    private RepositorioVuelo repositorioVuelo;

    public ControllerVuelo(ViewVuelo viewVuelo, RepositorioVuelo repositorioVuelo) {
        this.viewVuelo = viewVuelo;
        this.repositorioVuelo = repositorioVuelo;
    }

    public void ordenaListaConSort (){
        ArrayList<Vuelo> listVuelos = this.repositorioVuelo.getListVuelos();
        Collections.sort(listVuelos);
        this.repositorioVuelo.setListVuelos(listVuelos);
    }
    public void crearController (){
        this.registrarController(viewVuelo.crearObject());
    }
    public void registrarController (Object object){
        this.repositorioVuelo.registrar((Vuelo)object);
    }
    public void eliminarContoller (){
        String codigoVuelo = viewVuelo.askForData("\nIngrese el codigo alfanumerico del vuelo");
        Vuelo vuelo = (Vuelo) this.repositorioVuelo.consultar(codigoVuelo);
        if (vuelo != null){
            this.repositorioVuelo.eliminar(codigoVuelo);
        } else {
            System.out.println("\nEl codigo alfanumerico de ese vuelo no existe\n");
        }
    }

    // Obtiene el ultimo vuelo de un arreglo ordenado con sort, ya que invierte el array y retorna el primer
    // elemento, que en forma ascendente, seria el ultimo
    public Vuelo getLastVuelo (){
        ArrayList <Vuelo> listVuelo = this.repositorioVuelo.getListVuelos();
        Collections.reverse(listVuelo);
        Vuelo vuelo = listVuelo.get(0);
        Collections.reverse(listVuelo);
        return vuelo;
    }

    // Retorna ArrayList con los vuelos con menor cantidad de pasajeros
    public ArrayList<Vuelo> getVueloConMenorNumeroDePasajeros (){
        ArrayList<Vuelo> vuelosMenores = new ArrayList<>();
        vuelosMenores.add(this.repositorioVuelo.getListVuelos().get(0));
        ArrayList<Vuelo> listVuelos = this.repositorioVuelo.getListVuelos();
        Integer i = 0 ;
        for (i = 1;i<listVuelos.size();i++){
            if(listVuelos.get(i).getCantidadDePasajeros() < vuelosMenores.get(0).getCantidadDePasajeros()){
                vuelosMenores.set(0, listVuelos.get(i));
            } else if (listVuelos.get(i).getCantidadDePasajeros() == vuelosMenores.get(0).getCantidadDePasajeros()){
                vuelosMenores.add(listVuelos.get(i));
            }
        }
        return  vuelosMenores;
    }
    public void actualizarController (){}
}
