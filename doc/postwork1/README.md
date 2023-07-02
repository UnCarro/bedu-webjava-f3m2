# Postwork 1

### 🎯 OBJETIVOS

- Desarrollen funcionalidad adicional a nuestro programa.
- Agreguen pruebas unitarias adicionales para probar su funcionalidad.
- Apliquen técnicas de diseño de pruebas.
- Utilicen la herramienta JUNIT.
- Realicen integración continua con Github

### 🚀 DESARROLLO

Durante nuestro work, desarrollamos las primeras funcionalidades de nuestro software de entrevistas  y nos comenzamos a familiarizar con el uso de JUnit. Ahora en este postwork continuaremos con el desarrollo del software de entrevistas y exploramos algunas funcionalidades de JUnit realizando el siguiente ejercicio en equipos.

El project manager ha definido como objetivo para este sprint añadir las siguientes características a nuestro sistema actual:
- La información de los entrevistadores se puede modificar desde terminal.
- La definición de hecho (Definition of Done) establece que todo el código generado debe contar con pruebas unitarias.

Sigan las siguientes instrucciones y dividan las actividades entre cada miembro del equipo:

1. Añadir la opción número 3 al menú, con el texto: "3. Modificar un entrevistador".

2. Dentro de nuestro switch generar el case con valor 3 y llamar a la función modifyInterviewer que crearemos a continuación.

3. Crear la función modifyInterviewer solicitar el email del entrevistador y en caso de no encontrarlo imprimir el mensaje:  "Entrevistador no encontrado".

4. Solo se debe continuar en este flujo si el entrevistador fue encontrado.

5. Solicitar a continuación el nuevo nombre, apellido y email, mencionando que se debe apretar Enter para mantener el valor actual. Preguntar si el entrevistador se encuentra activo.

6. Guardar los datos del entrevistador llamando a la función save de nuestro objeto interviewer.

7. Añadir las pruebas unitarias correspondientes para validar el correcto funcionamiento de la funcionalidad de editar entrevistadores.

8. Instalar Github o trabajarlo en línea, iniciar sesión y crear el repositorio.

9. Hacer el versionamiento del código incluyendolo en el repositorio creado.

### Reflexiones finales

Una vez que hayan terminado el postwork respondan las siguientes preguntas:

¿Cómo crearon la prueba para validar que se guardan correctamente los archivos?
**Agregamos un nuevo objeto Interviewer al arreglo, luego ejecutamos la función de modificar Interviewer con datos diferentes y usamos el email para localizar el objeto a modificar, luego consultamos el objeto modificado mediante email 
y la prueba pasa si obtuvimos los datos modificados como respuesta.** 
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________

¿Decidieron probar directamente en los métodos de la clase interviewer o probaron en el menú?
**Probamos en el menú.**
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________

¿Creen que existe diferencia entre las pruebas hechas directamente a la clase interviewer y las realizadas al menú? ¿Por qué?
**Si hay diferencia porque al probar en el menú también se prueba la interacción con el usuario**
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________


