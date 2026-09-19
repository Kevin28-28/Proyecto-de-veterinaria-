import java.util.ArrayList;
import java.util.List;

// Clase base para animales
class Animal {
    private String nombre;
    private int edad;
    private String especie;

    public Animal(String nombre, int edad, String especie) {
        if (nombre == null || nombre.isEmpty() || edad < 0 || especie == null || especie.isEmpty()) {
            throw new IllegalArgumentException("Datos de animal inválidos");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getEspecie() { return especie; }

    @Override
    public String toString() {
        return especie + " - " + nombre + " (" + edad + " años)";
    }
}

// Subclase para perros
class Perro extends Animal {
    private String raza;

    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad, "Perro");
        if (raza == null || raza.isEmpty()) {
            throw new IllegalArgumentException("Raza inválida");
        }
        this.raza = raza;
    }

    public String getRaza() { return raza; }

    @Override
    public String toString() {
        return super.toString() + " - Raza: " + raza;
    }
}

// Clase Cliente
class Cliente {
    private String nombre;
    private String telefono;
    private List<Animal> mascotas;

    public Cliente(String nombre, String telefono) {
        if (nombre == null || nombre.isEmpty() || telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("Datos de cliente inválidos");
        }
        this.nombre = nombre;
        this.telefono = telefono;
        this.mascotas = new ArrayList<>();
    }

    public void agregarMascota(Animal mascota) {
        if (mascota != null) {
            mascotas.add(mascota);
        }
    }

    public List<Animal> getMascotas() { return mascotas; }

    @Override
    public String toString() {
        return nombre + " - Tel: " + telefono + " - Mascotas: " + mascotas.size();
    }
}

// Clase principal de gestión
class Veterinaria {
    private List<Cliente> clientes;

    public Veterinaria() {
        clientes = new ArrayList<>();
    }

    public void registrarCliente(Cliente cliente) {
        if (cliente != null) {
            clientes.add(cliente);
        }
    }

    public void mostrarClientes() {
        for (Cliente c : clientes) {
            System.out.println(c);
            for (Animal a : c.getMascotas()) {
                System.out.println("   " + a);
            }
        }
    }
}

// Clase Main para pruebas
public class Main {
    public static void main(String[] args) {
        Veterinaria vet = new Veterinaria();

        Cliente cliente1 = new Cliente("Juan Pérez", "555-1234");
        cliente1.agregarMascota(new Perro("Firulais", 3, "Labrador"));

        Cliente cliente2 = new Cliente("Ana López", "555-5678");
        cliente2.agregarMascota(new Animal("Mishi", 2, "Gato"));

        vet.registrarCliente(cliente1);
        vet.registrarCliente(cliente2);

        vet.mostrarClientes();
    }
}
