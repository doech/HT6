import java.util.HashMap;

public class PHashMap implements IMap {
    private HashMap<String, Pokemon> hashMap;

    public PHashMap() {
        this.hashMap = new HashMap<>();
    }

    @Override
    public void put(String key, Pokemon pokemon) {
        hashMap.put(key, pokemon);
    }

    @Override
    public boolean containsKey(String key) {
        return hashMap.containsKey(key);
    }

    @Override
    public void remove(String key) {
        hashMap.remove(key);
    }

    @Override
    public Pokemon get(String key) {
        return hashMap.get(key);
    }
}

