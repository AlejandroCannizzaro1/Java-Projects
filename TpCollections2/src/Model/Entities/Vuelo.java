package Model.Entities;
import java.util.*;
import java.time.*;
public class Vuelo implements Comparable <Vuelo>{
private String vueloAlfanumerico;
private String origen;
private String destino;
private Integer numeroDeVuelo;
private static Integer nextNumeroDeVuelo = 1;
private Integer cantidadDePasajeros;
private LocalDate  fechaDeLlegada;
private LocalTime horaDeLlegada;
private DayOfWeek diaDeLaSemana;



    public Vuelo(String vueloAlfanumerico, String origen, String destino,
                 Integer cantidadDePasajeros, LocalDate fechaDeLlegada, LocalTime horaDeLlegada) {
        this.vueloAlfanumerico = vueloAlfanumerico;
        this.origen = origen;
        this.destino = destino;
        this.numeroDeVuelo =getNextNumeroDeVuelo();
        this.cantidadDePasajeros = cantidadDePasajeros;
        this.fechaDeLlegada = fechaDeLlegada;
        this.horaDeLlegada = horaDeLlegada;
        this.diaDeLaSemana = getDayOfWeek();
    }

    public DayOfWeek getDiaDeLaSemana() {
        return diaDeLaSemana;
    }

    public void setDiaDeLaSemana(DayOfWeek diaDeLaSemana) {
        this.diaDeLaSemana = diaDeLaSemana;
    }
    public DayOfWeek getDayOfWeek (){
        return this.fechaDeLlegada.getDayOfWeek();
    }
    public LocalTime getHoraDeLlegada() {
        return horaDeLlegada;
    }

    public void setHoraDeLlegada(LocalTime horaDeLlegada) {
        this.horaDeLlegada = horaDeLlegada;
    }

    public String getVueloAlfanumerico() {
        return vueloAlfanumerico;
    }

    public void setVueloAlfanumerico(String vueloAlfanumerico) {
        this.vueloAlfanumerico = vueloAlfanumerico;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Integer getNumeroDeVuelo() {
        return numeroDeVuelo;
    }

    public void setNumeroDeVuelo(Integer numeroDeVuelo) {
        this.numeroDeVuelo = numeroDeVuelo;
    }

    public static Integer getNextNumeroDeVuelo() {
        return nextNumeroDeVuelo++;
    }

    public static void setNextNumeroDeVuelo(Integer nextNumeroDeVuelo) {
        Vuelo.nextNumeroDeVuelo = nextNumeroDeVuelo;
    }

    public Integer getCantidadDePasajeros() {
        return cantidadDePasajeros;
    }

    public void setCantidadDePasajeros(Integer cantidadDePasajeros) {
        this.cantidadDePasajeros = cantidadDePasajeros;
    }

    public LocalDate getFechaDeLlegada() {
        return fechaDeLlegada;
    }

    public void setFechaDeLlegada(LocalDate fechaDeLlegada) {
        this.fechaDeLlegada = fechaDeLlegada;
    }



    @Override
    public int compareTo (Vuelo vuelo){
        int comparacionesFecha = this.fechaDeLlegada.compareTo(vuelo.getFechaDeLlegada());
        if (comparacionesFecha != 0){
            return comparacionesFecha;
        } else {
            return this.horaDeLlegada.compareTo(vuelo.horaDeLlegada);
        }
    }

    @Override
    public String toString (){
        System.out.println("---------------------------------------------------------------------------");
        return "\nVuelo numero: " +numeroDeVuelo+ "\nCodigo alfanumerico vuelo: " +vueloAlfanumerico + "\nOrigen: " + origen + "\nDestino: " + destino +
                "\nCantidad de pasajeros: " + cantidadDePasajeros + "\nFecha de llegada : " +
                diaDeLaSemana + " " + fechaDeLlegada + "\nHorario de llegada : " + horaDeLlegada;
    }
        }