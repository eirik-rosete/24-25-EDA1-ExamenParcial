public class MainPregunta2 {

    public static void main(String[] args) {
        Lista lista = new Lista();
        Persona juan = new Persona("Juan", "1234");
        lista.insertarPersona(juan);
        Persona personaEncontrada = lista.obtenerPersona("1234");
        personaEncontrada.setNombre("Juan Manuel");

        juan.setNombre("Juan Carlos");
    }
}