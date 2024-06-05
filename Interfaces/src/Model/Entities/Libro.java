package Model.Entities;

import Interfaces.ILibro;
import Model.Entities.Abstractas.ProductoSuperClase;

import java.time.LocalDate;
import java.util.Date;

public class Libro extends ProductoSuperClase implements ILibro {
    private LocalDate fechaPublicacion;
    private String autor;
    private String titulo;
    private String editorial;

    public Libro(Float precio, Double precioVenta, LocalDate fechaPublicacion,
                 String autor, String titulo, String editorial, String tipoDeProducto ) {
        super(precio, precioVenta, tipoDeProducto );
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
    }

    public LocalDate getFechaPublicacion(){
        return this.fechaPublicacion;
    }
    public String getAutor(){
        return this.autor;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public String getEditorial(){
        return this.editorial;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public void mostrarProducto (){
        super.mostrarProducto();
        System.out.println("Fecha publicacion: " + fechaPublicacion);
        System.out.println("Autor :" + autor);
        System.out.println("Titulo:  " + titulo);
        System.out.println("Editorial :  " + editorial);

    }
}
