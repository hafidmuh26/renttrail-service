INSERT INTO `brand` (`id`, `created_date`, `modified_date`, `name`) VALUES (1,NULL,NULL,'Eiger');
INSERT INTO `brand` (`id`, `created_date`, `modified_date`, `name`) VALUES (2,NULL,NULL,'Consina');
INSERT INTO `brand` (`id`, `created_date`, `modified_date`, `name`) VALUES (3,NULL,NULL,'Arei');

INSERT INTO `variety` (`id`, `created_date`, `modified_date`, `name`) VALUES (1,NULL,NULL,'50 l');
INSERT INTO `variety` (`id`, `created_date`, `modified_date`, `name`) VALUES (2,NULL,NULL,'60 l');
INSERT INTO `variety` (`id`, `created_date`, `modified_date`, `name`) VALUES (3,NULL,NULL,'70 l');

INSERT INTO `item` (`id`, `created_date`, `modified_date`, `name`, `price`, `brand_id`, `variety_id`) VALUES (1,NULL,NULL,'Shoes',65000,1,3);
INSERT INTO `item` (`id`, `created_date`, `modified_date`, `name`, `price`, `brand_id`, `variety_id`) VALUES (2,NULL,NULL,'Tent',80000,2,2);
INSERT INTO `item` (`id`, `created_date`, `modified_date`, `name`, `price`, `brand_id`, `variety_id`) VALUES (3,NULL,NULL,'Bag',40000,3,1);

