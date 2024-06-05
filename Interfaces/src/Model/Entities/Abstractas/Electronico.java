package Model.Entities.Abstractas;

import Interfaces.IElectronico;

public abstract class   Electronico extends ProductoSuperClase implements IElectronico {
    private String fabricante;

    public Electronico(Float precio, Double precioVenta, String fabricante, String tipoDeProducto) {
        super(precio, precioVenta, tipoDeProducto);
        this.fabricante = fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFabricante (){
        return this.fabricante;
    }
    @Override
    public void mostrarProducto (){
        super.mostrarProducto();
        System.out.println("Fabricante producto: "+fabricante);
    }
}
