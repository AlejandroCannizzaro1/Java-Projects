package Model.Entities;

import java.time.LocalDate;

public class Comics extends Libro {
    private String personaje;

    public Comics(Float precio, Double precioVenta, LocalDate fechaPublicacion,
                  String autor, String titulo, String editorial, String personaje,
                  String tipoDeProducto) {
        super(precio, precioVenta, fechaPublicacion, autor, titulo, editorial, tipoDeProducto);
        this.personaje = personaje;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    @Override
    public void mostrarProducto (){
        super.mostrarProducto();
        System.out.println("Pesonaje: " + personaje);
    }
}
