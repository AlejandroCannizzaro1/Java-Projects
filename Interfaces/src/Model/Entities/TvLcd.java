package Model.Entities;

import Interfaces.IProducto;
import Model.Entities.Abstractas.Electronico;

public class TvLcd extends Electronico implements IProducto {

private Float pulgadas;

    public TvLcd(Float precio, Double precioVenta, String fabricante,
                 Float pulgadas, String tipoDeProducto) {
        super(precio, precioVenta, fabricante, tipoDeProducto);
        this.pulgadas = pulgadas;
    }

    public Float getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(Float pulgadas) {
        this.pulgadas = pulgadas;
    }

@Override
public void mostrarProducto (){
    super.mostrarProducto();
    System.out.println("Pulgadas: " + pulgadas);

}

}
