import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de mapa (HashMap, TreeMap, LinkedMap): ");
        String tipoMapa = scanner.nextLine();
        Map<String, Pokemon> mapaPokemon = MapFactory.getMap(tipoMapa); 

        LecturaMap lecturaMap = new LecturaMap(mapaPokemon);
        String archivoCSV = "pokemons.csv";
        lecturaMap.cargarDatos(archivoCSV);

        boolean salir = false;
        while (!salir) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar Pokémon");
            System.out.println("2. Eliminar Pokémon");
            System.out.println("3. Verificar si un Pokémon existe");
            System.out.println("4. Mostrar Pokémon ordenados por Tipo1");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:  
                    System.out.println("Ingrese el nombre del Pokémon:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el tipo1 del Pokémon:");
                    String tipo1 = scanner.nextLine();
                    System.out.println("Ingrese la habilidad del Pokémon:");
                    String habilidad = scanner.nextLine();
                    Pokemon nuevoPokemon = new Pokemon(nombre, tipo1, habilidad);
                    mapaPokemon.put(nombre, nuevoPokemon);
                    break;

                case 2:  
                    System.out.println("Ingrese el nombre del Pokémon a eliminar:");
                    String nombreEliminar = scanner.nextLine();
                    mapaPokemon.remove(nombreEliminar);
                    break;

                case 3:  
                    System.out.println("Ingrese el nombre del Pokémon a verificar:");
                    String nombreVerificar = scanner.nextLine();
                    if (mapaPokemon.containsKey(nombreVerificar)) {
                        System.out.println(nombreVerificar + " existe en la colección.");
                    } else {
                        System.out.println(nombreVerificar + " no está en la colección.");
                    }
                    break;

                case 4:  
                    lecturaMap.mostrarPokemonesPorTipo1();
                    break;

                case 5: 
                    System.out.println("Ingrese la habilidad del Pokémon:");
                    String habilidadBuscar = scanner.nextLine();
                    lecturaMap.buscarPokemonPorHabilidad(habilidadBuscar);
                    break;

                case 6: 
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}

