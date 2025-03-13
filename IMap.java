/**
 * Ale Sierra #24405
 * Interfaz que define los metodos que se deben implementar en las subclases Hashmap, trimap y linkedmap
 * tiene los métodos put para insertar, containsKey para verificar si existe, remove para eliminar y get para mostrar u obtener
 */

public interface IMap {
    void put(String key, Pokemon pokemon);
    boolean containsKey(String key);
    void remove(String key);
    Pokemon get(String key);
}

