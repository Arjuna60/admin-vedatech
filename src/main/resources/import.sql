-- CREATE TABLE `banks` (
--   `id` bigint(20) NOT NULL AUTO_INCREMENT,
--   `account_number` bigint(20) DEFAULT NULL,
--   `address` varchar(255) DEFAULT NULL,
--   `balance` double NOT NULL,
--   `email` varchar(255) DEFAULT NULL,
--   `name_bank` varchar(255) DEFAULT NULL,
--   `observation` varchar(255) DEFAULT NULL,
--   `phone` varchar(255) DEFAULT NULL,
--   `accounting_type_id` bigint(20) DEFAULT NULL,
--   PRIMARY KEY (`id`),
--   KEY `FKe16nekm6tq9oadgl689wce6av` (`accounting_type_id`)
-- ) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/* insert account name*/
INSERT INTO accounting_type (id, name_account, type_account, number_account) VALUES(1, 'Bancos', 'Activos Cirulantes', '100.000.001');
INSERT INTO accounting_type (id, name_account, type_account, number_account) VALUES(2, 'Caja Chica', 'Activos Cirulantes', '100.000.001');
INSERT INTO accounting_type (id, name_account, type_account, number_account) VALUES(3, 'Costo de Venta', 'Costo de Venta', '100.000.001');
INSERT INTO accounting_type (id, name_account, type_account, number_account) VALUES(4, 'Proveedores', 'Pasivos', '100.000.001');
INSERT INTO accounting_type (id, name_account, type_account, number_account) VALUES(5, 'Propiedad Planta y Equipo', 'Activo Fijo', '100.000.001');
INSERT INTO accounting_type (id, name_account, type_account, number_account) VALUES(6, 'Gastos de Administracion', 'Gastos', '100.000.001');
INSERT INTO accounting_type (id, name_account, type_account, number_account) VALUES(7, 'Gastos de Operacion', 'Gastos', '100.000.001');
INSERT INTO accounting_type (id, name_account, type_account, number_account) VALUES(8, 'Gastos de Ventas', 'Gastos', '100.000.001');
INSERT INTO accounting_type (id, name_account, type_account, number_account) VALUES(9, 'Nominas', 'Gastos', '100.000.001');
INSERT INTO accounting_type (id, name_account, type_account, number_account) VALUES(10, 'Clientes', 'Cuentas por Cobrar', '300.000.001');


/* insert Bank Accounts*/
INSERT INTO banks (id, name_bank, account_number, balance, accounting_type_id) VALUES('1', 'Banorte', '049051913', '10000.50', '1');
-- INSERT INTO banks (id, name_bank, account_number, balance, accounting_type_id) VALUES( 'Santander', '77889955', '15000.35', '2');
-- INSERT INTO banks (id, name_bank, account_number, balance, accounting_type_id) VALUES( 'Scotiank', '15566666', '13000.22', '3');

/* Insert Suppliers*/
INSERT INTO suppliers (id, name_supplier, taxes, accounting_type_id) VALUES(1, 'Comision Federal de Electricidad', TRUE, '6');
INSERT INTO suppliers (id, name_supplier, taxes, accounting_type_id) VALUES(2, 'Telefonos de Mexico', TRUE, '7');
INSERT INTO suppliers (id, name_supplier, taxes, accounting_type_id) VALUES(3, 'Agua y Drenaje S.A.', TRUE, '8');
INSERT INTO suppliers (id, name_supplier, taxes, accounting_type_id) VALUES(4, 'Gas Noroeste S.A.', TRUE , '9');
INSERT INTO suppliers (id, name_supplier, taxes, accounting_type_id) VALUES(5, 'Cia General de Viveres', FALSE, '9');

/* Insert Suppliers*/
INSERT INTO customers (id, name_customer, taxes, accounting_type_id) VALUES(1, 'Soriana', FALSE , '10');
INSERT INTO customers (id, name_customer, taxes, accounting_type_id) VALUES(2, 'Super Mercados Internacionales HEB ', TRUE, '10');
INSERT INTO customers (id, name_customer, taxes, accounting_type_id) VALUES(3, 'Walmart', FALSE , '10');
INSERT INTO customers (id, name_customer, taxes, accounting_type_id) VALUES(4, 'WANSA', FALSE , '10');
INSERT INTO customers (id, name_customer, taxes, accounting_type_id) VALUES(5, 'Quitakilos', FALSE, '10');


/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (username, password, enabled) VALUES ('andres','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');





