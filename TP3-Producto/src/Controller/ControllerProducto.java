package Controller;

import Model.Entitites.Categoria;
import Model.Entitites.Producto;
import Model.Repositories.RepositorioCategoria;
import Model.Repositories.RepositorioProducto;
import View.ViewCategoria;
import View.ViewGeneral;
import View.ViewProducto;

import java.util.List;
import java.util.Scanner;

public class ControllerProducto {
    private RepositorioCategoria repositorioCategoria;
    private ViewCategoria viewCategoria;
    private RepositorioProducto repositorioProducto;
    private ViewProducto viewProducto;
    private ControllerCategoria controllerCategoria;

    public ControllerProducto(RepositorioCategoria repositorioCategoria, ViewCategoria viewCategoria,
                              RepositorioProducto repositorioProducto, ViewProducto viewProducto,
                              ControllerCategoria controllerCategoria) {
        this.repositorioCategoria = repositorioCategoria;
        this.viewCategoria = viewCategoria;
        this.repositorioProducto = repositorioProducto;
        this.viewProducto = viewProducto;
        this.controllerCategoria = controllerCategoria;
    }

    public void  crearProducto (){
        Producto producto = viewProducto.crearProducto();
        if(producto != null){
            System.out.println("\nAtencion !! Seccion de producto cargada con exito! Rellene los campos de la categoria" +
                    " del producto que se le pediran a continuacion \n ");
            Categoria categoria = viewCategoria.creaCategoria();
            if(categoria != null ){
                producto.setCategoria(categoria);
                repositorioCategoria.registrar((Categoria)categoria);
                ViewGeneral.sleep("Categoria registrada en list, loading ... ", 2000);
                registrarProducto(producto);
                ViewGeneral.sleep("Producto registrado en list, aguarde ... ", 2000);
            } else {
                System.out.println("No se ha podido cargar la seccion de categoria " +
                        "de el producto  con exito !! ");
            }
        } else {
            System.out.println("No se ha podido la seccion de el producto con exito.");
        }
    }
    public void registrarProducto (Producto producto){
        repositorioProducto.getListProducto().add(producto);
    }
    public void eliminarProducto (){
Integer id = viewProducto.pideIdProductoParaEliminar();
Producto producto = (Producto) repositorioProducto.consultar(id);

if(producto != null){
    System.out.println("Muestra producto a eliminar \n");
    viewProducto.muestraProducto(producto);
    repositorioProducto.eliminar(id);
    ViewGeneral.sleep("Eliminando.... Espere.... ", 2000);
    System.out.println("Producto eliminado !!! ");
} else {
    System.out.println("El producto que desea eliminar no existe !! \n");
}
    }
    public void muestraListProductos (){
        List<Producto> listProducto = repositorioProducto.getListProducto();

        if(!listProducto.isEmpty()){
            System.out.println("\n---------------- Lista de productos ---------------");
            for(Producto producto: listProducto){
                viewProducto.muestraProducto(producto);
            }
        } else {
            System.out.println("La lista esta vacia !! \n");
        }
    }
    public void actualizarProducto (){

        Integer idCategoria = -1 ;
        Scanner scanner = new Scanner(System.in);
        Integer opcion = 0;

        Integer id = viewProducto.pideIdProductoParaActualizar();
        Producto producto = (Producto) repositorioProducto.consultar(id);

        if(producto != null){
            System.out.println("Id de producto valido !! \n ");
            opcion = viewProducto.muestraCamposProductoParaActualizar();
            switch (opcion){
                case 1:
                    String name = viewProducto.pideNombreProductoParaActualizar();
                    repositorioProducto.actualizar(id, producto);
                    System.out.println("Cambios realizados !!! \n");
                    break;
                case 2:
                    Float costo = viewProducto.pideCostoProductoParaActualizar();
                    repositorioProducto.actualizar(id, producto);
                    System.out.println("Cambios realizados !!! \n");
                    break;
                case 3:
             Categoria categoria = muestraNamesCategoriaEligeUnaYLaRetorna();
             if(categoria != null) {
                 producto.setCategoria(categoria);
             } else {
                 System.out.println("La categoria no se ha cargado con exito !! Reintente !! ");
             }
             break;
                default:
                    System.out.println("Wrong option !! Retry !! \n ");
                    break;
            }
        } else {
            System.out.println("El producto no existe !! \n ");
        }
    }

    public Categoria muestraNamesCategoriaEligeUnaYLaRetorna (){
        Integer idCategoria = -1;
        Scanner scanner = new Scanner(System.in);

        if (!repositorioCategoria.getListCategoria().isEmpty()) {
            do {
                this.controllerCategoria.muestraListCategoria();
                System.out.println("Ingrese el id de alguna de las siguientes  categorias" +
                        " para  quiere asignarla a su producto");
                idCategoria = scanner.nextInt();
                if (idCategoria < 1 || idCategoria >repositorioCategoria.getListCategoria().size()) {
                    System.out.println("Opcion incorrecta. Reintenete !! \n");
                }
            } while (idCategoria < 1 || idCategoria >repositorioCategoria.getListCategoria().size());

            Categoria categoria =(Categoria) repositorioCategoria.consultar(idCategoria);
            if(categoria != null){
                System.out.println("Muestra la categoria elegida: \n ");
                System.out.println("-------------------------------------");
                viewCategoria.muestraCategoria(categoria);
                System.out.println("Cambios realizados !!! ");
                return categoria;
            } else {
                System.out.println("El id de esa categoria no existe!! ");
                return null;
            }
        } else {
            System.out.println("No hay categorias para elegir !! ");
            System.out.println("Vuelva a menu principal y agregue una o varias !!\n ");
            return null;
        }
    }
}
