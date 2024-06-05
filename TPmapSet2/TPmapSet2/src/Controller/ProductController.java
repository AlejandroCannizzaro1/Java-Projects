package Controller;

import Model.Entities.Categoria;
import Model.Entities.Producto;
import Model.Repositories.CategoryRepository;
import Model.Repositories.ProductRepository;
import View.CategoriaView;
import View.ProductView;

public class ProductController implements Interfaces.IController {

    private ProductView productView;
    private CategoriaView categoriaView;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private CategoryController categoryController;


    public ProductController(ProductView productView, CategoriaView categoriaView,
                             ProductRepository productRepository, CategoryRepository categoryRepository,
                             CategoryController categoryController) {
        this.productView = productView;
        this.categoriaView = categoriaView;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.categoryController = categoryController;
    }

    public void crearController() {

        Integer opcion = -1;
        do {
            opcion = -1;
            if (!this.categoryRepository.getHashSetCategorias().isEmpty()) {
                boolean exito = this.registrarController(productView.crearObject());
                if (exito) {
                    System.out.println("\nProducto creado exitosamente\n");
                } else {
                    System.out.println("\nEl producto ya existe en la lista \n");
                }
            } else {
                System.out.println("\nNo hay categorias cargadas en la lista. Por favor cree una categoria");
                this.categoryController.crearController();
                do {
                    opcion = productView.askForInteger("\n\nDesea continuar con la registracion del producto?" +
                            "\n1-Si\n2-No");
                    if (opcion < 1 || opcion > 2) {
                        System.out.println("\nOpcion incorrecta. Reintente !! \n");
                    }
                } while (opcion < 1 || opcion > 2);
            }
        } while (opcion == 1) ;
    }

    public Boolean registrarController(Object object) {
        return this.productRepository.registrar((Producto) object);
    }

    public void eliminarController() {
        boolean exito;
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("\nEliminar producto \n");
        Integer id = productView.askForInteger("\nIngrese el id el producto que desea eliminar\n");
        Producto producto = (Producto) this.productRepository.consultar(id);
        if (producto != null) {
            exito = this.productRepository.eliminar(id);
            if (exito)
                System.out.println("\nSe ha eliminado el producto de la lista exitosamente \n");
            else
                System.out.println("\nError al  eliminar el producto!! \n");
        } else {
            System.out.println("\nEl producto que desea eliminar no existe !! \n");
        }
    }

    public void actualizarController() {
        Integer opcion;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("SubMenu actualizar Producto ");
        Integer id = productView.askForInteger("Ingrese el id de el producto " +
                "que desea actualizar");
        Producto productoAUpdatear = (Producto) this.productRepository.consultar(id);

        if (productoAUpdatear != null) {
            opcion = productView.subMenuactualizarObject();
            this.actualizaCampo (opcion, id, productoAUpdatear);
        } else {
            System.out.println("\nEl producto ingresado no existe !!\n");
        }
    }

    public void actualizaCampo (Integer opcion, Integer id, Producto productoAUpdatear ) {
        Integer idCategoria;
        boolean exito;
        switch (opcion) {
            case 1:
                System.out.println("\nOpcion 1: Cambiar nombre a producto \n");
                String name = productView.askForData("Ingrese el nuevo nombre de el producto");
                productoAUpdatear.setNameProducto(name);
               break;
            case 2:
                System.out.println("\nOpcion 2: Cambiar precio a producto \n");
                Float precioProducto = productView.askForFloat("Ingrese el nuevo precio del producto");
                productoAUpdatear.setPrecio(precioProducto);
                break;
            case 3:
                boolean existe = false;
                System.out.println("\nOpcion 3: Cambiar categoria a producto \n");
               do {
                   categoriaView.mostrarColeccionOrdenada();
                   idCategoria = categoriaView.askForInteger("Ingrese el id de una" +
                           " de las categorias de la lista de categorias mostrada");
                   Categoria categoria = (Categoria) this.categoryRepository.consultar(idCategoria);
                   if (categoria != null) {
                    existe = true;
                    productoAUpdatear.setCategoria(categoria);
                   } else {
                       System.out.println("\nLa categoria seleccionada no existe." +
                               "Seleccione una con un id valido \n");
                   }
               } while (!existe);
            default:
                System.out.println("Wrong option !! ");
                break;
        }
        exito = this.productRepository.actualizar(id , productoAUpdatear);
        if (exito)
            System.out.println("\nProducto actualizado con exito !! \n");
        else {
            System.out.println("\nNo se ha podido actualizar el producto\n");
        }
        }

}
