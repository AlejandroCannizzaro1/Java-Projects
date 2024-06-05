package View;

import Interfaces.IView;
import Model.Entities.Categoria;
import Model.Entities.Producto;
import Model.Repositories.CategoryRepository;
import Model.Repositories.ProductRepository;

import java.util.*;

public class ProductView implements IView {
    private ProductRepository repositorioProductos;
    private CategoryRepository categoryRepository;
    private CategoriaView categoriaView;

    public ProductView(ProductRepository repositorioProductos, CategoryRepository categoryRepository,
                       CategoriaView categoriaView) {
        this.repositorioProductos = repositorioProductos;
        this.categoryRepository = categoryRepository;
        this.categoriaView = categoriaView;
    }

    public Object crearObject (){
        Integer opcion = -1;
        Integer idCategoria = -1;
        boolean sigueIntentando = true;

        System.out.println("Registra producto");
        String name = askForData("Ingrese el nombre del producto");
        Float precio = askForFloat("Ingrese el precio del producto");
        Producto producto = new Producto(name, precio);

        if (!this.categoryRepository.getHashSetCategorias().isEmpty()) {
          do {
              opcion = this.askForInteger("\nElija una opcion:\n" +
                      "1-Asignar categoria existente\n2-Crear categoria y asignarla a producto");
              if (opcion < 1 || opcion > 2) {
                  System.out.println("\nOpcion incorrecta.Reintente!! \n");
              }
          } while (opcion<1 || opcion>2);
          switch (opcion){
              case 1:
                  do {
                      System.out.println("\nMuestra lista de categorias existenes: ");
                      this.categoriaView.mostrarColeccionOrdenadaRecibidaComoArgumento(this.categoryRepository.getHashSetCategorias());
                      idCategoria = askForInteger("\nIngrese el id de la categoria existente\n");
                      Categoria categoria = (Categoria) this.categoryRepository.consultar(idCategoria);
                      if (categoria != null) {

                          producto.setCategoria(categoria);
                          System.out.println("\nCategoria valida!! Se ha asignado la misma al producto creado !!  ");
                          sigueIntentando = false;
                      } else {
                          System.out.println("\nOpcion incorrecta.Reintente!! ");
                      }
                  } while (sigueIntentando);
                  break;
              case 2:
                  String nameCategoria = askForData("\nIngrese el nombre de la nueva categoria\n");
                  Categoria categoria = new Categoria(nameCategoria);
                  Boolean noExiste = this.categoryRepository.registrar(categoria);
                  producto.setCategoria(categoria);
                  if (noExiste){
                      System.out.println("\nCategoria asignada exitosamente al producto y agregada a la lista de" +
                              "categorias\n");
                  } else {
                      System.out.println("\nLa categoria ya existia en la lista de categorias.Aun asi fue agregada " +
                              "a la categoria del producto\n");
                  }
                  break;
                 }
        } else {
            System.out.println("\nNo hay categorias cargadas en la lista !! ");
            return null;
        }
        return  producto;
    }
    public Integer subMenuactualizarObject (){
        Scanner scanner = new Scanner(System.in);
        Integer opcion = -1 ;

        do {
            System.out.println("\n----------------------------------------------------------------");
            System.out.println("Menu actualizar producto");
            System.out.println("1-Modificar nombre producto");
            System.out.println("2-Modificar precio producto");
            System.out.println("3-Modificar categoria producto");
            System.out.println("0-Volver atras");
            System.out.println("Elija una opcion");
            opcion = scanner.nextInt();
            if (opcion < 0|| opcion > 3) {
                System.out.println("\nOpcion incorrecta, reingrese !! \n");
            }
        } while (opcion<0 || opcion>3);
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
    public void  mostrarColeccion () {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("\n\nMuestra coleccion  de productos desordenada ");
        if (!this.repositorioProductos.getMapProductos().isEmpty()){
            for (Map.Entry<Integer, Producto> entry : this.repositorioProductos.getMapProductos().entrySet()) {
                Integer key = entry.getKey(); // No lo uso, pero lo hago para saber las
                //funcionalidades de entry, el cual, contiene clave y objetos referido a la clave
                Producto producto = entry.getValue();
                System.out.println(producto.toString());
            }

    } else {
            System.out.println("\nLa coleccion de productos no tiene datos !! \n");
        }
    }
    public void mostrarColeccionOrdenada (){

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Muestra coleccion de productos ");
        List<Producto> listProductos =  new ArrayList<>(this.repositorioProductos.getMapProductos().values());
        if (!listProductos.isEmpty()) {
            Collections.sort(listProductos);
            Iterator<Producto> iterator = listProductos.iterator();
            while (iterator.hasNext()) {
                Producto p = iterator.next();
                System.out.println(p.toString());
            }
        } else {
            System.out.println("\nLa coleccion de productos no tiene datos !! \n");
        }
    }
    public void  mostrarColeccion2 () {

        if (!this.repositorioProductos.getMapProductos().isEmpty()) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Muestra coleccion de productos");
            for (Integer key : this.repositorioProductos.getMapProductos().keySet()) {
                Producto producto = this.repositorioProductos.getMapProductos().get(key);
                System.out.println(producto.toString());
            }

        } else {
            System.out.println("\nLa coleccion de productos no tiene datos !! \n");
        }
    }
    public void mostrarColeccionDeTipoHashSetDeProductosRecibidaComoArgumento
            (HashSet<Producto> hashSetProductos){

        if (!hashSetProductos.isEmpty()) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Muestra coleccion de productos");
            List<Producto> listProductos = new ArrayList<>(hashSetProductos);
            Collections.sort(listProductos);
            for (Producto p : listProductos) {
                System.out.println(p.toString());
            }

        } else  {
            System.out.println("\nLa coleccion de productos  no tiene datos !! \n");
       }
    }



}
