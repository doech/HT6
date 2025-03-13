/**
 * Ale Sierra #24405
 * Clase que crea un mapa dependiendo del tipo de mapa que se le pase
 * tiene un método getMap que recibe un string y devuelve un mapa
 */


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {
    public static Map<String, Pokemon> getMap(String tipoMapa) {
        switch (tipoMapa) {
            case "HashMap":
                return new HashMap<>();
            case "TreeMap":
                return new TreeMap<>();
            case "LinkedMap":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Este tipo de mapa no se encuentra entre las opciones");
        }
    }
}
