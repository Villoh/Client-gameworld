# Aplicación Cliente.

## Objetivo de la aplicación.

El objetivo es desarrollar una plataforma para videojuegos que permita iniciar sesión, cargar y descargar juegos, así como gestionar los juegos de cada usuario. También será necesario desarrollar un videojuego inicial para dicha plataforma.

## Aplicación Servidor.

* [Servidor.](https://gitlab.com/iesaglinformatica/curso_22_23/reto_dam2/equipo1/cliente_servidor/servidor)

## Base de datos.
* [Postgres sql.](https://gitlab.com/iesaglinformatica/curso_22_23/reto_dam2/equipo1/cliente_servidor/cliente/-/blob/main/Sql/Postgresql_bd_mysteam.sql)
* Hibernate.

## Interfaz gráfica.
JavaFX.

## Servidor de datos.
Servidor Ubuntu, con aplicación java la cual se comunica con el cliente a través de Sockets. 

## Métodos destacados dentro de la aplicación.

* Subir archivo al servidor: Se encuentra en la clase PantallaSubirJuegoController. Método subirJuego();
* Descargar archivo al servidor:  Se encuentra en la clase PantallaJuegoEspecificoController. Método descargarJuego();
* Comunicación con el servidor: SocketTransfer.
