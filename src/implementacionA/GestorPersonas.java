public class GestorPersonas {
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