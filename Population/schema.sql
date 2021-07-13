CREATE TABLE Cliente (
    ClienteID int NOT NULL PRIMARY KEY,
    Nombre varchar(30),
    Correo varchar(30),
    Contraseña varchar(50)
)

CREATE TABLE Producto (
    ProductoID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Nombre varchar(30),
    Precio int
)

CREATE TABLE OrdenCompra (
    OrdenID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ClienteID int,
    FOREIGN KEY (ClienteID) REFERENCES cliente(ClienteID),
    Fecha varchar(10)
)

CREATE TABLE ProductoOrden (
    ProductoOrdenID int NOT NULL AUTO_INCREMENT,
    OrdenID int NOT NULL,
    ProductoID int,
    FOREIGN KEY (ProductoID) REFERENCES producto(ProductoID),
    Cantidad int,
    Precio int,
    PRIMARY KEY (ProductoOrdenID, OrdenID) 
)
