package Model.Entities;

import View.CategoriaView;
import View.ProductView;

import java.util.*;

public class CarritoDeCompras   {
    private Integer idCarritoCompras;
    private String titularDelCarrito;
    private static Integer nextIdCarritoCompras = 1 ;
    // La idea es mantener una lista de todos las categorias
    // de productos que se agreguen al carrito sin que se repitan
    private HashSet <Categoria> hashSetCategoriasCarrito;
    private HashSet <Producto> hashSetProductosCarrito;
    private CategoriaView categoriaView;
    private ProductView productView;


    public CarritoDeCompras(HashSet<Categoria> hashSetCategoriasCarrito,
                            HashSet<Producto> hashSetProductosCarrito,
                            CategoriaView categoriaView, ProductView productView,
                            String nameTitularDelCarrito) {
        this.hashSetCategoriasCarrito = hashSetCategoriasCarrito;
        this.hashSetProductosCarrito = hashSetProductosCarrito;
        this.categoriaView = categoriaView;
        this.productView = productView;
        this.idCarritoCompras = getNextIdCarritoCompras();
        this.titularDelCarrito = nameTitularDelCarrito;
    }

    public CarritoDeCompras( CategoriaView categoriaView, ProductView productView) {
        this.categoriaView = categoriaView;
        this.productView = productView;
        this.idCarritoCompras = getNextIdCarritoCompras();
    }

    public String getTitularDelCarrito() {
        return titularDelCarrito;
    }

    public void setTitularDelCarrito(String titularDelCarrito) {
        this.titularDelCarrito = titularDelCarrito;
    }

    public Integer getIdCarritoCompras() {
        return idCarritoCompras;
    }

    public void setIdCarritoCompras(Integer idCarritoCompras) {
        this.idCarritoCompras = idCarritoCompras;
    }

    public static Integer getNextIdCarritoCompras() {
        return nextIdCarritoCompras++;
    }

    public static void setNextIdCarritoCompras(Integer nextIdCarritoCompras) {
        CarritoDeCompras.nextIdCarritoCompras = nextIdCarritoCompras;
    }

    public HashSet<Categoria> getHashSetCategoriasCarrito() {
        return hashSetCategoriasCarrito;
    }

    public void setHashSetCategoriasCarrito(HashSet<Categoria> hashSetCategoriasCarrito) {
        this.hashSetCategoriasCarrito = hashSetCategoriasCarrito;
    }

    public HashSet<Producto> getHashSetProductosCarrito() {
        return hashSetProductosCarrito;
    }

    public void setHashSetProductosCarrito(HashSet<Producto> hashSetProductosCarrito) {
        this.hashSetProductosCarrito = hashSetProductosCarrito;
    }

    public CategoriaView getCategoriaView() {
        return categoriaView;
    }

    public void setCategoriaView(CategoriaView categoriaView) {
        this.categoriaView = categoriaView;
    }

    public ProductView getProductView() {
        return productView;
    }

    public void setProductView(ProductView productView) {
        this.productView = productView;
    }

    @Override
    public String toString(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("\nMuestra carrito de compras de el sr. " + titularDelCarrito);
        System.out.println("Id carrito: " + idCarritoCompras);

        ArrayList <Producto> listProductosCarrito = new ArrayList<>
                (this.getHashSetProductosCarrito());
        if (!listProductosCarrito.isEmpty()) {
            Collections.sort(listProductosCarrito);
            for (Producto p : listProductosCarrito) {
                System.out.println(p.toString());
            }
        } else {
            System.out.println("\nLa lista de productos del carrito esta vacia !! ");
        }
        return  null;
    }

    public void  muestraCategoriasDeCarritoDeCompras () {
        Boolean tieneDatos = false;
        ArrayList <Categoria> listCategoria = new ArrayList<>(this.hashSetCategoriasCarrito);

        if (!listCategoria.isEmpty()){
            System.out.println("-------------------------------------------------------------");
            System.out.println("\nMuestra categorias de productos del carrito");
        Collections.sort(listCategoria);
        for (Categoria c : listCategoria) {
            System.out.println("------------------------------------------------------------");
            System.out.println(c.toString());
            System.out.println("------------------------------------------------------------");
        }
            System.out.println("-------------------------------------------------------------");
        } else {
            System.out.println("\nLa lista de categorias de el carrito esta vacia !!  \n");
        }
    }


}
