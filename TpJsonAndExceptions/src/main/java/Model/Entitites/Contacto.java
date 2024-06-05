package Model.Entitites;

public class Contacto implements Comparable <Contacto> {
    private String nombre;
    private String telefono;
    private String email;
    private Integer id;
    private static Integer nextId = 1;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.id = getNextId();
    }
    public Contacto (){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getNextId() {
        return nextId++;
    }

    public static void setNextId(Integer nextId) {
        Contacto.nextId = nextId;
    }

    @Override
    public int compareTo (Contacto contacto){
        int comparacion = this.getNombre().compareTo(contacto.getNombre());
        if (comparacion != 0){
            return comparacion;
        } else {
            return this.getTelefono().compareTo(contacto.getTelefono());
        }
    }

    @Override
    public String toString (){
        System.out.println("------------------------------------------------------------------------");
        return " \nName contacto: " + nombre + "\nTelefono: " + telefono + "\nEmail: " + email +
                "\nId: " + id +
                           "\n-------------------------------------------------------------------------";
    }


}
