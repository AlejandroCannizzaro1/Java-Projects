package Model.Entities;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private Boolean prestado;
    private Integer cantidadDeCopias;
    private Integer id;
    private Integer nextId = 1;

    public Libro(String titulo, String autor, String genero, Integer cantidadDeCopias) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.cantidadDeCopias = cantidadDeCopias;
        this.prestado = false;
        this.id = getNextId();

    }

    public Boolean getPrestado() {
        return prestado;
    }

    public void setPrestado(Boolean prestado) {
        this.prestado = prestado;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getCantidadDeCopias() {
        return cantidadDeCopias;
    }

    public void setCantidadDeCopias(Integer cantidadDeCopias) {
        this.cantidadDeCopias = cantidadDeCopias;
    }
 @Override
 public String toString () {
        return "\nTitulo : " + titulo + "\nGenero: " +genero + "\nAutor: " + autor +
                "\nCantidad de copias: " + cantidadDeCopias + "\nPrestado: " + prestado;
 }
}
