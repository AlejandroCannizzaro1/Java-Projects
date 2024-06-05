package Model.Entitites;

import Interfaces.IRepositorio;

public abstract class Vehiculo  {
    // Recordar que las clases abstractas no se pueden instanciar
    private String marca;
    private String motor;
    private String modelo;
    private Integer id;
    private static Integer nextId=1;

    public Vehiculo(String marca, String motor, String modelo) {
        this.marca = marca;
        this.motor = motor;
        this.modelo = modelo;
        this.id = getNextId();
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
        Vehiculo.nextId = nextId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


}
