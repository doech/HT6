import java.util.LinkedHashMap;

public class PLinkedHashMap implements IMap {
    private LinkedHashMap<String, Pokemon> linkedHashMap;

    public PLinkedHashMap() {
        this.linkedHashMap = new LinkedHashMap<>();
    }

    @Override
    public void put(String key, Pokemon pokemon) {
        linkedHashMap.put(key, pokemon);
    }

    @Override
    public boolean containsKey(String key) {
        return linkedHashMap.containsKey(key);
    }

    @Override
    public void remove(String key) {
        linkedHashMap.remove(key);
    }

    @Override
    public Pokemon get(String key) {
        return linkedHashMap.get(key);
    }
}
