-- Crear tabla Producto
CREATE TABLE IF NOT EXISTS producto (
    cod_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    stock INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL
);

-- Insertar datos en la tabla Producto
INSERT INTO producto (nombre, stock, precio) VALUES ('Producto A', 100, 9.99);
INSERT INTO producto (nombre, stock, precio) VALUES ('Producto B', 200, 19.99);
INSERT INTO producto (nombre, stock, precio) VALUES ('Producto C', 150, 29.99);
INSERT INTO producto (nombre, stock, precio) VALUES ('Producto D', 50, 39.99);
INSERT INTO producto (nombre, stock, precio) VALUES ('Producto E', 75, 49.99);