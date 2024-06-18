package Interfaces;

public interface IRepository <T>{
    public void consultar (Integer id);
    public void eliminar (Integer id);
    public void registrar (T object);
    public void actualizar (Integer id, T objectUpdated);
}
