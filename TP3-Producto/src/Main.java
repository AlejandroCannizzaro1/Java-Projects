import Controller.ControllerCategoria;
import Controller.ControllerProducto;
import Model.Entitites.Categoria;
import Model.Entitites.Producto;
import Model.Repositories.RepositorioCategoria;
import Model.Repositories.RepositorioProducto;
import View.ViewCategoria;
import View.ViewGeneral;
import View.ViewProducto;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ViewProducto viewProducto = new ViewProducto();
        ViewCategoria viewCategoria = new ViewCategoria();

        RepositorioProducto repositorioProducto = new RepositorioProducto();
        RepositorioCategoria repositorioCategoria = new RepositorioCategoria();

        ControllerCategoria controllerCategoria = new ControllerCategoria(repositorioCategoria, viewCategoria);
        ControllerProducto controllerProducto = new ControllerProducto(repositorioCategoria, viewCategoria,
                repositorioProducto, viewProducto, controllerCategoria);

        // ----------------------------------------------------------------------------
        // Registro manual de objetos categoria y productos


        Categoria categoria1 = new Categoria("Deportes Acuaticos");
        Categoria categoria2 = new Categoria("Herramientas");
        Categoria categoria3 = new Categoria("Utilidades de hogar");
        Categoria categoria4 = new Categoria("Software");

        Producto producto1 = new Producto("Tabla de surf (ShortBoard) ", 2000.5F, categoria1);
        Producto producto2 = new Producto("Mantel", 100.2F, categoria3);
        Producto producto3 = new Producto("Traje de Neoprene", 5000F, categoria1);
        Producto producto4 = new Producto("Amoladora", 2000F, categoria2);


        controllerProducto.registrarProducto(producto1);
        controllerProducto.registrarProducto(producto2);
        controllerProducto.registrarProducto(producto3);
        controllerProducto.registrarProducto(producto4);

        controllerCategoria.registrarCategoria(categoria1);
        controllerCategoria.registrarCategoria(categoria2);
        controllerCategoria.registrarCategoria(categoria3);
        controllerCategoria.registrarCategoria(categoria4);

// ---------------------------------------------------------------------------------------
        // -------------------------Menu main ---------------------------------

        Scanner scanner = new Scanner(System.in);
       Integer opcion = -1;
do {
    do {
        System.out.println("\n\n ");
        System.out.println("---------------------------------------------------");
        System.out.println("           MENU PRINCIPAL CRUD PRODUCTO");
        System.out.println("----------------------------------------------------");
        System.out.println("* Elija una opcion :\n ");
        System.out.println("1-Crear producto");
        System.out.println("2-Actualizar producto");
        System.out.println("3-Eliminar producto -");
        System.out.println("4-Mostrar lista de productos");
        System.out.println("5-Crear categoria");
        System.out.println("6-Actualizar categoria");
        System.out.println("7-Eliminar  categoria");
        System.out.println("8-Mostrar lista de  categorias ");
        System.out.println("0-Salir del sistema ");
        opcion = scanner.nextInt();
        if (opcion < 0 || opcion > 8) {
            System.out.println("Opcion incorrecta. Reintente !!!! \n");
        }
    } while (opcion < 0 || opcion > 8);
    switch (opcion){
        case 0:
            ViewGeneral.sleep("Saliendo del sistema ... ", 2000);
            System.exit(0);
            break;
        case 1:
            controllerProducto.crearProducto();
            break;
        case 2:
            controllerProducto.actualizarProducto();
            break;
        case 3:
            controllerProducto.eliminarProducto();
            break;
        case 4:
            controllerProducto.muestraListProductos();
            break;
        case 5:
            controllerCategoria.crearCategoria();
            break;
        case 6:
            controllerCategoria.actualizaCategoria();
            break;
        case 7:
            controllerCategoria.eliminarCategoria();
            break;
        case 8:
            controllerCategoria.muestraListCategoria();
            break;
        default:
            System.out.println("Opcion incorrecta !! Reintente !!! \n ");
            break;
    }
} while (true);

    }
}