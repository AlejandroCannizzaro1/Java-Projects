package Controller;

import Model.Repositories.CarritoDeComprasRepository;
import View.CarritoDeComprasView;
import View.CategoriaView;
import View.ProductView;

public class EShop {
    private CategoriaView categoriaView;
    private ProductView productView;
    private CarritoDeComprasView carritoDeComprasView;

    private CategoryController categoryController;
    private ProductController productController;
    private CarritoDeComprasController carritoDeComprasController;

    public EShop(CategoriaView categoriaView, ProductView productView,
                 CarritoDeComprasView carritoDeComprasView,
                 CategoryController categoryController, ProductController productController,
                 CarritoDeComprasController carritoDeComprasController) {
        this.categoriaView = categoriaView;
        this.productView = productView;
        this.carritoDeComprasView = carritoDeComprasView;
        this.categoryController = categoryController;
        this.productController = productController;
        this.carritoDeComprasController = carritoDeComprasController;
    }

    public void menuEShop(CarritoDeComprasView carritoDeComprasView) {
        Integer opcion;

        System.out.println("\n\n----------------------------------------------------------------------");
        System.out.println("Welcome to the Cannizzaro s EShop");
        System.out.println("---------------------------------------------------------------------------");
        do {
            do {
                System.out.println("\n--------------------------------------------------------------------");
                System.out.println(" Menu Principal");
                System.out.println("---------------------------------------------------------------------");
                System.out.println("1-Submenu carrito de compras");
                System.out.println("2-SubMenu productos");
                System.out.println("3-Submenu categorias");
                System.out.println("0-Salir del sistema");
                opcion = carritoDeComprasView.askForInteger("\nElija una opcion");
                if (opcion < 0 || opcion > 3)
                    System.out.println("\nError, reintente !! \n");
            } while (opcion < 0 || opcion > 3);

            switch (opcion) {
                case 0:
                    System.out.println("\nSaliendo del sistema !!! \n");
                    System.exit(0);
                    break;
                case 1:
                    this.subMenuCarritosDeCompras();
                    break;
                case 2:
                    this.subMenuProductos();
                    break;
                case 3:
                    this.subMenuCategorias();
                    break;
                default:
                    System.out.println("\nWrong option !!! \n");
                    break;
            }
        } while (true);
    }

    public void subMenuProductos() {
        Integer opcion;
        do {
            do {
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("\nSubMenu Productos\n");
                System.out.println("1-Registrar producto");
                System.out.println("2-Eliminar producto");
                System.out.println("3-Actualizar producto");
                System.out.println("4-Mostrar lista de  productos");
                System.out.println("0-Volver al menu principal");
                opcion = carritoDeComprasView.askForInteger("\nElija una opcion");
                if (opcion < 0 || opcion > 4)
                    System.out.println("\nOpcion incorrecta, reintente !! \n");
            } while (opcion < 0 || opcion > 4);

            switch (opcion) {
                case 0:
                    break;
                case 1:
                    this.productController.crearController();
                    break;
                case 2:
                    this.productController.eliminarController();
                    break;
                case 3:
                    this.productController.actualizarController();
                    break;
                case 4:
                    this.productView.mostrarColeccionOrdenada();
                    break;
                default:
                    System.out.println("\nWrong option !! \n");
                    break;
            }
        } while (opcion != 0);
    }

    public void subMenuCategorias() {
        Integer opcion;
        do {
            do {
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("\nSubMenu Categorias\n");
                System.out.println("1-Registrar categoria de producto");
                System.out.println("2-Eliminar Categoria de producto");
                System.out.println("3-Actualizar categoria de producto");
                System.out.println("4-Mostrar lista de  categorias de productos");
                System.out.println("0-Volver al menu principal");
                opcion = carritoDeComprasView.askForInteger("\nElija una opcion");
                if (opcion < 0 || opcion > 4)
                    System.out.println("\nOpcion incorrecta, reintente !! \n");
            } while (opcion < 0 || opcion > 4);

            switch (opcion) {
                case 0:
                    break;
                case 1:
                    this.categoryController.crearController();
                    break;
                case 2:
                    this.categoryController.eliminarController();
                    break;
                case 3:
                    this.categoryController.actualizarController();
                    break;
                case 4:
                    this.categoriaView.mostrarColeccionOrdenada();
                    break;
                default:
                    System.out.println("\nWrong option !! \n");
                    break;
            }
        } while (opcion != 0);
    }

    public void subMenuCarritosDeCompras() {
        Integer opcion;
        do {
            do {
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("\nSubMenu Carrito de Compras\n");
                System.out.println("1-Registrar carrito de compras");
                System.out.println("2-Agregar productos a  carrito de compras");
                System.out.println("3-Mostrar lista de productos de un carrito de compras especifico");
                System.out.println("4-Mostrar categorias de productos de un carrito de compras especifico");
                System.out.println("5-Mostrar lista de carritos de compras");
                System.out.println("0-Volver al menu principal");
                opcion = carritoDeComprasView.askForInteger("\nElija una opcion");
                if (opcion < 0 || opcion > 5)
                    System.out.println("\nOpcion incorrecta, reintente !! \n");
            } while (opcion < 0 || opcion > 5);

            switch (opcion) {
                case 0:
                    break;
                case 1:
                    this.carritoDeComprasController.crearController();
                    break;
                case 2:
                    this.carritoDeComprasController.agregaProductosAlCarrito();
                    break;
                case 3:
                    this.carritoDeComprasView.mostrarProductosCarrito();
                    break;
                case 4:
                    this.carritoDeComprasView.muestraCategoriasCarrito();
                    break;
                case 5:
                    this.carritoDeComprasView.mostrarColeccion();
                    break;
                default:
                    System.out.println("\nWrong option !! \n");
                    break;
            }
        } while (opcion != 0);
    }
}