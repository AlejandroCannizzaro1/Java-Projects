package Model.Entities;

import java.time.LocalDate;

public class Prestamo {
    private Libro libroPrestado;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Boolean fueDevuelto;
    private Integer id;
    private Integer nextId = 1;

    public Prestamo(Libro libroPrestado, Usuario usuario) {
        this.libroPrestado = libroPrestado;
        this.usuario = usuario;
        this.id = getNextId();
        this.fueDevuelto = false;

    }

    public Boolean getFueDevuelto() {
        return fueDevuelto;
    }

    public void setFueDevuelto(Boolean fueDevuelto) {
        this.fueDevuelto = fueDevuelto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNextId() {
        return nextId++;
    }

    public void setNextId(Integer nextId) {
        this.nextId = nextId;
    }

    public Libro getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(Libro libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString () {
        Libro libro = getLibroPrestado();
        Usuario usuario = getUsuario();
        System.out.println("\n*Usuario que realizo el prestamo:");
        System.out.println(usuario.toString());

        System.out.println("\n*Libro prestado: ");
        System.out.println(libro.toString());

        return "\n*Fecha de prestamo: " + fechaPrestamo + "\n*Fecha de devolucion: "+fechaDevolucion+
                "\nDevolucion: " + fueDevuelto;

    }
}
