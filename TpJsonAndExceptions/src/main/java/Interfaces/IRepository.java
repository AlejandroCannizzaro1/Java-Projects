package Interfaces;

public interface IRepository {
    // C.E.R.A.S.

    public Object consultar (Integer id);
    public boolean eliminar (Integer id);
    public boolean registrar (Object object);
    public boolean actualizar (Integer id, Object objectUpdated);
    public Integer getSubIndice (Integer id);
}
