# Postwork 3

## 🎯 OBJETIVOS

- Comparen el funcionamiento de JUnit y TestNG en escenarios similares.
- Analicen el funcionamiento de la ejecución en paralelo en JUnit 5 y en TestNG.

## 🚀 DESARROLLO

Antes de comenzar con la actividad te recomendamos revisar el siguiente recurso para que comprendas que hay detrás de la ejecución de pruebas en paralelo utilizando JUnit 5:

### Ejecución Paralela

**Sigan las instrucciones y dividan las actividades de forma equitativa entre cada miembro del equipo:*

1. En su archivo build.grade asegurense de tener junit en su versión 5.3 o superior.
2. En el mismo archivo asegurense que la configuración test luzca de la siguiente forma.

    ```grovy
    test {
    useJUnitPlatform()
    systemProperty 'junit.jupiter.execution.parallel.enabled', 'true'
    }
    ```

3. Ejecuten las pruebas
4. Cambien la configuración anterior a false y observen las diferencias en los tiempos de ejecución

### Reflexiones finales

Respondan las siguientes preguntas:

- ¿Notaron alguna diferencia en el tiempo de ejecución de las pruebas?

  **Si, las pruebas en paralelo se ejecutan entre un 10 y 15% más rápido, en promedio.**
  _________________________________________________________________________________________________________________________________________________________________________________________________________________________________
- ¿Qué ventajas consideran que aporta la ejecución en paralelo?

  **Menor tiempo de ejecución**
  _________________________________________________________________________________________________________________________________________________________________________________________________________________________________
- ¿Creen que existe alguna desventaja de ejecutar nuestras pruebas en paralelo?
  
  **Podría haber problemas en caso de que diferentes pruebas utilicen un mismo recurso, como un archivo; o en caso de que una prueba dependa de los resultados de otra prueba.**
  _________________________________________________________________________________________________________________________________________________________________________________________________________________________________
