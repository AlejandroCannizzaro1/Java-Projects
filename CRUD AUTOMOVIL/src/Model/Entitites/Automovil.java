package Model.Entitites;

import Interfaces.IRepositorio;

public class Automovil  extends  Vehiculo{
    private Integer ruedas;
    private boolean cierreCentralizado;

    public Automovil(String marca, String motor, Integer  ruedas, String modelo,
                      boolean cierreCentralizado) {
        super(marca, motor, modelo);
        this.ruedas = ruedas;
        this.cierreCentralizado = cierreCentralizado;
    }

    public Integer  getRuedas() {
        return ruedas;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }

    public boolean isCierreCentralizado() {
        return cierreCentralizado;
    }

    public void setCierreCentralizado(boolean cierreCentralizado) {
        this.cierreCentralizado = cierreCentralizado;
    }
    public void actualizar (Integer id, Object object){

    }

}
