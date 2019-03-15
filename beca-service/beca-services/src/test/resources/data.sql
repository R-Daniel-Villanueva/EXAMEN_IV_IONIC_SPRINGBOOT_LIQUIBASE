INSERT INTO users (id, ds_name, ds_lastname, age)
VALUES
(1, 'Javier', 'Rodriguez', 4),
(2, 'numero 2', 'apellido', 20),
(3, 'numero 3', 'apellido', 21),
(4, 'numero 4', 'apellido', 22),
(5, 'numero 5', 'apellido', 24),
(6, 'numero 6', 'apellido', 22),
(7, 'numero 7', 'apellido', 22)
;
commit;
select count(*) from users;

alter sequence users_id_seq restart with 10;