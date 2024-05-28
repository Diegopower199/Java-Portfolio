# Clases comunes y proyectos (Common classes and projects)

La relacion entre proyectos se establece mediante dependencias. Se deben seguir los siguientes pasos para relacionar una clase en un proyecto con otro:

1. Crear un proyecto Maven

    - Pulsamos Ctrl+Shift+P y "Create Java Project"

    - El tipo de proyecto es Maven

    - El archetype "maven-archetype-quickstart"

    - La version la que deseemos

    - El "group id" y "artifact id" el que queramos


2. Definir Dependencias

    - Se debe agregar una sección <dependencies> que especifique las dependencias que necesitas

    - Esta dependencia debe tener el "groupId", "artifactId" y "version" del proyecto donde esten las clases que queremos hacer genéricas en el proyecto

<dependencies>
    <dependency>
        <groupId>groupId-proyecto-receptor</groupId>
        <artifactId>artifactId-proyecto-receptor</artifactId>
        <version>version-proyecto-receptor</version>
    </dependency>
</dependencies>

    - Cambia groupId-proyecto-receptor, artifactId-proyecto-receptor y version-proyecto-receptor con los valores correctos del proyecto receptor.

    - Asegúrate de que el proyecto emisor está construido: Antes de importar la clase, asegúrate de que el proyecto emisor esté construido y tenga el JAR generado.

3. Instalar la Dependencia Localmente

    - mvn clean install

4. Verificar que las Clases Estén Accesibles

    - Asegúrate de que las clases del proyecto dependiente estén correctamente empaquetadas y que las clases que necesitas estén en el JAR resultante.


5. Compilar y Ejecutar
