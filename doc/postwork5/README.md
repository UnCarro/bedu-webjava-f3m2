# Postwork 5

## 🎯 OBJETIVOS

- Añadir la funcionalidad de resta a la clase SomeBusinessLogic
- Añadir pruebas con inyección de mocks.
- Familiarizarse con las herramientas de mockito.

## 🚀 DESARROLLO

Durante nuestro work, desarrollamos algunas funcionalidades en la clase SomeBusinessLogic y comenzamos a familiarizarnos con el uso de Mockito. Ahora en este post work continuaremos con el desarrollo de esta clase y exploraremos algunas funcionalidades de Mockito realizando el siguiente ejercicio:

- Añade la funcionalidad de restar en la clase SomeBusinessLogic
- El método debe utilizar SomeDataService
- Debemos probar al menos 3 casos: con un arreglo de múltiples números, con un arreglo vacío y con un arreglo de un solo número
- Implementa los mocks con múltiples valores de retorno: Mas información: https://dev.to/srinivasu619/mockito-returning-a-different-value-for-the-same-function-invocation-434c
- Explora las posibilidades de utilizar mocks que regresan valores específicos de acuerdo a los parámetros que reciben.


Sigue estas instrucciones:

1. En el archivo SomeBusinessLogic.java  añade una función llamada calculateSubstractionWithADataService
2. Para su implementación básate en lo realizado con calculateSumWithADataService
3. En el archivo SomeBusinessLogicMockTest.java crea tres métodos con los siguientes nombres: calculateSubstractionUsingDataService_basic, calculateSubstractionUsingDataService_empty y calculateSubstracionUsingDataService_oneValue
4. Implementa los mocks con múltiples valores de retorno: Más información: https://dev.to/srinivasu619/mockito-returning-a-different-value-for-the-same-function-invocation-434c


### Indicaciones generales

¿Terminaste la actividad?
    
🚀 [Ver repositorio de la actividad](https://github.com/adavals/bedu-webjava-mockito)

Responde las siguientes preguntas:

¿Cómo decidiste inyectar el mock?
    
    Mediante las siguientes anotaciones:

    - @ExtendWith(MockitoExtension.class) en la clase de prueba
    - @InjectMocks en el objeto SomeBusinessLogic
    - @Mock en el objeto SomeDataService
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________
¿Implementaste un solo método de prueba con múltiples valores de retorno o implementaste múltiples pruebas? ¿Por qué?

    Ambos métodos, para identificar diferentes formas de hacerlo y elegir la más conveniente de acuerdo al caso.
    Se agregó una clase de prueba para registrar ambas formas: SomeBusinessLogicMockitoExtensionTest.java. 
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________

¿Crees que existe diferencia entre los mocks que inyectamos manualmente y los inyectados con mockito? ¿Cuáles?

    Si hay diferencia. Los mocks inyectados manualmente serían instancias de los objetos reales y requieren que el desarrollador escriba más codigo para su configuración, esto implica que el desarrollador también tiene más control sobre el objeto mock. 
    En cambio, el framework Mockito crea el objeto mock dinámicamente, de acuerdo a la clase que se le indica y automatiza una gran parte de las tareas facilitando la definición de comportamientos en los objetos mock.
_________________________________________________________________________________________________________________________________________________________________________________________________________________________________




