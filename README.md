
# Challenge NanLabs -SpaceX





## Documentation


El proyecto se construyo con java 15
El repositorio del proyecto es el siguiente:

https://github.com/dscrespo/nanlabs

La rama Master tiene un script (deploycontainer.sh) para crear una imagen y
correrlo en un contenedor Docker.

Una vez levantado el contenedor, y si no dio errores, el endpoint para insertar
las cards es el siguiente:

http://localhost:8080/api/card/insertcard


Como el ejercicio no especificaba de crear un board, cree uno en trello (spacex)
Tambien cree las columnas para insertar las cards

Para consumir la api:

## API Reference

#### Post card

```http
  POST /api/card/insertcard
```

Task:

{
    "type" : "task",
    "title": "Una Tarea nueva nuevisima", 
    "category": "Research"
}

Bug:

{
    "type" : "bug",
    "description": "Ocurrio un error", 
}

Issue:

{
    "type" : "issue",
    "description" : "Let piloits send messages to Central",
    "title": "Send Message 2"
}

Para consultar las cards insertadas (entiendo que es publico, sino me avisan y los agrego):

https://trello.com/b/chdiroBH/spacex





## Optimizations

En la rama refactor de github, se optimizo el modelo, pero no se mergeo
a master porque no le pude dar contexto a spring para que busque la implementacion
de mapstruct (que es el framework que use para mapear entidades)

El manejo de errores lo administro y devuelvo un mensaje custom con un ControllerAdvice

Quedo para refactorizar ciertas partes del codigo (especial bloque cards ids)
## Feedback

Como ejercicio estuvo realmente interesante, le dedique tiempo (mas de lo que estimado)
y aprendi varias cosas en el camino.

Dejo mi mail si quieren consultar algo:

diegoscrespo@gmail.com

Saludos!

