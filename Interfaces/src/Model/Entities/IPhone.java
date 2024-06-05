package Model.Entities;

import Model.Entities.Abstractas.Electronico;

public class IPhone extends Electronico  {
private String color;
private String modelo ;

    public IPhone(Float precio, Double precioVenta, String fabricante, String color, String modelo,
                  String tipoDeProducto) {
        super(precio, precioVenta, fabricante, tipoDeProducto);
        this.color = color;
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    @Override
    public void mostrarProducto (){
        super.mostrarProducto();
        System.out.println("Color: " +color );
        System.out.println("Modelo: " +modelo );

    }
}
