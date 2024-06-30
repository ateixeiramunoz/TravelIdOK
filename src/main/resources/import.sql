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
INSERT INTO hoteles (nombre, categoria, descripcion, contacto, precio, id_localizacion) VALUES ('Hotel 4', 0, 'Descripción del Hotel 4', 'contacto4@example.com', 25.00, (SELECT id FROM localizaciones WHERE nombre = 'Localizacion 3'));

-- Insertar datos en la tabla de imagenes
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Hilton_Vienna_Plaza.jpg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 1'));
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Hotel_Artemide_2.jpg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 1'));
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Melia_Madrid_Princesa.jpg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 2'));
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Nobu_Hotel.jpg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 3'));
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Radisson_Blu_Hotel_Berlin.jpg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 3'));
INSERT INTO imagenes (url, id_hotel) VALUES ('/images/Hoteles/Solo_soko.jpeg', (SELECT id FROM hoteles WHERE nombre = 'Hotel 4'));

