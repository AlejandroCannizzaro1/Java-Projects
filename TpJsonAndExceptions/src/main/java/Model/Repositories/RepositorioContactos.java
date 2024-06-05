package Model.Repositories;

import Model.Entitites.Contacto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedList;

public class RepositorioContactos implements  Interfaces.IRepository {
    private LinkedList <Contacto> listContactos = new LinkedList<>();
    private Gson gson = new Gson();
    private final static String FILE_PATH = "src/main/resources/JsonFile";


    public LinkedList<Contacto> getListContactos() {
        return listContactos;
    }

    public void setListContactos(LinkedList<Contacto> listContactos) {
        this.listContactos = listContactos;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public Object consultar (Integer id){
        for (int i = 0 ;i<listContactos.size();i++){
            if (listContactos.get(i).getId() == id){
                return  listContactos.get(i);
            }
        }
        return  null;
    }
    public boolean eliminar (Integer id){
        boolean exito = true;
        Contacto contacto = (Contacto) consultar(id);
        if (contacto != null){
            exito = listContactos.remove(contacto);
            saveContactos();
            return exito;
        }
        return !exito;
    }
    public boolean registrar (Object object){
        boolean exito = listContactos.add((Contacto)object);
        if (exito == true) {
            this.saveContactos();
        }
        return exito;
    }
    public boolean actualizar (Integer id, Object objectUpdated){
       boolean exito = true;
        Contacto existingContact = (Contacto) consultar(id);
        if (existingContact != null){
            Integer i = this.getSubIndice(id);
            if (i != -1) {
               Contacto verificaExito =  listContactos.set (i, (Contacto)objectUpdated);
                saveContactos();
                if (verificaExito != null){
                    return exito;
                }
            }
        }
        return  !exito;
    }
    public Integer getSubIndice (Integer id){
        Contacto contacto = (Contacto) this.consultar(id);
        for (int i = 0 ;i<listContactos.size();i++){
            if (listContactos.get(i).getId() == id){
                return  i;
            }
        }
        return  -1;
    }

// Deserealizar (From File To Ide)
    public boolean loadClientesFromFile (){
        boolean exito = false;
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<LinkedList<Contacto>>() {}.getType();
            // listType: es una técnica común en Java
            // para manejar la deserialización de tipos
            // genéricos con la librería Gson.
            listContactos = gson.fromJson(reader, listType);
            if (!listContactos.isEmpty()){
               exito = true;
            } else if (listContactos == null){
                listContactos = new LinkedList<>();
                exito = false;
            }

        } catch (FileNotFoundException e){
            listContactos = new LinkedList<>();
        } catch (IOException e){
            // IOException significa que se ha producido un error en la entrada/salida.
            // Por ejemplo, cuando estamos leyendo de la consola, un fichero,
            e.printStackTrace();
        } finally {
            return exito;
        }
        }

        // Serealizar: de Ide to File
        public void saveContactos () {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(listContactos, writer);
        } catch (IOException e){
            e.printStackTrace();
        }
        }

}
