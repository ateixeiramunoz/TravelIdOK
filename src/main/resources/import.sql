-- Insertar datos en la tabla de paises
INSERT INTO paises (nombre) VALUES ('España');
INSERT INTO paises (nombre) VALUES ('Italia');
INSERT INTO paises (nombre) VALUES ('Francia');
-- Insertar datos en la tabla de localizaciones
INSERT INTO localizaciones (nombre, codigo, id_pais) VALUES ('Localizacion 1', 'LOC1', (SELECT id FROM paises WHERE nombre = 'España'));
INSERT INTO localizaciones (nombre, codigo, id_pais) VALUES ('Localizacion 2', 'LOC2', (SELECT id FROM paises WHERE nombre = 'Francia'));
INSERT INTO localizaciones (nombre, codigo, id_pais) VALUES ('Localizacion 3', 'LOC3', (SELECT id FROM paises WHERE nombre = 'Italia'));
-- Insertar datos en la tabla de hoteles
INSERT INTO hoteles (nombre, categoria, descripcion, contacto, precio, id_localizacion) VALUES ('Hotel 1', 4, 'Descripción del Hotel 1', 'contacto1@example.com', 100.00, (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 1'));
INSERT INTO hoteles (nombre, categoria, descripcion, contacto, precio, id_localizacion) VALUES ('Hotel 2', 5, 'Descripción del Hotel 2', 'contacto2@example.com', 200.00, (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 2'));
INSERT INTO hoteles (nombre, categoria, descripcion, contacto, precio, id_localizacion) VALUES ('Hotel 3', 3, 'Descripción del Hotel 3', 'contacto3@example.com', 150.00, (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 3'));
INSERT INTO hoteles (nombre, categoria, descripcion, contacto, precio, id_localizacion) VALUES ('Hotel 4', 1, 'Descripción del Hotel 4', 'contacto4@example.com', 25.00, (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 3'));
INSERT INTO hoteles (nombre, categoria, descripcion, contacto, precio, id_localizacion) VALUES ('Hotel 5', 3, 'Descripción del Hotel 5', 'contacto5@example.com', 100.00, (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 2'));
INSERT INTO hoteles (nombre, categoria, descripcion, contacto, precio, id_localizacion) VALUES ('Hotel 6', 2, 'Descripción del Hotel 6', 'contacto6@example.com', 80.00, (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 2'));


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

