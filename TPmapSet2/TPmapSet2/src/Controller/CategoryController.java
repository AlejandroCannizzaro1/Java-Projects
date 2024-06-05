package Controller;

import Interfaces.IController;
import Model.Entities.Categoria;
import Model.Repositories.CategoryRepository;
import View.CategoriaView;

public class CategoryController implements IController {
    private CategoryRepository repositorioCategorias;
    private CategoriaView categoriaView;

    public CategoryController(CategoryRepository repositorioCategorias, CategoriaView viewCategoria) {
        this.repositorioCategorias = repositorioCategorias;
        this.categoriaView = viewCategoria;
    }

    public void crearController() {

        Boolean exito = this.registrarController((Categoria)categoriaView.crearObject());
        if (exito) {
            System.out.println("\nCategoria creada exitosamente\n");
        } else {
            System.out.println("\nLa categoria ya existe en la lista \n");
        }

    }

    public Boolean registrarController(Object object) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("\nRegistrar categoria \n");
        return this.repositorioCategorias.registrar((Categoria)object);
    }

    public void eliminarController() {
        boolean exito;
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("\nEliminar categoria \n");
        Integer id = categoriaView.askForInteger("\nIngrese el id de la categoria que desea eliminar\n");
        Categoria categoria =  this.repositorioCategorias.consultarConForEach(id);
        if (categoria != null) {
            exito = this.repositorioCategorias.eliminar(id);
            if (exito)
                System.out.println("\nSe ha eliminado la categoria exitosamente de la lista \n");
            else
                System.out.println("\nError al  eliminar la categoria !! \n");
        } else {
            System.out.println("\nLa categoria que desea eliminar no existe !! \n");
        }
    }

    public void actualizarController() {
        Integer opcion;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("SubMenu actualizar Categoria ");
        Integer id = categoriaView.askForInteger("Ingrese el id de la categoria " +
                "que desea actualizar");
        Categoria categoriaAUpdatear = (Categoria) this.repositorioCategorias.consultar(id);

        if (categoriaAUpdatear != null) {
            opcion = categoriaView.subMenuactualizarObject();
            this.actualizaCampo (opcion, id, categoriaAUpdatear);
        } else {
            System.out.println("\nLa categoria ingresada no existe !!\n");
        }
    }

    public void actualizaCampo (Integer opcion, Integer id, Categoria categoriaAUpdatear ) {
        if (opcion == 1) {
            String name = categoriaView.askForData("Ingrese el nuevo nombre de la categoria");
            categoriaAUpdatear.setNameCategoria(name);
            boolean exito = this.repositorioCategorias.actualizar(id, categoriaAUpdatear);
            if (exito){
               System.out.println("\nCategoria actualizada con exito \n");
            } else {
               System.out.println("\nLa categoria no ha podido ser actualizada!! \n");
            }
        }
    }

}
