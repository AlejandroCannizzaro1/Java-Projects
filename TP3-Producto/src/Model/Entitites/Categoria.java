package Model.Entitites;

public class Categoria {
    private String name;
    private Integer id;
    private static Integer nextId = 1 ;

    public Categoria(String name) {
        this.name = name;
        this.id = getNextId();
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public static Integer getNextId() {
        return nextId++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static void setNextId(Integer nextId) {
        Categoria.nextId = nextId;
    }
}
