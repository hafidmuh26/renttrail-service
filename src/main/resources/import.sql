INSERT INTO `item` (`id`, `name`, `description`, `quantity`) VALUES (1,'Shoes','L',20);
INSERT INTO `item` (`id`, `name`, `description`, `quantity`) VALUES (2,'Tent','5 People',10);
INSERT INTO `item` (`id`, `name`, `description`, `quantity`) VALUES (3,'Bag','450 Litre',20);

INSERT INTO `user` (`id`, `nik`, `name`,`gender`, `address`, `no_hp`) VALUES (1, '3330000123495', 'Bagus','Female','Jl. Merbabu No.769', '0823145');
INSERT INTO `user` (`id`, `nik`, `name`,`gender`, `address`, `no_hp`) VALUES (2, '3330000123495', 'Bambang','Female','Jl. Merbabu No.769', '0823145');

INSERT INTO `account` (`id`, `user_name`, `password`, `email`) VALUES ('1', 'Bambang', '{bcrypt}$2y$10$NkcV4yvFbQ89UcXJY8atle.SWYmYwz6y2bZlyUq4IV/uaQY7ZbdjS', 'bambang@gmail.com');
INSERT INTO `account` (`id`, `user_name`, `password`, `email`) VALUES ('2', 'Paijo', '{bcrypt}$2y$10$NkcV4yvFbQ89UcXJY8atle.SWYmYwz6y2bZlyUq4IV/uaQY7ZbdjS', 'bambang@gmail.com');

INSERT INTO `role` (`id`, `name`) VALUES (1, 'ADMIN'), (2, 'USER'), (3, 'PARTNER');

INSERT INTO `account_role` (`account_id`, `role_id`) VALUES (1,1), (2,2);

INSERT INTO `outlet` (`id`, `name`, `telp`, `address`) VALUES ('1', 'Paijo', '08232356', 'Jl. Jalan Sama Mantan');
