package Model.Entities;

public class Usuario extends Persona {
    private String tipoDeUsuario;

    public Usuario(String name, String lastName, String tipoDeUsuario) {
        super(name, lastName);
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    @Override
    public String toString (){
        System.out.println(super.toString());
        // en el return puedo poner el toString solo, pero si es afuera del return debe ir con un print
        return "Tipo de usuario: " + tipoDeUsuario;
    }
}
