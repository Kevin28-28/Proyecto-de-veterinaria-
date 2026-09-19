public class Main2 {
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
