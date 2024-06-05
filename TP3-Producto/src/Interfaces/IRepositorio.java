package Interfaces;

public interface IRepositorio {
  void registrar (Object object);
   Object consultar (Integer id);
  void actualizar (Integer id, Object object);
   void eliminar (Integer id);
}
