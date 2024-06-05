package Controller;

import Model.Entitites.Categoria;
import Model.Entitites.Producto;
import Model.Repositories.RepositorioCategoria;
import View.ViewCategoria;

import java.util.List;

public class ControllerCategoria {
    private RepositorioCategoria repositorioCategoria;
    private ViewCategoria viewCategoria;

    public ControllerCategoria(RepositorioCategoria repositorioCategoria, ViewCategoria viewCategoria) {
        this.repositorioCategoria = repositorioCategoria;
        this.viewCategoria = viewCategoria;
    }

    public void muestraListCategoria (){
        List<Categoria> listCategoria = repositorioCategoria.getListCategoria();
        if(!listCategoria.isEmpty()){
            System.out.println("\n---------------- Lista de categorias  ---------------");
            for(Categoria categoria: listCategoria){
                viewCategoria.muestraCategoria(categoria);
            }
        } else {
            System.out.println("La lista esta vacia !! \n");
        }
    }

public void crearCategoria (){
        Categoria categoria = viewCategoria.creaCategoria();
        if(categoria != null){
            registrarCategoria(categoria);
        } else {
            System.out.println(" No se ha creado la categoria con exito !! Reintente !! \n");
        }
}
    public void registrarCategoria (Categoria categoria){
        repositorioCategoria.getListCategoria().add(categoria);
    }
    public void actualizaCategoria (){
       Integer id =  viewCategoria.pideIdCategoriaParaActualizar();
       Categoria categoria =(Categoria) repositorioCategoria.consultar(id);
       if(categoria != null){
           String name = viewCategoria.pideNameCategoriaParaActualizar();
           if (!name.isEmpty()){
               repositorioCategoria.actualizar(id,(Categoria) categoria);
           } else {
               System.out.println("El nombre esta vacio !! Reintente luego ! \n ");
           }
       }
    }
    public void eliminarCategoria (){
        Integer id = viewCategoria.pideIdCategoriaParaEliminar();
        Categoria categoria = (Categoria) repositorioCategoria.consultar(id);
        if(categoria != null){
            repositorioCategoria.eliminar(id);
            System.out.println("Categoria eliminada con exito !! \n ");
        } else {
            System.out.println("La categoria que desea eliminar no existe !! \n ");
        }
    }
}
