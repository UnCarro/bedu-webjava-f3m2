# Postwork 6

## 🎯 OBJETIVOS

- Desarrollar un programa siguiendo las reglas de TDD.
- Añadir pruebas unitarias adicionales para probar su funcionalidad.
- Familiarizarse con TDD.
- Identificar el impacto de la premisa de transformación elegida en el resultado final

## 🚀 DESARROLLO

- Implementar el algoritmo de ordenamiento bubble sort, desglosando el desarrollo y siguiendo las reglas de
  transformaciones vistas durante la sesión

- Añade un caso de prueba, ejecutalo y comprueba que falla.

- Implementa el código mínimo necesario para que dicha prueba pase

- Aplica las premisas de transformación de ser necesario.

- Refactoriza el código si lo consideras necesario.

- Documenta (captura de pantalla, código, etc) el estado final de tus pruebas y tu código al final de cada ciclo.

- [REPOSITORIO DEL CÓDIGO](https://github.com/UnCarro/Bedu-postwork6)

Tip: La clave para derivar en un algoritmo menos eficiente es utilizar una transformación de menor orden, en el caso
particular de un bucle sort en lugar de un quicksort, dicha clave es transformar utilizando un asignación en lugar de
preferir el cómputo/lógica.

### Sigue estas instrucciones

1. Crea un nuevo archivo llamado BubbleSortTest.java
1. Crea un nuevo archivo llamado BubbleSort.java
1. Añade el primer caso de prueba para un arreglo vacío
1. Implementar el código mínimo necesario para pasar este caso de uso
1. Refactoriza el código de ser necesario
1. Aplica las transformaciones que sean necesarias
1. Repite los pasos del 3 al 6 hasta completar los casos de prueba vistos durante el work.

### Indicaciones generales

Responde las siguientes preguntas:

¿Cuál fue el paso clave para poder transicionar de un bubble sort a un quicksort?
Remplazar la lógica de ir ordenando elemento por elemento por la lógica de ir particionando el array en cada interacción.
____
¿Crees que fue más fácil implementar un quicksort de esta forma que hacerlo sin pruebas? ¿Por qué?

Al final sí, pero empezarlo es un reto porque no siempre se sabe qué se debe testear primero.
____

¿Crees que existe diferencia entre las pruebas realizadas para un bubble sort y un quicksort?

En ultima instancia, lo que se testea es el producto, no el proceso. Por lo que ambas pruebas no deberían ser muy diferentes, por no decir que nada.
____
