public class Persona {
    private String nombre;
    private String dni;
    
    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public Persona(Persona persona) {
        this.nombre = persona.nombre;
        this.dni = persona.dni;
    }

    // Getters. Se han agregado para poder acceder a los atributos de la clase Persona.

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    // Setters. Se han agregado para poder modificar los atributos de la clase Persona.

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}