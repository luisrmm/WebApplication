SELECT  ordencompra.OrdenID, ordencompra.ClienteID,cliente.Nombre,cliente.Correo, ordencompra.Fecha, productoorden.ProductoID,producto.Nombre,  productoorden.Cantidad,  productoorden.Precio
FROM ordencompra
INNER JOIN productoorden ON ordencompra.OrdenID = productoorden.OrdenID
INNER JOIN cliente ON cliente.ClienteID = ordencompra.ClienteID
INNER JOIN producto ON producto.ProductoID = productoorden.ProductoID
WHERE cliente.ClienteID = 305120442;