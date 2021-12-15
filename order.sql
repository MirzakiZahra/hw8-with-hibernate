create table orders(
id int auto_increment,
primary key(id),
idCart int,
foreign key(idCart) references cart(id),
productId int,
foreign key(productId) references product(id)
);