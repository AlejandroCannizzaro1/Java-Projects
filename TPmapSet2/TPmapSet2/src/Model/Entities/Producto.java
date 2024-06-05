package Model.Entities;

import java.util.*;

public class Producto implements Comparable <Producto> {
    private String nameProducto;
    private float precio;
    private Integer idProducto;
    private static Integer nextIdProducto = 1;
    private Categoria categoria;

    public Producto(String nameProducto, float precio) {
        this.nameProducto = nameProducto;
        this.precio = precio;
        this.categoria = null;
        this.idProducto = getNextIdProducto();
    }


    public String getNameProducto() {
        return nameProducto;
    }

    public void setNameProducto(String nameProducto) {
        this.nameProducto = nameProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public static Integer getNextIdProducto() {
        return nextIdProducto++;
    }

    public static void setNextIdProducto(Integer nextIdProducto) {
        Producto.nextIdProducto = nextIdProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || this.getClass() != object.getClass())
            return false;
        Producto producto = (Producto) object;
        return Objects.equals(this.getNameProducto(), producto.getNameProducto());
    }
    @Override
    public int hashCode (){
        return Objects.hashCode(this.nameProducto);
    }

    @Override
    public int compareTo (Producto producto){
        int comparacionNameProducto = this.nameProducto.compareTo(producto.getNameProducto());
        if (comparacionNameProducto != 0 ){
            return comparacionNameProducto;
         } else {
            return this.idProducto.compareTo(producto.getIdProducto());
        }
    }
    @Override
    public String toString (){
        System.out.println( "--------------------------------------------" +
                            "--------------------------------------------");
        System.out.println(this.categoria.toString());
        return  "\nProducto: " + nameProducto + "\nId producto : " +idProducto + "\nPrecio: " + precio +
                "\n--------------------------------------------" +
                "--------------------------------------------";
    }

}