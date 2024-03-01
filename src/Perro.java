// Ejemplo de POO en Java
public class Perro {

    String nombre;
    int edad;

    public Perro(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void ladrar() {
        System.out.println(nombre + " está ladrando.");
    }

    public static void main(String[] args) {
        Perro miPerro = new Perro("Bobby", 3);
        miPerro.ladrar();
    }
}
