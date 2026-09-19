import java.util.ArrayList;
import java.util.List;

public class Veterinaria {
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
