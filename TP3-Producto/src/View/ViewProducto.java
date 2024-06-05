package View;

import Model.Entitites.Producto;

import java.util.Scanner;

public class ViewProducto {
    public void muestraProducto (Producto producto){
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------");
        System.out.println("Nombre : " + producto.getName());
        System.out.println("Id : "+ producto.getId());
        System.out.println("Precio : $" + producto.getPrecioProducto());
        System.out.println("Categoria producto: " + producto.getCategoria().getName());
        System.out.println("Id Categoria : " + producto.getCategoria().getId());
        System.out.println("------------------------------");
    }
public Producto crearProducto (){
    Scanner scanner = new Scanner(System.in);
    String dato = " ";
    Float precio = 0.00F;
    System.out.println("Ingrese el nombre de el producto  ");
    dato = scanner.nextLine();
    System.out.println("Ingrese el precio del producto");
    precio = scanner.nextFloat();
    Producto producto = new Producto(dato, precio);
    return producto;
}
    public Integer pideIdProductoParaActualizar (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Ingrese el id de el producto para actualizar");
        Integer id = scanner.nextInt();
        return id;
    }

    public Integer pideIdProductoParaEliminar (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Ingrese el id de el producto para eliminar");
        Integer id = scanner.nextInt();
        return id;
    }
    public Integer muestraCamposProductoParaActualizar (){
        Integer opcion = 0 ;
       do {
           System.out.println("\nActualizar producto");
           System.out.println("Elija una opcion: ");
           System.out.println("1-Nombre producto ");
           System.out.println("2-Precio producto");
           System.out.println("3-Categoria del producto");
           Scanner scanner = new Scanner(System.in);
           opcion = scanner.nextInt();
           if(opcion<1 || opcion>3){
               System.out.println("Opcion incorrecta.Reintente !! \n");
           }
       } while (opcion<1 || opcion>3);
       return opcion;
    }

    public Float pideCostoProductoParaActualizar (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nuevo precio  de el producto para actualizar");
        Float costo = scanner.nextFloat();
        return costo;
    }
    public String  pideNombreProductoParaActualizar (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nuevo nombre  de el producto para actualizar");
        String dato = scanner.nextLine();
        return dato;
    }
}
