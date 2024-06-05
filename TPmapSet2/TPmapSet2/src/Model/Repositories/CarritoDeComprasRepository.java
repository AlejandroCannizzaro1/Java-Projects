package Model.Repositories;


import Model.Entities.CarritoDeCompras;
import java.util.*;

public class CarritoDeComprasRepository  {
    private Map<String , CarritoDeCompras> mapCarritoCompras;

    public CarritoDeComprasRepository() {
        this.mapCarritoCompras = new HashMap<>();
    }

    public Map<String, CarritoDeCompras> getMapCarritoCompras() {
        return mapCarritoCompras;
    }

    public void setMapCarritoCompras(Map <String, CarritoDeCompras> mapCarritoCompras) {
        this.mapCarritoCompras = mapCarritoCompras;
    }

    public CarritoDeCompras consultar (String nameTitular ){
       if (mapCarritoCompras.containsKey(nameTitular))
           return  mapCarritoCompras.get(nameTitular);
      else {
          return null;
       }
    }
    public boolean eliminar (String nameTitular ){

        CarritoDeCompras carritoDeCompras =  consultar(nameTitular);
        if (carritoDeCompras != null) {
            return this.mapCarritoCompras.remove(carritoDeCompras.getTitularDelCarrito(), carritoDeCompras);
        }  else{
            return false;
        }
    }
    public boolean registrar (CarritoDeCompras carritoDeCompras){
            boolean existeEnList = true;

            if (carritoDeCompras != null){
                existeEnList = this.mapCarritoCompras.containsKey(carritoDeCompras.getTitularDelCarrito());
                this.mapCarritoCompras.put(carritoDeCompras.getTitularDelCarrito(), carritoDeCompras);
            }
        return  existeEnList;
    }
    public boolean actualizar (String nameTitular, CarritoDeCompras carritoDeComprasUptaded){

        boolean contieneKey = false;

            if (carritoDeComprasUptaded != null){
                contieneKey = this.mapCarritoCompras.containsKey(nameTitular);
                if (contieneKey){
                    this.mapCarritoCompras.put(carritoDeComprasUptaded.getTitularDelCarrito(),
                            carritoDeComprasUptaded);
                }
        }
        return contieneKey;
    }





}
