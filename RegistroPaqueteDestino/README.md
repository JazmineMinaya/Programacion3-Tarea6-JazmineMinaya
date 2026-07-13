# Programacion3-Tarea5-JazmineMinaya
Tarea 6 - Sistema de Registro de Paquetes y Destinos

## Nombre del Proyecto
Tarea 6

## Estudiante
Jazmine Arleny Minaya Peralta

## Matrícula
1000-6143

## Materia
Programación 3

## Descripción
Este programa en Java integra una aplicación desarrollada en JavaFX y FXML para registrar y consultar paquetes y destinos mediante una interfaz gráfica.

## Tecnologías utilizadas
- Java
- JDK 25
- Visual Studio Code


## Preguntas de Reflexión

1. ¿Cuál es la diferencia entre Thread y Platform.runLater()?

Su diferencia radica en que Thread representa un hilo secundario independiente encargado de ejecutar tareas pesadas en segundo plano para evitar que la aplicación se congele, mientras que Platform.runLater() no crea un hilo nuevo, sino que se encarga de programar de la actualización de los componentes visuales del hilo principal de la interfaz gráfica.

2. ¿Qué ocurre si se usa Thread.sleep() directamente dentro del evento de un botón?

En este caso, se provocaría el bloqueo inmediato del hilo principal de JavaFX, lo que genera que la interfaz gráfica se congele por completo y deje de responder a cualquier interacción del usuario hasta que finalice el tiempo de espera programado en el programa.

3. ¿Por qué no se debe actualizar un Label directamente desde un hilo secundario?

Porque los componentes de JavaFX no están diseñados para soportar el acceso concurrente desde múltiples hilos, por consiguiente, intentar modificarlos desde un hilo secundario violaría las reglas de sincronización de la interfaz, provocando errores o excepciones en la aplicación.

4. ¿Para qué sirve BufferedReader?

El BufferedReader sirve para optimizar los procesos de lectura de texto almacenando los datos en un búfer, permitiendo así procesar líneas completas de caracteres en lugar de acceder de forma repetida al disco.

5. ¿Para qué sirve FileWriter?

El FileWriter sirve para establecer un canal de comunicación directo con el sistema de archivos, permitiendo de esta manera escribir flujos de caracteres para escribir datos textuales en un archivo del disco.

6. ¿Por qué es importante guardar la información en archivos?

Es importante porque garantiza la persistencia de los datos del programa, impidiendo que la información se destruya al cerrar la aplicación o apagarse el sistema.

7. ¿Qué ventaja tiene usar ComboBox para seleccionar destinos?

Su ventaja radica en que restringe las opciones del usuario, eliminando la posibilidad de introducir datos incorrectos, garantizando así la validez de los datos.

8. ¿Qué ventaja tiene usar TableView para consultar paquetes?

Porque proporciona una estructura visual organizada en filas y columnas que facilita la visualización de los datos, ya que mejora significativamente la legibilidad y el ordenamiento de los datos.