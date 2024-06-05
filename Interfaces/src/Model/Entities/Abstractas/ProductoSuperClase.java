package Model.Entities.Abstractas;

import Interfaces.IProducto;

public abstract class ProductoSuperClase implements IProducto {

private Float precio;
private Double precioVenta;
private Integer idProducto;
private static Integer nextId = 1;
private String tipoDeProducto;

    public ProductoSuperClase(Float precio, Double precioVenta, String tipoDeProducto) {
        this.precio = precio;
        this.precioVenta = precioVenta;
        this.tipoDeProducto = tipoDeProducto;
        this.idProducto = getNextId();
    }

    public Integer getId() {
        return idProducto;
    }

    public void setId(Integer id) {
        this.idProducto = id;
    }

    public static Integer getNextId() {
        return nextId++;
    }

    public static void setNextId(Integer nextId) {
        ProductoSuperClase.nextId = nextId;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    public Float  getPrecio(){
        return this.precio;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public  double getPrecioVenta(){
        return this.precioVenta;
    }
    public void mostrarProducto (){
        System.out.println("Tipo de producto: " + tipoDeProducto);
        System.out.println("Costo: $" + precio );
        System.out.println("Precio de venta: $" +precioVenta );
        System.out.println("Id producto:" + idProducto);
    }
}
