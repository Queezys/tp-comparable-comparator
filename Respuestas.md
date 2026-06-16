# Trabajo Práctico: Ordenamiento de Objetos

### Pregunta 1: ¿Por qué Collections.sort() no compila cuando le pasamos una List<Estudiante>? ¿Qué contrato exige Java que nuestra clase no está cumpliendo?

Respuesta: No compila porque el método Collections.sort(List<T>) exige estrictamente que el tipo de datos de la lista (`T`) implemente la interfaz 'Comparable'. 

Java no sabe con qué criterio ordenar nuestras propias clases de dominio (no sabe si debe priorizar el legajo, el nombre, la edad o el promedio). El contrato que exige Java y que nuestra clase Estudiante no está cumpliendo en este momento es la implementación de la interfaz "Comparable" y su método obligatorio compareTo(Estudiante o), el cual define el "orden natural" del objeto.

### Pregunta 2: ¿Por qué elegiste el atributo 'promedio' como orden natural? ¿Qué pasaría si mañana un nuevo requisito pide ordenar por 'cantidadMateriasAprobadas'? ¿Modificarías 'compareTo'? ¿Qué consecuencias tendría?

Respuesta: Se elige como orden natural para medir el mérito académico en este dominio. Si en un futuro quisieramos cambiar el orden en el que se ordena como la cantidad de materias aprobadas, tendriamos que modificar el compareTo de la clase nuevamente. Esto trae la consecuencia de que se podría 'romper' el codigo que haya estado haciendo uso del orden natural anterior en alguna otra parte.

### Pregunta 3: Comparable nos ata a un único criterio de ordenamiento. ¿Qué problemas de diseño introduce esto si nuestro sistema necesitara ordenar la misma lista de estudiantes de 4 formas distintas según el contexto? Relacioná tu respuesta con los principios de responsabilidad única (SRP) y abierto/cerrado (OCP).

Respuesta: Si quisieramos hacer los 4 ordenamientos con Comparable, tendríamos que moficiar el método compareTo con if/else anidados o switch para detectar y eso volveria al método más complejo.

El Principio de Responsabilidad Única(SRP) dice que no tenemos que sobrecargar de responsabilidades a la clase Estudiantes cuya responsabilidad es modelar la entidad del dominio y terminaria haciendose cargo de manejar la logica y control de la estrategia de negocio.
El principio Abierto/Cerrado (OCP) dice que si quisieramos agregar una funcionalidad como un nuevo ordenamiento, no tenemos que "abrir" la clase para modificarla, sino que la tenemos que extender, en este caso con comparable tendriamos que abrir la clase una y otra vez para agregar un ordenamiento nuevo en lugar de simplemente extenderlo.

### Pregunta 4: Explicá con tus palabras qué es un overflow de enteros, por qué el "truco de la resta" lo provoca, qué parte del contrato de Comparator rompe, y por qué Integer.compare() no sufre este problema.

El overflow o desbordamiento ocurre al pasar el límite, en este caso, del int. el int utiliza 32 bits de memoria para almacenar valores. Esto significa que tiene un rango limitado: el número más chico que puede guardar es -2147483648 y el más grande es 2147483647 (Integer.MAX_VALUE). Cuando se resta 2147483647 - (-1) pasa ese límite y da la vuelta al otro extremo, es decir al extremo negativo y queda -2147483647.

El contrato del comparator dice que si 'e1' es mayor a 'e2' el metodo tiene que devolver un número positivo.
Como se produce desbordamiento el método interpreta que es un negativo por lo tanto lo toma como menor.

El integer.compare() no se rompe porque no realiza restas, su codigo es el siguiente:
return (x < y) ? -1 : ((x == y) ? 0 : 1); hace comparaciones.


### Pregunta 5: ¿Qué patrón de diseño estás aplicando al usar un Map<String, Comparator<T>> en lugar de un switch? Explicá cómo se relaciona este patrón con el polimorfismo y por qué es preferible a la alternativa procedimental.

Respuesta: Al usar un Map se aplica el patron Strategy. Se relaciona con el polimorfismo porque cuando se ejecuta la acción se la delega a la interfaz Comparator.
Por polimorfismo a sort() no le interesa sabe que atributo está leyendo, solo ejecuta el método
compare correspondiente a la instancia concreta que saca del Map
La procedimental satura el método con bloques de control que crecen cuando añadimos una nueva propiedad,
violando el principio de Abierto/Cerrado. En cambio con el map solo es una línea y desacopla la lógica de 
negocio y si queremos extender las formas de ordenamiento simplemente la añadimos al map.