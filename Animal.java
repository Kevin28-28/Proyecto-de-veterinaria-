public class Animal {
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
