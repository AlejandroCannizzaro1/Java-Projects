package View;

import Model.Entitites.Categoria;
import Model.Entitites.Producto;

import java.util.Scanner;

public class ViewCategoria {

    public void muestraCategoria  (Categoria categoria){
        System.out.println("--------------------------------------------------");
        System.out.println("Nombre categoria: "+categoria.getName());
        System.out.println("Id categoria : "+categoria.getId());
        System.out.println("------------------------------------------------- ");
    }
public Categoria creaCategoria (){
        Scanner scanner = new Scanner(System.in);
        String dato = " ";
        System.out.println("Ingrese el nombre de la  categoria que le asignara a su producto  ");
        dato = scanner.nextLine();
        Categoria categoria = new Categoria(dato);
        return categoria;
}
    public Integer pideIdCategoriaParaActualizar (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id de la categoria para actualizar");
        Integer id = scanner.nextInt();
        return id;
    }

    public Integer pideIdCategoriaParaEliminar (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id de la categoria para eliminar");
        Integer id = scanner.nextInt();
        return id;
    }


    public String  pideNameCategoriaParaActualizar (){
        System.out.println("Actualiza categoria  ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;

    }
}
