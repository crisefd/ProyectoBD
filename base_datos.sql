---para ejecutar este archivo desde consola escriba
-- psql - U user_name -d data_base_name -h host_name -f archivo.sql
------------------------------------------------------------------------------
--DROP TABLE programa;
CREATE TABLE programa (
    codigo VARCHAR(12) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    nivel VARCHAR(50),
    num_creditos integer
);

--DROP TABLE estudiante;
CREATE TABLE estudiante (
    codigo VARCHAR(20) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    sexo VARCHAR(12),
    codigo_programa VARCHAR NOT NULL,
    CONSTRAINT   programa_est_fk FOREIGN KEY (codigo_programa) REFERENCES programa (codigo)
);

--Insertar algunos datos

INSERT INTO programa (codigo, nombre, nivel, num_creditos) VALUES ('3702', 'Ingenieria de sistemas', 'Pregrado', 120);
INSERT INTO programa (codigo, nombre, nivel, num_creditos) VALUES ('3703', 'Ingenieria de suelos', 'Pregrado', 120);


INSERT INTO estudiante (codigo, nombre, sexo, codigo_programa) VALUES ('0900123', 'PEDRO PEREZ', 'Masculino', '3702' );
INSERT INTO estudiante (codigo, nombre, sexo, codigo_programa) VALUES ('0900124', 'JUAN PAZ', 'Masculino', '3702' );
INSERT INTO estudiante (codigo, nombre, sexo, codigo_programa) VALUES ('0900125', 'DAVID RUIZ', 'Masculino', '3703' );


