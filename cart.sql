create table cart(
id int auto_increment,
primary key(id),
customerId int,
foreign key(customerId) references customer(id)
);