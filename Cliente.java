import java.util.ArrayList;
import java.util.List;

public class Cliente {
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
