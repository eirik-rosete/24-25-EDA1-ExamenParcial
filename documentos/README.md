
---
# IMPORTANTE
Dentro de [documentos](./documentos/) encontrará la respuesta de todas las preguntas.

---

# 24-25-EDA1-ExamenParcial

## Pre-examen

Aprovechando la utilización de todo el código fijado para el examen, crearemos dentro de src dos versiones de los problemas asociados que tienen que ver con la implementación de los nodos de una lista enlazada. La primera versión se encontrará en la carpeta [implementacionA](./src/implementacionA) y la segunda en la carpeta [implementacionB](./src/implementacionB).

Colocaremos pues, dentro de cada carpeta mencionada, el código y lo adaptaremos de la manera en que sea necesario para ir respondiendo las preguntas.

Se han implementado los métodos necesarios de las clases para que sea funcional el código. Para la implementación A, ha sido necesario añadir lo siguiente:

- Un método getNombre() en la clase [Persona](./src/implementacionA/Persona.java)
- Un método getDni() en la clase [Persona](./src/implementacionA/Persona.java)
- Un método setNombre() en la clase [Persona](./src/implementacionA/Persona.java)

- Un método getPersona() en la clase [Nodo](./src/implementacionA/Nodo.java)
- Un método getSiguiente() en la clase [Nodo](./src/implementacionA/Nodo.java)

Para la implementación B, ha sido necesario añadir lo siguiente:

- Un método getDni() en la clase [Persona](./src/implementacionB/Persona.java)
- Un método setNombre() en la clase [Persona](./src/implementacionB/Persona.java)

- Un método getPersona() en la clase [Nodo](./src/implementacionB/Nodo.java)
- Un método getSiguiente() en la clase [Nodo](./src/implementacionB/Nodo.java)

Asimismo, se creó dos 'Main' por implementación, uno que es para la pregunta dos, específicamente, y otro que es para el resto de preguntas, de manera general.

## Pregunta 1: análisis de implementaciones

Observe los siguientes fragmentos de código que implementan un nodo para una lista enlazada:

**Implementación A**

```java
class Nodo {
    private Persona persona;
    private Nodo siguiente;
    
    public Nodo(Persona persona, Nodo siguiente) {
        this.persona = new Persona(persona.getNombre(), persona.getDni());
        this.siguiente = siguiente;
    }
}
```

**Implementación B**

```java
class Nodo {
    private Persona persona;
    private Nodo siguiente;
    
    public Nodo(Persona persona, Nodo siguiente) {
        this.persona = persona;
        this.siguiente = siguiente;
    }
}
```

||
|-
a) ¿Qué implementación considera que utiliza mejor los recursos de memoria? Justifique su respuesta.

La implementación B utiliza mejor los recursos de memoria, ya que no crea un nuevo objeto Persona cada vez que se crea un nuevo nodo, sino que hace referencia al mismo objeto. En cambio, la implementación A crea un nuevo objeto Persona cada vez que se crea un nuevo nodo, incluso fue necesaria la creación de un método getNombre() en la clase Persona para poder obtener el nombre de la persona y poder crear un nuevo objeto Persona con los mismos datos (aunque esto no significa que B no sea escalable en un futuro implementando la misma función)

b) ¿Qué problemas o ventajas podría causar cada implementación? Proporcione ejemplos.
c) ¿Cómo afectaría cada implementación al comportamiento de una lista que use estos nodos?

## Pregunta 2: gestión de referencias

Considere este código:

```java
class Lista {
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
```

a) Si tenemos:

```java
Lista lista = new Lista();
Persona juan = new Persona("Juan", "1234");
lista.insertarPersona(juan);
Persona personaEncontrada = lista.obtenerPersona("1234");
personaEncontrada.setNombre("Juan Manuel");
```
¿Qué nombre tendrá la persona almacenada en la lista? ¿Por qué?

b) ¿Qué sucedería si modificamos:

```java
juan.setNombre("Juan Carlos");
```

después de insertarlo en la lista? ¿Depende de la implementación del Nodo que usemos (A o B de la pregunta anterior)?

## Pregunta 3: referencias y constructores

Analice este código:

```java
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
}

public class Principal {
    public static void main(String[] args) {
        Persona manuel = new Persona("Manuel", "1234");
        Persona copia = new Persona(manuel);
        Persona referencia = manuel;
        
        Lista lista = new Lista();
        lista.insertarPersona(manuel);
        lista.insertarPersona(copia);
        lista.insertarPersona(referencia);
    }
}
```

||
|-
a) ¿Cuántos objetos Persona diferentes hay en memoria? Justifique su respuesta.
b) Si hacemos `manuel.setNombre("Manuel Antonio")`, ¿qué elementos de la lista se verán afectados? ¿Por qué?

## Pregunta 4: diseño y optimización

Proponga una implementación de una Lista que:

- Permita detectar si se está intentando insertar una referencia a una Persona que ya existe en la lista
- Permita elegir si queremos insertar una copia de la Persona o mantener la referencia
- Sea eficiente en el uso de memoria

Explique su diseño y justifique las decisiones tomadas.

## Pregunta 5: análisis de código

Dado este fragmento:

```java
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
```

||
|-
a) ¿Qué problemas potenciales ve en este código respecto al manejo de referencias?
b) ¿Cómo lo mejoraría para evitar modificaciones no deseadas de los objetos?
c) Proponga una solución que proteja la integridad de los datos.
