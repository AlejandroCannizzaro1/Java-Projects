package View;

import Interfaces.IView;
import Model.Entities.CarritoDeCompras;
import Model.Entities.Producto;
import Model.Repositories.CarritoDeComprasRepository;

import java.util.*;

public class CarritoDeComprasView implements IView {
    private CarritoDeComprasRepository carritoDeComprasRepository;




    public CarritoDeComprasView(CarritoDeComprasRepository carritoDeComprasRepository) {
        this.carritoDeComprasRepository = carritoDeComprasRepository;
    }

    public Object crearObject (){
        System.out.println("Registra producto");
        String name = askForData("Ingrese el nombre del producto");
        Float precio = askForFloat("Ingrese el precio del producto");
        Producto producto = new Producto(name, precio);
        return producto;

    }
    public Integer subMenuactualizarObject (){
      return null;
    }
    public String askForData (String string ){
        Scanner scanner = new Scanner(System.in);
        System.out.println(string);
        String data = scanner.nextLine();
        return  data;
    }
    public Integer askForInteger (String string){
        Scanner scanner = new Scanner(System.in);
        System.out.println(string);
        Integer data = scanner.nextInt();
        return  data;
    }

    public Float askForFloat (String string){
        Scanner scanner = new Scanner(System.in);
        System.out.println(string);
        return scanner.nextFloat();

    }

public  void mostrarColeccion (){

        if (!this.carritoDeComprasRepository.getMapCarritoCompras().isEmpty()) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Muestra coleccion de carritosDeCompra ");
            for (Map.Entry<String, CarritoDeCompras> entry :
                    this.carritoDeComprasRepository.getMapCarritoCompras().entrySet()) {
                CarritoDeCompras carritoDeCompras = entry.getValue();
                System.out.println(carritoDeCompras.toString());
            }
        } else {
            System.out.println("\nNo hay datos en la coleccion de carritos de compra !! \n");
        }
}
    public void  mostrarProductosCarrito (){
        String nameTitular = askForData
                ("\nIngrese el nombre del titular  del carrito de comras\n");
        CarritoDeCompras carritoDeCompras = (CarritoDeCompras) this.carritoDeComprasRepository.consultar(nameTitular);
        if (carritoDeCompras != null){
            System.out.println(carritoDeCompras.toString());
        } else {
            System.out.println("\nEl nombre del titular  del carrito de compras no es valido !! \n");
        }
    }
public void muestraCategoriasCarrito (){
    String nameTitular = askForData
            ("\nIngrese el nombre del titular  del carrito de comras\n");
    CarritoDeCompras carritoDeCompras = (CarritoDeCompras) this.carritoDeComprasRepository.
            consultar(nameTitular);
    if (carritoDeCompras != null){
        carritoDeCompras.muestraCategoriasDeCarritoDeCompras();
    } else {
        System.out.println("\nEl nombre del titular del carrito de compras no es valido !! \n");
    }
}

    }
