package Model.Entities;

public class Persona {
    private String name;
    private String lastName;
    private Integer id;
    private Integer nextId = 1 ;

    public Persona(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.id = getNextId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNextId() {
        return nextId++;
    }

    public void setNextId(Integer nextId) {
        this.nextId = nextId;
    }

    @Override
    public String toString (){

        return "Nombre: " + this.name+ "\nApellido: " + this.lastName + "\nId: " + this.id;
    }
}
