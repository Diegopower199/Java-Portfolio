## Ejercicio 3: Un color por día

Tenemos que organizar los colores que se van a utilizar para los tickets de un bar. Cada día debe tener asignado un color diferente.

Implementa un programa en Java que lleve a cabo las siguientes acciones:
 
1. Declare una estructura de tipo Map donde las claves sean fechas (objetos de tipo LocalDate) y los valores sean cadenas de caracteres (objetos String) que representen colores.

2. Mediante un bucle que realizará cinco iteraciones, rellene la estructura con los cinco primeros días del mes de marzo de 2022 y asigne a cada día un color aleatorio que no puede repetirse con respecto a los días anteriores.

3. Recorra la estructura y muestre por pantalla su contenido escribiendo en una línea diferente cada entrada del Map, es decir, una línea por cada par (clave, valor).