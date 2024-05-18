
INSERT INTO product_cost (id,MRP, discount, selling_price) VALUES (1,100, 10, 90);
INSERT INTO product_quantity (id,quantity, sold_quantity, available_quantity) VALUES (1,100, 0, 100);
insert into product (IN_STOCK ,PRODUCT_COST_ID , NAME,TYPE) values (true, 1,'Chalva', 'Cloth');
INSERT INTO product_variation (id,color, size, PRODUCT_QUANTITY_ID) VALUES (1,'Color 1', 'Size 1', 1);

insert into product_product_variation values(1,1);


INSERT INTO product_cost (id,MRP, discount, selling_price) VALUES (2,100, 10, 90);
INSERT INTO product_quantity (id,quantity, sold_quantity, available_quantity) VALUES (2,100, 0, 100);
INSERT INTO product_quantity (id,quantity, sold_quantity, available_quantity) VALUES (5,100, 0, 100);
insert into product (IN_STOCK ,PRODUCT_COST_ID , NAME,TYPE ) values (true, 2,'Towel', 'Towel');
INSERT INTO product_variation (id,color, size, PRODUCT_QUANTITY_ID) VALUES (2,'red', '43X60', 2);
INSERT INTO product_variation (id,color, size, PRODUCT_QUANTITY_ID) VALUES (3,'green', '43X60' ,5);
insert into product_product_variation(PRODUCT_ID,PRODUCT_VARIATION_ID) values(2,3);
insert into product_product_variation(PRODUCT_ID,PRODUCT_VARIATION_ID) values(2,2);


INSERT INTO product_cost (id,MRP, discount, selling_price) VALUES (3,100, 10, 90);
INSERT INTO product_quantity (id,quantity, sold_quantity, available_quantity) VALUES (3,100, 0, 100);
insert into product (IN_STOCK ,PRODUCT_COST_ID ,NAME  	,TYPE ) values (true, 3,'T-Shirt', 'cloth');
INSERT INTO product_variation (id,color, size, PRODUCT_QUANTITY_ID) VALUES (4,'Green', 'Small', 3);
insert into product_product_variation values(3,4);

INSERT INTO product_cost (id,MRP, discount, selling_price) VALUES (4,100, 10, 90);
INSERT INTO product_quantity (id,quantity, sold_quantity, available_quantity) VALUES (4,100, 0, 100);
insert into product (IN_STOCK ,PRODUCT_COST_ID , NAME,TYPE ) values (true, 4,'Shirt', 'Saree');
INSERT INTO product_variation (id,color, size, PRODUCT_QUANTITY_ID) VALUES (5,'Green', 'regular', 4);
insert into product_product_variation values(4,5);



