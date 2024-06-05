package Model.Entities;

import java.util.Objects;

public class Categoria implements Comparable <Categoria> {
    private String nameCategoria;
    private Integer idCategoria;
    private static  Integer nextIdCategoria = 1 ;

    public Categoria(String nameCategoria) {
        this.nameCategoria = nameCategoria;
        this.idCategoria = getNextIdCategoria();
    }
    public Categoria(String nameCategoria, Integer id) {
        this.nameCategoria = nameCategoria;
        this.idCategoria = id;
    }


    public String getNameCategoria() {
        return nameCategoria;
    }

    public void setNameCategoria(String nameCategoria) {
        this.nameCategoria = nameCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public static Integer getNextIdCategoria() {
        return nextIdCategoria++;
    }

    public static void setNextIdCategoria(Integer nextIdCategoria) {
        Categoria.nextIdCategoria = nextIdCategoria;
    }

    @Override
    public boolean equals (Object object){
        if (this == object)
            return true;

        if ( object == null || this.getClass() != object.getClass() ) {
            return false;
        }

        Categoria categoria = (Categoria) object;
        // Finalmente, esta línea compara los atributos relevantes de
        // los objetos this y user para determinar si son iguales
        return Objects.equals(this.getNameCategoria(), categoria.getNameCategoria());

    }

    // Agus, este metodo lo hice de manija, para curiosear,  no es necesario para el TP
    // Metodo hashCode que genera un valor de dispersion o hash, en base al id del objeto
    @Override
    public int hashCode (){
        return Objects.hashCode(this.nameCategoria);
    }

    @Override
    public int compareTo (Categoria categoria){
        int comparacionNameCategoria = this.nameCategoria.compareTo(categoria.getNameCategoria());
        if (comparacionNameCategoria != 0 ){
            return comparacionNameCategoria;
        } else {
            return this.idCategoria.compareTo(categoria.getIdCategoria());
        }
    }

    @Override
    public String toString (){
        return "\nCategoria de producto: "
                + nameCategoria + "\nId categoria : " +idCategoria;

    }
}
