package Interfaces;

public interface IRepositoryMap <K,V>{
    // C.E.R.A.S.

    public V consultar (K key);
    public boolean eliminar (K key);
    public void registrar (V value);

}
