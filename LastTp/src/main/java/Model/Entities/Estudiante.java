package Model.Entities;

import java.util.Objects;

public class Estudiante {

    private Integer id;
    private String nombre;
    private String email;

    public Estudiante(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;

    }





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString (){

        return "\nName estudiante: " + getNombre() +
                              "\nId estudiante: " +id + "\nEmail estudiante:" +email ;
    }
    @Override
    public int hashCode (){
        return Objects.hash(this.getId(), this.getNombre());
    }

    @Override
    public boolean equals (Object object){
        if (this == object){
            return  true;
        }
        if (object == null || object.getClass() != this.getClass()){
            return false;
        }
        Estudiante estudiante = (Estudiante) object;

        return Objects.equals(this.getId(), estudiante.getId()) && Objects.equals(
                this.getNombre(), estudiante.getNombre()
        );

    }
}
