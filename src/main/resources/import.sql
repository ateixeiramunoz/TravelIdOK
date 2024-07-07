-- Insertar datos en la tabla de paises
INSERT INTO paises (nombre) VALUES ('España');
INSERT INTO paises (nombre) VALUES ('Italia');
INSERT INTO paises (nombre) VALUES ('Francia');
-- Insertar datos en la tabla de localizaciones
INSERT INTO localizaciones (nombre, codigo, id_pais) VALUES ('Localizacion 1', 'LOC1', (SELECT id FROM paises WHERE nombre = 'España'));
INSERT INTO localizaciones (nombre, codigo, id_pais) VALUES ('Localizacion 2', 'LOC2', (SELECT id FROM paises WHERE nombre = 'Francia'));
INSERT INTO localizaciones (nombre, codigo, id_pais) VALUES ('Localizacion 3', 'LOC3', (SELECT id FROM paises WHERE nombre = 'Italia'));
-- Insertar datos en la tabla de hoteles
INSERT INTO hoteles (nombre, categoria, descripcion, contacto, id_localizacion) VALUES ('Hotel 1', 4, 'Descripción del Hotel 1', 'contacto1@example.com', (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 1'));
INSERT INTO hoteles (nombre, categoria, descripcion, contacto, id_localizacion) VALUES ('Hotel 2', 5, 'Descripción del Hotel 2', 'contacto2@example.com', (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 2'));
INSERT INTO hoteles (nombre, categoria, descripcion, contacto, id_localizacion) VALUES ('Hotel 3', 3, 'Descripción del Hotel 3', 'contacto3@example.com', (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 3'));
INSERT INTO hoteles (nombre, categoria, descripcion, contacto, id_localizacion) VALUES ('Hotel 4', 1, 'Descripción del Hotel 4', 'contacto4@example.com', (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 3'));
INSERT INTO hoteles (nombre, categoria, descripcion, contacto, id_localizacion) VALUES ('Hotel 5', 3, 'Descripción del Hotel 5', 'contacto5@example.com', (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 2'));
INSERT INTO hoteles (nombre, categoria, descripcion, contacto, id_localizacion) VALUES ('Hotel 6', 2, 'Descripción del Hotel 6', 'contacto6@example.com', (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 2'));

-- Insertar datos en la tabla de imagenes
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Hilton_Vienna_Plaza.jpg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 1'));
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Hotel_Artemide_2.jpg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 1'));
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Melia_Madrid_Princesa.jpg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 2'));
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Nobu_Hotel.jpg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 3'));
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Radisson_Blu_Hotel_Berlin.jpg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 3'));
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Melia_Madrid_Princesa.jpg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 4'));
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Melia_Madrid_Princesa.jpg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 5'));
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Melia_Madrid_Princesa.jpg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 6'));

-- Insertar datos en la tabla de companias
INSERT INTO companias_vuelo (nombre, contacto) VALUES ('Compania 1', 'contacto1@compania.com');
INSERT INTO companias_vuelo (nombre, contacto) VALUES ('Compania 2', 'contacto2@compania.com');
INSERT INTO companias_vuelo (nombre, contacto) VALUES ('Compania 3', 'contacto3@compania.com');
INSERT INTO companias_vuelo (nombre, contacto) VALUES ('Compania 4', 'contacto4@compania.com');

-- Insertar datos en la tabla de vuelos
INSERT INTO vuelos (nombre, descripcion, fecha_salida, fecha_llegada, id_compania, id_imagen, precio, id_origen, id_destino) VALUES ('Vuelo 1', 'Descripción Vuelo 1','2024-07-01 08:30:00', '2024-07-01 12:00:00', (SELECT id FROM companias_vuelo WHERE nombre = 'Compania 1'), (SELECT id FROM imagenes WHERE url = '/images/Hoteles/Hilton_Vienna_Plaza.jpg'), 150.00, (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 1'), (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 2'));
INSERT INTO vuelos (nombre, descripcion, fecha_salida, fecha_llegada, id_compania, id_imagen, precio, id_origen, id_destino) VALUES ('Vuelo 2','Descripción Vuelo 2','2024-07-02 14:45:00', '2024-07-02 18:15:00', (SELECT id FROM companias_vuelo WHERE nombre = 'Compania 2'), (SELECT id FROM imagenes WHERE url = '/images/Hoteles/Hotel_Artemide_2.jpg'), 200.00, (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 2'), (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 3'));
INSERT INTO vuelos (nombre, descripcion, fecha_salida, fecha_llegada, id_compania, id_imagen, precio, id_origen, id_destino) VALUES ('Vuelo 3','Descripción Vuelo 3','2024-07-04 21:15:00', '2024-07-05 00:45:00', (SELECT id FROM companias_vuelo WHERE nombre = 'Compania 4'), (SELECT id FROM imagenes WHERE url = '/images/Hoteles/Nobu_Hotel.jpg'), 220.00, (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 3'), (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 1'));

-- Inserta los tipos de habitación en la base de datos
INSERT INTO tipo_habitacion (nombre, descripcion) VALUES ('Individual', 'Habitación con una cama individual');
INSERT INTO tipo_habitacion (nombre, descripcion) VALUES ('Doble', 'Habitación con una cama doble o dos camas individuales');
INSERT INTO tipo_habitacion (nombre, descripcion) VALUES ('Suite', 'Habitación con sala de estar y dormitorio separado');
INSERT INTO tipo_habitacion (nombre, descripcion) VALUES ('Familiar', 'Habitación con varias camas, ideal para familias');
INSERT INTO tipo_habitacion (nombre, descripcion) VALUES ('Deluxe', 'Habitación de lujo con comodidades adicionales');

-- Inserta las habitaciones en la base de datos
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (101, 2, 1, 1, 1);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (102, 4, 2, 2, 1);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (103, 2, 1, 3, 1);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (104, 3, 1, 1, 1);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (105, 4, 2, 2, 3);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (106, 2, 1, 3, 2);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (107, 3, 1, 1, 2);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (108, 4, 2, 2, 2);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (109, 2, 1, 3, 2);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (110, 3, 1, 1, 2);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (111, 2, 1, 1, 5);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (112, 4, 2, 2, 6);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (113, 2, 1, 3, 4);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (114, 3, 1, 1, 3);
INSERT INTO habitaciones (numero, capacidad, numero_camas, id_tipo, id_hotel) VALUES (115, 4, 2, 2, 3);

INSERT INTO imagenes (url, id_habitacion) VALUES ('/images/Hoteles/Melia_Madrid_Princesa.jpg', 6);
INSERT INTO imagenes (url, id_habitacion) VALUES ('/images/Hoteles/Melia_Madrid_Princesa.jpg', 7);
INSERT INTO imagenes (url, id_habitacion) VALUES ('/images/Hoteles/Melia_Madrid_Princesa.jpg', 8);
INSERT INTO imagenes (url, id_habitacion) VALUES ('/images/Hoteles/Melia_Madrid_Princesa.jpg', 9);
INSERT INTO imagenes (url, id_habitacion) VALUES ('/images/Hoteles/Melia_Madrid_Princesa.jpg', 10);


# Precios Habitaciones Hotel 1
INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (100.00, '2024-01-01T00:00:00', '2024-03-31T23:59:59', 1);
INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (120.00, '2024-04-01T00:00:00', '2024-06-30T23:59:59', 1);
INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (110.00, '2024-07-01T00:00:00', '2024-09-30T23:59:59', 1);
INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (130.00, '2024-10-01T00:00:00', '2024-12-31T23:59:59', 1);

INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (100.00, '2024-01-01T00:00:00', '2024-03-31T23:59:59', 2);
INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (120.00, '2024-04-01T00:00:00', '2024-06-30T23:59:59', 2);
INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (110.00, '2024-07-01T00:00:00', '2024-09-30T23:59:59', 2);
INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (130.00, '2024-10-01T00:00:00', '2024-12-31T23:59:59', 2);

INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (100.00, '2024-01-01T00:00:00', '2024-03-31T23:59:59', 3);
INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (120.00, '2024-04-01T00:00:00', '2024-06-30T23:59:59', 3);
INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (110.00, '2024-07-01T00:00:00', '2024-09-30T23:59:59', 3);
INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (130.00, '2024-10-01T00:00:00', '2024-12-31T23:59:59', 3);

INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (100.00, '2024-01-01T00:00:00', '2024-03-31T23:59:59', 4);
INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (120.00, '2024-04-01T00:00:00', '2024-06-30T23:59:59', 4);
INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (110.00, '2024-07-01T00:00:00', '2024-09-30T23:59:59', 4);
INSERT INTO precio (precio, fecha_inicio, fecha_fin, id_habitacion) VALUES (130.00, '2024-10-01T00:00:00', '2024-12-31T23:59:59', 4);
