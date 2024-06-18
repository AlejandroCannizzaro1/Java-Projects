package Interfaces;

public interface IRepositoryString <T>{
    public void consultar (String codigo);
    public void eliminar (String codigo);
    public void registrar (T object);
    public void actualizar (String codigo , T objectUpdated);
}
