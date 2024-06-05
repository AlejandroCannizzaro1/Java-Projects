package Interfaces;

public interface IRepositorio {
    public void actualizar (Integer id, Object objectActualizado);
    public void registrar (Object object);
    public void eliminar  (Integer id);
    public Object consultar  (Integer id);
}
