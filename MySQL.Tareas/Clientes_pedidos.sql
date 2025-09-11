CREATE DATABASE IF NOT EXISTS mydb;
USE mydb;



INSERT INTO clientes (nombre, direccion, telefono) VALUES
('Antonio Perez', 'Av. Libertador 123', '987654321'),
('Ana González', 'Calle Los Pinos 45', '912345678'),
('Luis Martínez', 'Av. Las Flores 78', '987123456'),
('María Torres', 'Calle del Sol 12', '945678123'),
('Pedro Rojas', 'Av. Siempre Viva 456', '998877665');



INSERT INTO pedidos (Clientes_id_cliente, fecha, total) VALUES
(1, '2025-09-01', 150.50),
(1, '2025-09-03', 200.00),
(2, '2025-09-02', 99.99),
(2, '2025-09-05', 250.75),
(3, '2025-09-04', 300.00),
(3, '2025-09-06', 120.00),
(4, '2025-09-01', 450.20),
(4, '2025-09-07', 75.50),
(5, '2025-09-03', 180.00),
(5, '2025-09-08', 220.00);

SELECT c.id_cliente, c.nombre, c.direccion, c.telefono,
       p.id_pedido AS id_pedido, p.fecha, p.total
FROM clientes c
LEFT JOIN pedidos p ON c.id_cliente = p.Clientes_id_cliente;

SELECT *
FROM pedidos
WHERE Clientes_id_cliente = 4;

SELECT c.id_cliente, c.nombre, SUM(p.total) AS total_pedidos
FROM clientes c
LEFT JOIN pedidos p ON c.id_cliente = p.Clientes_id_cliente
GROUP BY c.id_cliente, c.nombre;

DELETE p
FROM pedidos p
INNER JOIN clientes c ON p.Clientes_id_cliente = c.id_cliente
WHERE c.id_cliente = 3;

DELETE FROM clientes
WHERE id_cliente = 3;

SELECT c.id_cliente, c.nombre, COUNT(p.id_pedido) AS numero_pedidos
FROM clientes c
LEFT JOIN pedidos p ON c.id_cliente = p.Clientes_id_cliente
GROUP BY c.id_cliente, c.nombre
ORDER BY numero_pedidos DESC
LIMIT 3;


