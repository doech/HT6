/**
 * Ale Sierra #24405
 * Clase que almacena los datos principales del pokemon
 */
public class Pokemon {
    private String nombre;
    private String tipo1; //solo el tipo porque es el tipo principal
    private String habilidad;

    public Pokemon(String nombre, String tipo1, String habilidad) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.habilidad = habilidad;
    }
    public String getNombre() {
        return nombre;
    }

    public String getTipo1() {
        return tipo1;
    }

    public String getHabilidad() {
        return habilidad;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo1 + ", Habilidad: " + habilidad + ")";
    }
}

