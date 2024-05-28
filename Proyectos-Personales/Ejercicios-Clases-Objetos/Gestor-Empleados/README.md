Crear un programa que posea la clase Empleado. 

Esta clase contendrá los atributos: 
 - nombre 
 - apellidos 
 - dni 
 - salario 
 - edad 

De cada uno de los atributos se deberán crear sus métodos getters y setters. 

Además, se añadirá un método propio adicional llamado print el cual devolverá en un String todos los datos del empleado separado por un guión, es decir, Luis – Lopez Gomez – 4747464L – 1200 – 23. 

Una vez creada la clase Empleado, crear una clase con el método main, en la cual se cree un objeto de tipo empleado, en ese objeto se añadirán vuestros datos personales (utilizando los métodos set de cada atributo) , es decir, 
```
Empleado emp1; 
emp1.setNombre(‘Javier’) 
```

Y una vez introducidos todos los datos los muestre por pantalla dato a dato (atributo a atributo) 
mediante los métodos get

```
System.out.println(emp1.getNombre()); 
```


y por último llame al método print. 
System.out.println(emp1.printI());