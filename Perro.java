public class Perro extends Animal {
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
