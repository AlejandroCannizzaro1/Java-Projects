package Controller;

import Model.Entities.CarritoDeCompras;
import Model.Entities.Categoria;
import Model.Entities.Producto;
import Model.Repositories.CarritoDeComprasRepository;
import Model.Repositories.CategoryRepository;
import Model.Repositories.ProductRepository;
import View.CarritoDeComprasView;
import View.CategoriaView;
import View.ProductView;

import java.sql.SQLOutput;
import java.util.*;

public class CarritoDeComprasController implements Interfaces.IController {
private ProductView productView;
private CategoriaView categoriaView;
private CarritoDeComprasView carritoDeComprasView;
private ProductRepository productRepository;
private CategoryRepository categoryRepository;
private CarritoDeComprasRepository carritoDeComprasRepository;

    public CarritoDeComprasController(ProductView productView, CategoriaView categoriaView,
                                      ProductRepository productRepository, CategoryRepository categoryRepository,
                                      CarritoDeComprasRepository carritoDeComprasRepository,
                                      CarritoDeComprasView carritoDeComprasView) {
        this.productView = productView;
        this.categoriaView = categoriaView;
        this.carritoDeComprasView = carritoDeComprasView;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.carritoDeComprasRepository = carritoDeComprasRepository;
    }

    public void crearController (){
        // Creo carrito de compras
        HashSet<Producto> hashSetProductos = new HashSet<>();
        HashSet<Categoria> hashSetCategorias = new HashSet<>();

        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("Registra carrito de compras");
        // Ingresa titular del carrito, se carga hashSet productos y categorias al objeto carrito
        String nameTitularDelCarrito  = carritoDeComprasView.askForData("\nIngrese el nombre y apellido del titular del carrito \n");
        CarritoDeCompras carritoDeCompras = new CarritoDeCompras (hashSetCategorias , hashSetProductos,
                this.categoriaView, this.productView, nameTitularDelCarrito);
        // Se verifica que la registracion en el Map haya sido correcta
        Boolean existeEnList = this.carritoDeComprasRepository.registrar(carritoDeCompras);
        // Si es correcta, se agrega a la lista, si no, no.
        if (!existeEnList) {
            try {
                System.out.println("\nRegistrando carrito .... Espere ... \n");
                Thread.sleep(2000);
                System.out.println("\nRegistracion exitosa !! ");
            } catch (InterruptedException e) {
                System.out.println("\nError al registrar carrito !! \n");
                e.printStackTrace();
            }
        } else {
            System.out.println("\nEl nombre del titular ya existe, por ende, se sobreescribiran" +
                    "los datos, generando un nuevo carrito con el mismo nombre, \n" +
                    "pero distinto id. El carrito anterior que tenia este nombre sera eliminando.\n");
        }
    }
    public void agregaProductosAlCarrito (){

        String nameTitular = carritoDeComprasView.askForData("\nIngrese el nombre del titular" +
                " del carrito de compras\n");
        CarritoDeCompras carritoDeCompras = (CarritoDeCompras)
                this.carritoDeComprasRepository.consultar(nameTitular);
        if (carritoDeCompras != null) {

            Integer idProducto = -1;
            Integer opcion = -1;
            Boolean exitoCategoria = false;
            Boolean exitoProducto = false;
            Boolean exitoAlAgregarALalista = false;


            if (!this.productRepository.getMapProductos().isEmpty()) {

                System.out.println("\n-------------------------------------------------------------------------");
                System.out.println("Agrega productos al carrito de : " + carritoDeCompras.getTitularDelCarrito());
                System.out.println("--------------------------------------------------------------------------\n");

                do {
                    System.out.println("\nProductos de la lista \n");
                    productView.mostrarColeccionOrdenada();

                    idProducto = carritoDeComprasView.askForInteger("\nIngrese el id del producto que desea " +
                            "agregar a su carrito de compra\n");
                    Producto producto = (Producto) this.productRepository.consultar(idProducto);

                    if (producto != null) {
                        exitoProducto = carritoDeCompras.getHashSetProductosCarrito().add(producto);

                        if (exitoProducto) {

                            System.out.println("\nProducto agregado al carrito \n");
                            exitoCategoria = carritoDeCompras.getHashSetCategoriasCarrito().add(producto.getCategoria());
                            if (exitoCategoria) {
                                System.out.println("\nNueva categoria agregada a la lista de Categorias del carrito  \n");
                            }
                            do {
                                    opcion = carritoDeComprasView.askForInteger("\n\n\n\nDesea agregar otro producto al carrito \n"
                                            + "1-Si" + "\n2-No");
                                    if (opcion < 1 || opcion > 2)
                                        System.out.println("\nError, reintente ! \n");
                                } while (opcion < 1 || opcion > 2);

                        } else {
                            System.out.println("\nEl producto ya existe en su carrito \n");
                            opcion = -1;
                        }

                    } else {
                        System.out.println("El producto no es valido!! ");
                        opcion = -1;
                    }

                } while (opcion == 1);

            } else {
                System.out.println("\nPara gestionar la compra de productos con su carrito, debe volver " +
                        "al menu principal y registrar, al menos, un producto \n");
            }
        } else {
            System.out.println("\nEl carrito de compras no existe !! Debe registrar uno o " +
                    "ingresar el id correcto \n");
        }
    }
    public Boolean registrarController (Object object){
        Boolean exito = this.carritoDeComprasRepository.registrar((CarritoDeCompras) object);
        return  exito;
    }
    public void eliminarController (){}

    public void actualizarController (){}



}
