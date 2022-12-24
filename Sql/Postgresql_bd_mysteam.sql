create database if not exists mysteam;
use mysteam;

create table if not exists perfil (
	pkperfil int primary key,
	rol varchar(50)	
);
create table if not exists usuario (
	pkusuario serial primary key,
	alias varchar(12) not null UNIQUE,
	password varchar(20) not null,
	nombre varchar(80) not null,
	apellidos varchar(80) not null,
	fechanace Date not null,
	email varchar(80) not null UNIQUE,
	akperfil int not null,
	avatar bytea,	
	foreign key (akperfil) references perfil (pkperfil)	
);
create table if not exists biblioteca (
	pkbiblioteca serial primary key,
	akusuario int not null,
	fecha date not null,
	foreign key (akusuario) references usuario (pkusuario)
);
create table if not exists coleccion (
	pkcoleccion serial primary key,
	akbiblioteca int not null,  
	nombre varchar(50) not null,
	descripcion text,
	foreign key (akbiblioteca) references biblioteca (pkbiblioteca)
);
create table if not exists genero (
	pkgenero varchar(12) primary key,
	nombre varchar(80) not null,
	descripcion varchar(80)
);
create table if not exists nivel (
	pknivel varchar(12) primary key,
	nombre int not null
);
create table if not exists pegi (
	pkpegi int primary key,
	rangopegi varchar(20) not null,
	observaciones varchar(250)
);
create table if not exists juego (
	pkjuego serial primary key,
	titulo varchar(50) not null,
	descripcion text,
	imagen varchar(255) not null,
	zipjuego varchar(255) not null,
	akgenero varchar(12) not null,
	aknivel varchar(12) not null,
	akpegi int not null,
	akcreador int not null,
	fechacreacion date not null,
	pvp float4, 
	numdescargas int not null,
	FOREIGN KEY (akgenero) REFERENCES genero (pkgenero),
	FOREIGN KEY (aknivel) REFERENCES nivel (pknivel),
	FOREIGN KEY (akpegi) REFERENCES pegi (pkpegi),
	FOREIGN KEY (akcreador) REFERENCES usuario (pkusuario)
);
create table if not exists descarga (
	pkdescarga SERIAL primary key,
	akbiblioteca int not null, 
	akjuego int not null,
	fecha date not null,
	foreign key (akbiblioteca) references biblioteca (pkbiblioteca),
	foreign key (akjuego) references juego (pkjuego)
);
