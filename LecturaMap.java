/**
 * Ale Sierra #24405
 * CLase que lee el archivo csv y carga los datos en un mapa y una lista
 * tiene métodos para mostrar los pokemones ordenados por tipo1, buscar pokemones por habilidad, agregar pokemones y eliminar pokemones
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LecturaMap {
    private Map<String, Pokemon> pokemonMap;
    private List<Pokemon> listaPokemones;

    public LecturaMap(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
        this.listaPokemones = new ArrayList<>();
    }

    public void cargarDatos(String archivoCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                String tipo1 = datos[1];
                String habilidad = datos[2];
                Pokemon pokemon = new Pokemon(nombre, tipo1, habilidad);
                pokemonMap.put(nombre, pokemon);
                listaPokemones.add(pokemon); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarPokemonesPorTipo1() {
        listaPokemones.sort(Comparator.comparing(Pokemon::getTipo1)); 
        for (Pokemon pokemon : listaPokemones) {
            System.out.println(pokemon);
        }
    }

    public void buscarPokemonPorHabilidad(String habilidad) {
        System.out.println("Pokémon con la habilidad " + habilidad + ":");
        for (Pokemon pokemon : listaPokemones) {
            if (pokemon.getHabilidad().equalsIgnoreCase(habilidad)) {
                System.out.println(pokemon);
            }
        }
    }

    public boolean containsKey(String nombre) {
        return pokemonMap.containsKey(nombre);
    }

    public void agregarPokemon(Pokemon pokemon) {
        if (!pokemonMap.containsKey(pokemon.getNombre())) {
            pokemonMap.put(pokemon.getNombre(), pokemon);
            listaPokemones.add(pokemon);
            System.out.println(pokemon.getNombre() + " ha sido agregado.");
        } else {
            System.out.println("El Pokémon " + pokemon.getNombre() + " ya existe en la colección.");
        }
    }

    public void eliminarPokemon(String nombre) {
        if (pokemonMap.containsKey(nombre)) {
            Pokemon pokemon = pokemonMap.remove(nombre);
            listaPokemones.remove(pokemon);
            System.out.println(nombre + " ha sido eliminado.");
        } else {
            System.out.println("El Pokémon " + nombre + " no se encuentra en la colección.");
        }
    }
}
