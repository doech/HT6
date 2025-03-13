/**
 * Ale Sierra #24405
 * Clase que implementa la interfaz IMap y utiliza un TreeMap para almacenar los pokemones
 */
import java.util.TreeMap;

public class PTriMap implements IMap {
    private TreeMap<String, Pokemon> treeMap;

    public PTriMap() {
        this.treeMap = new TreeMap<>();
    }

    @Override
    public void put(String key, Pokemon pokemon) {
        treeMap.put(key, pokemon);
    }

    @Override
    public boolean containsKey(String key) {
        return treeMap.containsKey(key);
    }

    @Override
    public void remove(String key) {
        treeMap.remove(key);
    }

    @Override
    public Pokemon get(String key) {
        return treeMap.get(key);
    }
}

