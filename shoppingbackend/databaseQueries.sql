CREATE TABLE Category(
   id IDENTITY,
   name VARCHAR(50),
   description VARCHAR(50),
   image_url VARCHAR(50),
   is_active BOOLEAN,
   
   CONSTRAINT pk_category_id PRIMARY KEY (id)
);

INSERT into Category(name,description,image_url,is_active) values('Laptop','This is Description for Laptop','img_1.jpg',true);
INSERT into Category(name,description,image_url,is_active) values('Television','This is Description for Television','img_2.jpg',true);
INSERT into Category(name,description,image_url,is_active) values('Mobile','This is Description for Mobile','img_3.jpg',true);

CREATE TABLE user_detail(
   id IDENTITY,
   first_name VARCHAR(50),
   last_name VARCHAR(50),
   role VARCHAR(50),
   enabled BOOLEAN,
   password VARCHAR(50),
   email VARCHAR(50),
   contact_number VARCHAR(50),
    CONSTRAINT pk_user_id PRIMARY KEY (id)
 );
 
 INSERT into user_detail('Virat','Kohli','ADMIN','true','admin','vk@gmail.com','8888888888');
 INSERT into user_detail('Ganesh','Kadlag','ADMIN','true','admin','vk@gmail.com','8888888888');
 INSERT into user_detail('Dhananjay','Kumbhakarna','SUPPLIER','true','supplier','dk@gmail.com','9999999999');
 
 CREATE TABLE product(
   id IDENTITY,
   code VARCHAR(50),
   name VARCHAR(50),
   brand VARCHAR(50),
   description VARCHAR(50),
   unit_price DECIMAL(10,2),
   quantity INT,
   is_active BOOLEAN,
   category_id int,
   supplier_id int,
   purchases int DEFAULT 0,
   views int DEFAULT 0,
   CONSTRAINT pk_product_id PRIMARY KEY (id),
   CONSTRAINT pk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
   CONSTRAINT pk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
 );
 
 insert into product(code,name,brand,description,unit_price,quantity,is_active,
 category_id,supplier_id,purchases,views) values 
 ('PRDIPHONE123','iPhone6s','Apple','latest released multi feature',65000,4,TRUE,3,2,0,0);
 
 insert into product(code,name,brand,description,unit_price,quantity,is_active,
 category_id,supplier_id,purchases,views) values 
 ('PRDSamsung123','Samsung s7','Samsung','Best Available five Star',23000,3,TRUE,3,3,0,0);
 
 insert into product(code,name,brand,description,unit_price,quantity,is_active,
 category_id,supplier_id,purchases,views) values 
 ('PRDGoogle123','Google Pixel','Google','low Price best Quality',40000,3,TRUE,3,2,0,0);
 
 insert into product(code,name,brand,description,unit_price,quantity,is_active,
 category_id,supplier_id,purchases,views) values 
 ('PRDIApple123','MacBook','Apple','This is best Laptop',165000,7,TRUE,1,2,0,0);
 
 insert into product(code,name,brand,description,unit_price,quantity,is_active,
 category_id,supplier_id,purchases,views) values 
 ('PRDinspiron123','Dell Inspiron 5050','Dell','full quarantee Best sold high rating',30000,4,TRUE,1,3,0,0);