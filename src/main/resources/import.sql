insert into client(id,name,surname,email,create_on)values(1,'john','lennon','john@lennon.com','2018-07-15');
insert into client(id,name,surname,email,create_on)values(2,'paul','mccartney','paul@mccartney.com','2018-07-15');
insert into client(id,name,surname,email,create_on)values(3,'george','harrison','george@harrison.com','2018-07-15');
insert into client(id,name,surname,email,create_on)values(4,'ringo','starr','ringo@starr.com','2018-07-15');
insert into client(id,name,surname,email,create_on)values(5,'julian','lennon','julian@lennon.com','2018-07-15');

insert into product(id,name,price,create_on)values(1,'guitar',100.0,'2018-07-15');
insert into product(id,name,price,create_on)values(2,'bass',50.0,'2018-07-15');
insert into product(id,name,price,create_on)values(3,'trumpet',1000.0,'2018-07-15');
insert into product(id,name,price,create_on)values(4,'drum',200.0,'2018-07-15');
insert into product(id,name,price,create_on)values(5,'piano',90.0,'2018-07-15');
insert into product(id,name,price,create_on)values(6,'cymbal',30.0,'2018-07-15');
insert into product(id,name,price,create_on)values(7,'triangle',60.0,'2018-07-15');
insert into product(id,name,price,create_on)values(8,'marimba',70.0,'2018-07-15');

insert into bill(id,description,client_id,create_on)values(1,'sgt. peppers bill',1,'2018-07-15');
insert into bill(id,description,client_id,create_on)values(2,'abbey road bill',1,'2018-07-15');
insert into bill(id,description,client_id,create_on)values(3,'white album bill',1,'2018-07-15');
insert into bill(id,description,client_id,create_on)values(4,'revolver bill',2,'2018-07-15');
insert into bill(id,description,client_id,create_on)values(5,'rubber soul bill',3,'2018-07-15');
insert into bill(id,description,client_id,create_on)values(6,'help bill',3,'2018-07-15');
insert into bill(id,description,client_id,create_on)values(7,'let it be bill',1,'2018-07-15');
insert into bill(id,description,client_id,create_on)values(8,'please please me bill',4,'2018-07-15');

insert into line(id,quantity,product_id,bill_id,create_on)values(1,4,1,1,'2018-07-15');
insert into line(id,quantity,product_id,bill_id,create_on)values(2,2,2,1,'2018-07-15');

insert into line(id,quantity,product_id,bill_id,create_on)values(3,1,8,2,'2018-07-15');
insert into line(id,quantity,product_id,bill_id,create_on)values(4,1,7,2,'2018-07-15');
insert into line(id,quantity,product_id,bill_id,create_on)values(5,2,2,2,'2018-07-15');
insert into line(id,quantity,product_id,bill_id,create_on)values(6,2,1,2,'2018-07-15');
