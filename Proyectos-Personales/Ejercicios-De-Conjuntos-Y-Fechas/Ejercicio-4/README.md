## Ejercicio 4: Clasificación de coincidentes

Implementa un programa en Java que lleve a cabo las siguientes acciones:
 
1. Se rellenen dos estructuras de tipo lista con quince nombres aleatorios de colores y se muestre su contenido por pantalla, de manera similar a como ya se ha hecho en el ejercicio 2.

2. Se declare y reserve espacio para una estructura de tipo Map donde las claves sean nombres de colores (objetos de tipo String) y los valores sean listas de números enteros (List<Integer>). Es decir, que se tratará de una estructura de tipo Map<String, List<Integer>>.

3. Se inspeccionen ambas listas y, si tienen el mismo color en la misma posición, se llevarán a cabo las siguientes operaciones en el Map:
    1. Si ese color aún no existe como clave, se introducirá como nueva clave y se le asignará una nueva lista de enteros vacía;
    2. se asignará, a la lista correspondiente a ese color, la posición en las listas de origen en la que ha sido encontrada la coincidencia.
   
4. Se muestre por pantalla la estructura de tipo Map.