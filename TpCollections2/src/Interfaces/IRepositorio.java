package Interfaces;

public interface IRepositorio {
    // C.E.R.A.S.
    public Object consultar (String vueloAlfanumerico);
    public void eliminar (String vueloAlfanumerico);
    public void registrar (Object object);
    public void actualizar (String vueloAlfanumerico, Object objectUpdated);
    public Integer getSubIndice (String vueloAlfanumerico);

}
