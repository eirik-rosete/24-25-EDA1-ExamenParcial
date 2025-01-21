package parcial.modelosUML.diagramaA;

public class DiagramaA {

    public static void main(String[] args) {
        Persona manuel = new Persona("Manuel", "1234");
        Persona copia = new Persona(manuel);
        Persona referencia = manuel;

        Lista lista = new Lista();
        lista.insertarPersona(manuel);
        lista.insertarPersona(copia);
        lista.insertarPersona(referencia);
    }

    static class GestorPersonas {
        private Lista lista;

        public void agregarPersona(Persona persona) {
            if (!lista.contiene(persona)) {
                lista.insertarPersona(persona);
            }
        }

        public Persona buscarPersona(String dni) {
            return lista.obtenerPersona(dni);
        }
    }

    static class Lista {
        private Nodo primero;

        public void insertarPersona(Persona persona) {
            Nodo nuevo = new Nodo(persona, primero);
            primero = nuevo;
        }

        public boolean contiene(Persona persona) {
            Nodo actual = primero;
            while (actual != null) {
                if (actual.getPersona().getDni().equals(persona.getDni())) {
                    return true;
                }
                actual = actual.getSiguiente();
            }
            return false;
        }

        public Persona obtenerPersona(String dni) {
            Nodo actual = primero;
            while (actual != null) {
                if (actual.getPersona().getDni().equals(dni)) {
                    return actual.getPersona();
                }
                actual = actual.getSiguiente();
            }
            return null;
        }
    }

    static class Nodo {
        private Persona persona;
        private Nodo siguiente;

        public Nodo(Persona persona, Nodo siguiente) {
            this.persona = new Persona(persona.getNombre(), persona.getDni());
            this.siguiente = siguiente;
        }

        public Persona getPersona() {
            return persona;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }
    }

    static class Persona {
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

        public String getNombre() {
            return nombre;
        }

        public String getDni() {
            return dni;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }
}