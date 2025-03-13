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
                throw new IllegalArgumentException("Tipo de mapa no soportado: " + tipoMapa);
        }
    }
}
