# Postwork 7

## 🎯 OBJETIVOS

- Desarrollar funcionalidad adicional a nuestro programa.
- Calcular métrica de complejidad ciclomática

## 🚀 DESARROLLO

En este postwork continuaremos con el desarrollo de nuestro sistema de entrevistadores. La tarea a realizar es exponer un endpoint que nos permita añadir un entrevistador, utilizando la lógica existente.

Adicionalmente tendrás que calcular la complejidad ciclomática de este código.

### Sigue estas instrucciones:

- Crea un nuevo proyecto spring o añadelo como dependencia.

- Añade un nuevo endpoint tipo POST con ruta /add-interviewer  y cuya entrada serán todos los datos necesarios para añadir un nuevo entrevistador.

- Implementa la lógica necesaria

- La respuesta del endpoint deberá incluir los datos del nuevo entrevistador.

  - Calcular la complejidad ciclomática de este código.
    - Usando la fórmula:
    
      M = E - N + 2, donde M es la complejidad ciclomática, E es el número de arcos y N es el número de nodos.:
      
      M = Arcos(7) - Nodos(7) + 2 = 2
    
    - Los dos flujos se pueden identificar de acuerdo a:
      - Flujo normal: El entrevistador se crea correctamente y no se produce ninguna excepción. El programa regresa ResponseEntity.created(URI.create("/add-interviewer")).body(result).
      - Flujo de excepción: Si se produce una excepción al intentar crear el entrevistador, el programa captura la excepción y devuelve el mensaje de excepción.

### Indicaciones generales


¿Qué lógica es compartida entre la aplicación de terminal y la aplicación web?
    
    El uso de la clase Interviewer y su método add, para añadir entrevistadores.
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________
¿Qué pruebas decidiste implementar?
    
    Para el endpoint /add-viewer se implementaron las siguientes pruebas:
        - Unitarias: InterviewerControllerTest.java, usando MockMVC
        - Integración: InterviewerControllerIntegrationTest.java usando TestRestTemplate 
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________

¿Crees que existe diferencia entre las pruebas hechas directamente a la clase interviewer y las realizadas al menú? ¿Por qué?
    
    Si, las pruebas realizadas al menú consideran la interacción en pantalla con el usuario y el funcionamiento de la clase Interviewer, en cambio las pruebas sobre la clase interviewer sólo considera el correcto funcionamiento de sus métodos.
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________








