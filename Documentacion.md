# Documentación del Programa PR401

El programa PR401 es una aplicación de Cuaderno de Profesor que permite gestionar y analizar las notas de los alumnos de un curso. Proporciona funciones para ingresar el número de alumnos, introducir y visualizar las notas, realizar operaciones estadísticas y más.

## Estructura del Código

El código está organizado en varias secciones:

### 1. MainActivity

La clase `MainActivity` es la actividad principal de la aplicación que establece el contenido de la interfaz de usuario utilizando Compose.

### 2. Main Composable

La función `Main` define la estructura principal de la interfaz de usuario. Está dividida en dos secciones: el encabezado (Sección 1) y el cuerpo principal (Sección 2).

#### Sección 1: Encabezado

Contiene el logo del proyecto y el nombre del curso. 

#### Sección 2: Cuerpo Principal

Contiene la caja principal que alberga el resto de la aplicación. Se divide en dos partes: la entrada del número de alumnos y la gestión de las notas.

### 3. Funciones Auxiliares

- `MostrarResultadoDialog`: Composable que muestra un cuadro de diálogo con resultados.
- `encontrarValorMasAlto`: Encuentra el valor más alto en un array de enteros.
- `encontrarValorMasBajo`: Encuentra el valor más bajo en un array de enteros.
- `calcularMediaSinExtremos`: Calcula la media de un array excluyendo los valores más altos y más bajos.
- `ponerNotaEnCero`: Pone en cero una nota específica en el array de notas.
- `reiniciarArray`: Reinicia todas las notas en el array a cero.

## Uso de la Aplicación

1. **Ingreso del Número de Alumnos:**
   - Se introduce el número de alumnos del curso en un campo de entrada.
   - Se presiona el botón "Enviar" para inicializar el array de notas.

2. **Ingreso de Notas:**
   - Se introduce la nota de cada alumno en un campo de entrada.
   - Se utilizan botones para insertar, visualizar y gestionar las notas.

3. **Operaciones Adicionales:**
   - Se pueden realizar operaciones estadísticas, como encontrar la nota más alta, calcular la media sin extremos, borrar notas y reiniciar todas las notas.

4. **Visualización de Resultados:**
   - Los resultados se muestran en un cuadro de diálogo con la opción de aceptar.

## Requisitos y Dependencias

- Se requiere Android API nivel 21 o superior.
- El proyecto utiliza la biblioteca Compose y Material3 para la interfaz de usuario.

## Contribuciones y Desarrollo Futuro

El programa está abierto a contribuciones. Para desarrolladores futuros, se sugiere mejorar la interfaz de usuario, agregar más funciones estadísticas y mejorar la eficiencia del código.

---
*Este documento fue generado automáticamente.*
