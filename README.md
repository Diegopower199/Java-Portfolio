# Portfolio de Proyectos Java

Este repositorio contiene un conjunto de proyectos desarrollados en Java que reflejan mis habilidades y experiencia en programación. Cada proyecto se encuentra en su propia carpeta, y el código fuente, junto con la documentación correspondiente, está disponible para su revisión.

    El comando "git config --global core.longpaths true" configura Git para que acepte rutas de archivos más largas.

    El comando "git lfs install" sirve para manejar archivos grandes de manera eficiente en repositorios de Git.

Los siguientes comandos se hacen en cada proyecto para que Git LFS indique qué tipos de archivos específicos deben ser gestionados de manera especial debido a su tamaño.

    - git lfs track "*.class"

    - git lfs track "_.java"

    - git lfs track "_.xml"

El archivo ".gitattributes" es un archivo de configuración en Git que se utiliza para asignar atributos a los archivos y, entre otras cosas, especificar cómo Git debe tratar ciertos archivos


Para eliminar una carpeta .git se hace de la siguiente manera

1. Remove-Item -Recurse -Force .git

    - Elimina de forma recursiva y forzada (sin solicitar confirmación) el directorio .git en el directorio actual

2. git clean -fdX

    - Limpiará tu directorio de trabajo al eliminar archivos y directorios no rastreados, incluyendo aquellos que están en la lista de ignorados definida en .gitignore




TENER EN CUENTA ESTO PARA TODOS LOS PROYECTOS QUE HAGA:
https://chat.openai.com/share/c33d49c0-a49a-4046-9b9c-6efa4218ee4e