INSERT INTO item (`id`, created_date, modified_date, name, price, brand_id, `variety_id`) VALUES (1,NULL,NULL,'Shoes',65000,1,3);
INSERT INTO item (`id`, created_date, modified_date, name, price, brand_id, `variety_id`) VALUES (2,NULL,NULL,'Tent',80000,2,2);
INSERT INTO item (`id`, created_date, modified_date, name, price, brand_id, `variety_id`) VALUES (3,NULL,NULL,'Bag',40000,3,1);

INSERT INTO brand (`id`, created_date, modified_date, `name`) VALUES (1,NULL,NULL,'Eiger');
INSERT INTO brand (`id`, created_date, modified_date, `name`) VALUES (2,NULL,NULL,'Consina');
INSERT INTO brand (`id`, created_date, modified_date, `name`) VALUES (3,NULL,NULL,'Arei');

INSERT INTO variety (`id`, created_date, modified_date, `name`) VALUES (1,NULL,NULL,'50 l');
INSERT INTO variety (`id`, created_date, modified_date, `name`) VALUES (2,NULL,NULL,'60 l');
INSERT INTO variety (`id`, created_date, modified_date, `name`) VALUES (3,NULL,NULL,'70 l');


INSERT INTO `user` (`id`, `nik`, `name`,`gender`, `address`, `no_hp`, `created_date`,`picture`) VALUES (1, '3330000123495', 'Bagus','Female','Jl. Merbabu No.769', '0823145', '2020-04-26 14:39:10','http://localhost:8080/users/1/imagespp.jfif');
INSERT INTO `user` (`id`, `nik`, `name`,`gender`, `address`, `no_hp`, `created_date`,`picture`) VALUES (2, '3330000123495', 'Bambang','Female','Jl. Merbabu No.769', '0823145', '2020-04-26 14:40:10', '"http://localhost:8080/users/2/imagesWhatsApp%20Image%202020-03-09%20at%2017.51.05.jpeg');

INSERT INTO `account` (`id`, `user_name`, `password`, `email`) VALUES ('1', 'Bagus', '{bcrypt}$2y$10$NkcV4yvFbQ89UcXJY8atle.SWYmYwz6y2bZlyUq4IV/uaQY7ZbdjS', 'bambang@gmail.com');
INSERT INTO `account` (`id`, `user_name`, `password`, `email`) VALUES ('2', 'Bambang', '{bcrypt}$2y$10$NkcV4yvFbQ89UcXJY8atle.SWYmYwz6y2bZlyUq4IV/uaQY7ZbdjS', 'bambang@gmail.com');

INSERT INTO `role` (`id`, `name`) VALUES (1, 'ADMIN'), (2, 'USER'), (3, 'PARTNER');

INSERT INTO `account_role` (`account_id`, `role_id`) VALUES (1,1), (2,2);

INSERT INTO `outlet` (`id`, `name`, `telp`, `address`, `created_date`,`picture`) VALUES ('1', 'Gorilla', '0823235646', 'Jl. Jalan Sama Mantan', '2020-04-22 14:55:04','http://localhost:8080/outlet/1/imagesGorilla.jpg');
INSERT INTO `outlet` (`id`, `name`, `telp`, `address`, `created_date`,`picture`) VALUES ('2', 'Arei', '0821200346', 'Jl. Jalan Sama Pacar', '2020-04-25 16:55:10','http://localhost:8080/outlet/2/imagesarei.png');
