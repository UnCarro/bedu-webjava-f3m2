# Postwork 4

## 🎯 OBJETIVOS

- Implementar pruebas de caja negra y blanca

## 🚀 DESARROLLO

Continuaremos con el desarrollo del software de entrevistadores y exploramos las pruebas de caja negra y blanca realizando el siguiente ejercicio:

- Añadir las pruebas de casos uso generadas durante el Reto 1

- Diseñar posibles pruebas de caja blanca para el código

- Debemos generar pruebas de caja negra y blanca según corresponda

### Sigan las instrucciones y dividan las actividades de forma equitativa entre cada miembro del equipo

1. Durante el reto 1 generen los casos de uso y sus especificaciones par acumplir con la historia de usuario: añadir entrevistadores.

    **Historia de usuario: Añadir entrevistadores**

    El administrador quiere registrar nuevos entrevistadores en el sistema.

    **Historia de usuario (As, Want, So): Añadir entrevistadores**

    **AS** un usuario administrador **I WANT**  registrar nuevos entrevistadores **SO** los entrevistadores se pueden consultar en el sistema.

    **Descripción Given, When, Then (GWT)**

    Criterios de aceptación

    **GIVEN** un usuario administrador **WHEN** ingresa los datos del entrevistador **THEN** se crea su registro en la aplicación.

    **Caso de Uso**

    Precondiciones:

        El usuario cuenta con permisos de administrador

    Actor:

        Usuario administrador

    Entrada:

        name (string al menos 3 caracteres)
        lastName (string al menos 3 caracteres)
        email (string de al menos 6 caracteres)

    Salida:

        id

    Flujo:

        1. Crear el interviewer correspondiente
            1.1 Validar el email
                1.1.1 Si el email es invalido lanzar la excepción InvalidEmail
            1.2 Crear la nueva instacia de la clase Interviewer
            1.4 Guardar la entidad
            1.5 Responder con el id del nuevo entrevistador
        2. Enviar la respuesta
2. En el archivo de pruebas añadan las pruebas correspondientes para validar que se cumplan los criterios de aceptación.
3. Modifiquen el código de alta de entrevistadores de ser necesario.
4. Repitan los pasos 2 y 3 hasta que todos los criterios de aceptación sean validados con al menos una prueba y todas tus pruebas pasen.

### Indicaciones generales

Respondan las siguientes preguntas:

¿Cuál es la principal diferencia que notan entre las pruebas de caja negra y blanca?

**Las pruebas de caja negra se basan en el comportamiento esperado sin tener conocimiento de cómo está construido el programa, mientras que las de caja blanca se basan en el conocimiento que se tiene de cómo está construido el programa.**
_____________________________________________________
¿Qué ventajas consideran que tienen unas sobre las otras?

**Para las pruebas de caja negra la ventaja puede ser mayor agilidad de desarrollo de pruebas porque que se enfocan en el comportamiento esperado, sin conocer el código, sin depender de los desarrolladores y sin tener acceso o comprensión del código fuente.
Para las pruebas de caja blanca la ventaja sería una mayor cobertura de código y la detección temprana de código con problemas de desempeño, ineficiente o con errores.**
_____________________________________________________
¿Creen que existe alguna desventaja de contar solo con pruebas de caja negra?

**Si, podrían estar faltando pruebas que detectan deficiencias en el código que pueden generar problemas de desempeño o errores.**
_____________________________________________________
