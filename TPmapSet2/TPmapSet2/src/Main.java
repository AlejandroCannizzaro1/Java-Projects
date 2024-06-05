import Controller.CarritoDeComprasController;
import Controller.CategoryController;
import Controller.EShop;
import Controller.ProductController;
import Model.Repositories.CarritoDeComprasRepository;
import Model.Repositories.CategoryRepository;
import Model.Repositories.ProductRepository;
import View.CarritoDeComprasView;
import View.CategoriaView;
import View.ProductView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         CategoryRepository categoryRepository = new CategoryRepository();
        ProductRepository productRepository = new ProductRepository();
        CarritoDeComprasRepository carritoDeComprasRepository = new CarritoDeComprasRepository();

        CategoriaView categoriaView = new CategoriaView(categoryRepository);
        ProductView productView = new ProductView(productRepository, categoryRepository,
                categoriaView);
        CarritoDeComprasView carritoDeComprasView = new CarritoDeComprasView(carritoDeComprasRepository);

        CategoryController categoryController = new CategoryController(categoryRepository,
            categoriaView);
        ProductController productController = new ProductController(productView, categoriaView,
            productRepository, categoryRepository, categoryController);
        CarritoDeComprasController carritoDeComprasController = new CarritoDeComprasController(
            productView, categoriaView, productRepository, categoryRepository, carritoDeComprasRepository,
            carritoDeComprasView);

        EShop eShop = new EShop(categoriaView, productView, carritoDeComprasView, categoryController,
                productController, carritoDeComprasController);

        eShop.menuEShop(carritoDeComprasView);

    }
}