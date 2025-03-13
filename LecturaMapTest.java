import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;

public class LecturaMapTest {
    
    private LecturaMap lecturaMap;
    private Map<String, Pokemon> map;
    private final String tempCsv = "temp_pokemons.csv";

    @Before
    public void setUp() throws IOException {
        map = new HashMap<>();
        lecturaMap = new LecturaMap(map);
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempCsv));
        writer.write("Pikachu,Eléctrico,Static\n");
        writer.write("Charmander,Fuego,Blaze\n");
        writer.write("Squirtle,Agua,Torrent\n");
        writer.close();
    }
    
    @After
    public void tearDown() {
        File file = new File(tempCsv);
        if(file.exists()){
            file.delete();
        }
    }
    
    @Test
    public void testCargarDatos() {
        lecturaMap.cargarDatos(tempCsv);
        assertTrue(map.containsKey("Pikachu"));
        assertTrue(map.containsKey("Charmander"));
        assertTrue(map.containsKey("Squirtle"));
        assertEquals(3, map.size());
    }
    
    @Test
    public void testAgregarPokemon() {
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Grass", "Overgrow");
        lecturaMap.agregarPokemon(bulbasaur);
        assertTrue(map.containsKey("Bulbasaur"));
        lecturaMap.agregarPokemon(bulbasaur);
        assertEquals(1, map.size());
    }
    
    @Test
    public void testEliminarPokemon() {
        Pokemon pikachu = new Pokemon("Pikachu", "Electric", "Static");
        lecturaMap.agregarPokemon(pikachu);
        assertTrue(map.containsKey("Pikachu"));
        lecturaMap.eliminarPokemon("Pikachu");
        assertFalse(map.containsKey("Pikachu"));
    }
    
    @Test
    public void testContainsKey() {
        Pokemon charmander = new Pokemon("Charmander", "Fire", "Blaze");
        lecturaMap.agregarPokemon(charmander);
        assertTrue(lecturaMap.containsKey("Charmander"));
        assertFalse(lecturaMap.containsKey("Squirtle"));  
    }
    
    @Test
    public void testMostrarPokemonesPorTipo1Order() {
        Pokemon p1 = new Pokemon("Pikachu", "Eléctrico", "Static");
        Pokemon p2 = new Pokemon("Charmander", "Fuego", "Blaze");
        Pokemon p3 = new Pokemon("Squirtle", "Agua", "Torrent");
        lecturaMap.agregarPokemon(p1);
        lecturaMap.agregarPokemon(p2);
        lecturaMap.agregarPokemon(p3);
        lecturaMap.mostrarPokemonesPorTipo1();
        List<Pokemon> listaOrdenada = new ArrayList<>(map.values());
        listaOrdenada.sort(Comparator.comparing(Pokemon::getTipo1));
    
        assertEquals("Agua", listaOrdenada.get(0).getTipo1());
        assertEquals("Eléctrico", listaOrdenada.get(1).getTipo1());
        assertEquals("Fuego", listaOrdenada.get(2).getTipo1());
    }
}
