## Ejercicio 5: Clasificación de fechas por día de la semana

Implementa un programa en Java que solicite un año (entre 1900 y 2100) por teclado y a continuación rellene de manera automática una estructura de tipo Map donde:

1. Las claves serán de tipo Month.

2. Los valores serán nuevas estructuras de tipo Map donde:
   1. Las claves serán de tipo DayOfWeek.
   2. Los valores serán estructuras de tipo Set de referencias a objetos LocalDate (Set<LocalDate>). En ese conjunto se almacenarán las fechas que correspondan, en un mes determinado, a un día de la semana determinado del año introducido por teclado.


Resumiendo, se trataría de una estructura de tipo Map<Month, Map<DayOfWeek, Set<LocalDate>>>.
 
La idea es que para cada mes del año (claves de Month.JANUARY a Month.DECEMBER) se pueda consultar cada día de la semana (de DayOfWeek.MONDAY a DayOfWeek.SUNDAY) para obtener un conjunto (Set) que contenga todas las fechas que caen en ese día de la semana de ese mes.

Por ejemplo, para el año 2022, tendremos un Map de doce elementos (uno para cada mes del año) donde, por ejemplo, el valor correspondiente a la clave Month.JANUARY será un nuevo Map de siete elementos (uno para cada día de la semana) donde, por ejemplo, el valor correspondiente a la clave DayOfWeek.MONDAY será un Set de cuatro elementos con el siguiente contenido [07/02/2022, 14/02/2022, 21/02/2022, 28/02/2022].

Una vez la estructura haya sido completamente rellenada mediante un mecanismo automático a través de uno o varios bucles (no se trata de escribir "a mano" el relleno) debes consultar y mostrar por pantalla la siguiente información contenida en ella:

1. Las fechas de febrero que caen en lunes (una por línea). Es decir, cada uno de los elementos contenidos en el Set nombredeTuMap.get(Month.FEBRUARY).get(DayOfWeek.MONDAY), donde nombredeTuMap será el nombre que hayas asignado a tu variable de tipo Map que apunta a toda la estructura.

2. Las fechas de marzo que caen en jueves (una por línea).

3. Las fechas de diciembre que caen en domingo (una por línea).
 
