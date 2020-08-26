# Creacion de la base de datos en Docker 

docker run -d -p 3306:3306 \
--name soa_int_logging \
--env MYSQL_ROOT_PASSWORD='root' \
--env MYSQL_DATABASE='soa_int_logging' \
--env MYSQL_USER='soaint' \
--env MYSQL_PASSWORD='soaint' \
mysql:5.7.31


# Errores encontrados
* Codigo acoplado
* Codigo que no aplica los principios SOLID,  no  aplica principios de codigo limpio.
* No usa patrones de diseño
* Code smells
* Programacion no segura

# Sugerencias
* Desacoplar el codigo usando princio SOLID y patrones de diseños
* Aplicar buenas practicas de programacion del codigo limpio
* Aplicar programacion segura en lo que corresponda
* Patrones de diseños sugeridos : Patron Estrategia, Patron Factory, template method

# Comentario
* La solucion se ha echo refactorizando la clase demo.java
* se ha desarrollado el logging de mensajes : message, warning, error
* se pudo haber usado librerias de logging tales como : logback, log4j, sin enbargo se ha implementado para propositos de demostrar habilidades de programacion
* para hacer la prueba del logging hacia la base de datos es necesario levantar la base de datos en docker con el comando indicado en la primera linea
