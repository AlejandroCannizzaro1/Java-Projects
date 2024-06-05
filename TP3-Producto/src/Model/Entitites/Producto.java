package Model.Entitites;

public class Producto {
    private String name;
    private Integer id;
    private static  Integer nextId = 1 ;
    private Float precioProducto;
    private Categoria categoria;

    public Producto(String name, Float precioProducto) {
        this.name = name;
        this.id = getNextId();
        this.precioProducto = precioProducto;
        this.categoria = null;
    }
    public Producto(String name, Float precioProducto, Categoria categoria) {
        this.name = name;
        this.id = getNextId();
        this.precioProducto = precioProducto;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getNextId() {
        return nextId++;
    }

    public static void setNextId(Integer nextId) {
        Producto.nextId = nextId;
    }

    public Float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Float precioProducto) {
        this.precioProducto = precioProducto;
    }
}
