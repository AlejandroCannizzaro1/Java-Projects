package Interfaces;

public interface IRepositorio {

    void actualizar (Integer id, Object objectUpdated);
    Object consultar (Integer id);
    void registar (Object object);
    void eliminar (Integer id);
    Integer getSubIndice (Integer id);

}
