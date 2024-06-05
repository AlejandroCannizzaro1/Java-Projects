package View;

import Model.Entities.Categoria;
import Model.Entities.Producto;
import Model.Repositories.CategoryRepository;

import java.util.*;

public class CategoriaView {
    private CategoryRepository categoryRepository;

    public CategoriaView(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public Object crearObject (){
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("\nRegistra categoria");
        String name = askForData("Ingrese el nombre de la categoria");
        Categoria categoria = new Categoria(name);
        return categoria;

    }
    public Integer subMenuactualizarObject (){
        Scanner scanner = new Scanner(System.in);
        Integer opcion = -1 ;

        do {
            System.out.println("\n----------------------------------------------------------------");
            System.out.println("Menu actualizar categoria");
            System.out.println("1-Modificar nombre categoria");
            System.out.println("0-Volver atras");
            System.out.println("Elija una opcion");
            opcion = scanner.nextInt();
            if (opcion < 0|| opcion > 1) {
                System.out.println("\nOpcion incorrecta, reingrese !! \n");
            }
        } while (opcion<0 || opcion>1);
        return  opcion;
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
        Float data = scanner.nextFloat();
        return  data;
    }
    public void mostrarColeccionOrdenada (){

        ArrayList <Categoria> listCategorias = new ArrayList <>(this.categoryRepository.getHashSetCategorias());
        if (!listCategorias.isEmpty()){
            System.out.println("---------------------------------------------------------------------");
            System.out.println("\nMuestra lista de categorias ");
            System.out.println("----------------------------------------------------------------------");
       for (Categoria c : listCategorias){
           System.out.println("----------------------------------------------------------------------");
           System.out.println(c.toString());
           System.out.println("-----------------------------------------------------------------------");
        }
    } else {
            System.out.println("\nLa coleccion de categoria no tiene datos !! \n");
    }
    }
    public void mostrarColeccionOrdenadaRecibidaComoArgumento (HashSet<Categoria> hashSetCategoria){
        ArrayList <Categoria> listCategorias = new ArrayList <>(hashSetCategoria);

        if (!listCategorias.isEmpty()){
       for (Categoria c : listCategorias){
           System.out.println("-----------------------------------------------------------------------------");
           System.out.println(c.toString());
           System.out.println("------------------------------------------------------------------------------");
       }
    } else {
            System.out.println("\nLa coleccion no tiene datos !! \n");
    }
    }
}
