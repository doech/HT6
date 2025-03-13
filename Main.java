/**
 * Ale Sierra #24405
 * Clase principal que muestra al usuario las opciones y llama a los metodos
 * muestra tiempo de ejecución de cada método
 */


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
            System.out.println("1. Agregar Pokemon");
            System.out.println("2. Eliminar Pokemon");
            System.out.println("3. Buscar Pokemon");
            System.out.println("4. Mostrar Pokemon ordenados por Tipo1");
            System.out.println("5. Buscar Pokemon por habilidad");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  

            long startTime = System.nanoTime();
            long endTime = System.nanoTime();

            switch (opcion) {
                case 1:  
                    System.out.println("Ingrese el nombre del Pokemon:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el tipo1 del Pokemon:");
                    String tipo1 = scanner.nextLine();
                    System.out.println("Ingrese la habilidad del Pokemon:");
                    String habilidad = scanner.nextLine();
                    Pokemon nuevoPokemon = new Pokemon(nombre, tipo1, habilidad);
                    mapaPokemon.put(nombre, nuevoPokemon);
                    System.out.println("Pokemon agregado.");
                    System.out.println("Tiempo para insertar: " + (endTime - startTime) + " nanosegundos");
                    break;

                case 2:  
                    System.out.println("Ingrese el nombre del Pokemon a eliminar:");
                    String nombreEliminar = scanner.nextLine();
                    mapaPokemon.remove(nombreEliminar);
                    System.out.println("Pokemon eliminado");
                    System.out.println("Tiempo para eliminar: " + (endTime - startTime) + " nanosegundos");
                    break;

                case 3:  
                  System.out.println("Ingrese el nombre del Pokemon:");
                    String nombreVerificar = scanner.nextLine();
                    if (mapaPokemon.containsKey(nombreVerificar)) {
                        System.out.println(nombreVerificar + " existe");
                        System.out.println( mapaPokemon.get(nombreVerificar));
                    } else {
                        System.out.println(nombreVerificar + " no está");
                    }
                    System.out.println("Tiempo para verificar: " + (endTime - startTime) + " nanosegundos");
                    break;

                case 4:  
                    lecturaMap.mostrarPokemonesPorTipo1();
                    System.out.println("Tiempo para ordenar y mostrar: " + (endTime - startTime) + " nanosegundos");
                    break;

                case 5: 
                    System.out.println("Ingrese la habilidad del Pokemon:");
                    String habilidadBuscar = scanner.nextLine();
                    lecturaMap.buscarPokemonPorHabilidad(habilidadBuscar);
                    System.out.println("Tiempo para buscar por habilidad: " + (endTime - startTime) + " nanosegundos");
                    break;

                case 6: 
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}

