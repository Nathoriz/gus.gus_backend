insert into rol (tiporol) values ('CLIENTE');
insert into rol (tiporol) values ('ADMIN');

insert into cliente(nombre,apellido,telefono)values('Mayra','Ortega','953625235');
insert into admin(nombre,apellido,dni)values('Alex','Pilco','71220965');

insert into usuario(cliente_id,admin_id,rol_id,usuario,contrasenia)values(1,null,1,'mayra','$2a$08$Vs4wxjUYSNDlw6dKC/VeD.CeI5t2lcrZmMuXGJms.wiCBddfTtGhS');
insert into usuario(cliente_id,admin_id,rol_id,usuario,contrasenia)values(null,1,2,'alex','$2a$08$c.21KDwm.jAhWf9Ud9pAJuzuXwGweOE.xL9mtYU0ktEU0qsMLFUO6');

insert into estado ( nombre ) values('EN ESPERA');
insert into estado ( nombre ) values('PENDIENTE');
insert into estado ( nombre ) values('ENVIADO');
insert into estado ( nombre ) values('CANCELADO');

insert into visibilidad( visible ) values(true);
insert into visibilidad( visible ) values(false);

insert into distrito ( nombre,precio ) values('SJM','15.5');
insert into distrito ( nombre,precio ) values('SJL','25.5');
insert into distrito ( nombre,precio ) values ('SURCO','28.5');

insert into altura(descripcion,precio)values('vacio',0);
insert into relleno(descripcion)values('vacio');
insert into cubierta(nombre)values('vacio');
insert into diametro(descripcion,precio)values('vacio',0);
insert into sabor(nombre,color)values('vacio','FFFFF');

insert into relleno(descripcion) values('Manjar Blanco');
insert into relleno(descripcion) values('Fodge');

insert into cubierta(nombre)values('fondam');
insert into cubierta(nombre)values('chantilly');

insert into altura(descripcion,precio) values('12cm',15);
insert into altura(descripcion,precio) values('15cm',17);
insert into altura(descripcion,precio) values('17cm',20);
insert into altura(descripcion,precio) values('20cm',25);

insert into diametro(descripcion,precio) values('16cm',18);
insert into diametro(descripcion,precio) values('18cm',20);
insert into diametro(descripcion,precio) values('20cm',20);
insert into diametro(descripcion,precio) values('22cm',25);
insert into diametro(descripcion,precio) values('24cm',25);
insert into diametro(descripcion,precio) values('26cm',30);

insert into sabor(nombre,color) values('Vainilla','FBF1E6');
insert into sabor(nombre,color) values('Chocolate','574240');
insert into sabor(nombre,color) values('Naranja','F2A8A4');
insert into sabor(nombre,color) values('Higo','8A5C65');

insert into categoria( nombre, imgnombre,urlimg, visibilidad_id ) values('Todo', '','https://i.imgur.com/fIu6we7.png', 1);
insert into categoria( nombre, imgnombre, urlimg,visibilidad_id ) values('Tortas','' ,'https://i.imgur.com/J25jrWV.png', 1);
insert into categoria( nombre, imgnombre, urlimg,visibilidad_id ) values('Cupcake','' ,'https://i.imgur.com/7nbJbS2.png', 1);
insert into categoria( nombre, imgnombre, urlimg,visibilidad_id ) values('Muñecos', '','https://i.imgur.com/tRJfCJb.png', 1);

insert into receta( costo_produccion, descripcion, tiempo_produccion ) values( 35.5, '3 Unidades Huevo, 250 Gramos Azúcar, 1/2 Taza Aceite De Maíz U Oliva, 158 Mililitros Leche, 1 Cucharadita Extracto De Vainilla, 180 Gramos harina, 60 Gramos Cacao En Polvo Nestlé, 2 Cucharaditas Polvo Para Hornear', 2.0 );
insert into receta( costo_produccion, descripcion, tiempo_produccion ) values( 30.0, '3 Unidades Huevo, 250 Gramos Azúcar, 1/2 Taza Aceite De Maíz U Oliva, 158 Mililitros Leche, 1 Cucharadita Extracto De Vainilla, 180 Gramos harina, 60 Gramos Cacao En Polvo Nestlé, 2 Cucharaditas Polvo Para Hornear', 2.0 );
insert into receta( costo_produccion, descripcion, tiempo_produccion ) values( 15.5, '3 Unidades Huevo, 250 Gramos Azúcar, 1/2 Taza Aceite De Maíz U Oliva, 158 Mililitros Leche, 1 Cucharadita Extracto De Vainilla, 180 Gramos harina, 60 Gramos Cacao En Polvo Nestlé, 2 Cucharaditas Polvo Para Hornear', 3.0 );
insert into receta( costo_produccion, descripcion, tiempo_produccion ) values( 15.5, '3 Unidades Huevo, 250 Gramos Azúcar, 1/2 Taza Aceite De Maíz U Oliva, 158 Mililitros Leche, 1 Cucharadita Extracto De Vainilla, 180 Gramos harina, 60 Gramos Cacao En Polvo Nestlé, 2 Cucharaditas Polvo Para Hornear', 3.0 );
insert into receta( costo_produccion, descripcion, tiempo_produccion ) values( 16.5, '3 Unidades Huevo, 250 Gramos Azúcar, 1/2 Taza Aceite De Maíz U Oliva, 158 Mililitros Leche, 1 Cucharadita Extracto De Vainilla, 180 Gramos harina, 60 Gramos Cacao En Polvo Nestlé, 2 Cucharaditas Polvo Para Hornear', 4.0 );
insert into receta( costo_produccion, descripcion, tiempo_produccion ) values( 19.5, '3 Unidades Huevo, 250 Gramos Azúcar, 1/2 Taza Aceite De Maíz U Oliva, 158 Mililitros Leche, 1 Cucharadita Extracto De Vainilla, 180 Gramos harina, 60 Gramos Cacao En Polvo Nestlé, 2 Cucharaditas Polvo Para Hornear', 4.0 );

insert into insumo( img, nombre,imgnombre ) values( 'https://wongfood.vteximg.com.br/arquivos/ids/472931-1000-1000/frontal-833.jpg?v=637677675083400000', 'Azucar', '' );
insert into insumo( img, nombre,imgnombre  ) values( 'https://wongfood.vteximg.com.br/arquivos/ids/231013-1000-1000/Huevos-Pardos-Wong-Bandeja-15-Unid-1-9885192.jpg?v=636667670228500000', 'Huevos', '' );
insert into insumo( img, nombre,imgnombre) values( 'https://wongfood.vteximg.com.br/arquivos/ids/472934-1000-1000/frontal1-4463.jpg?v=637677675090900000', 'Aceite de Oliva', '' );
insert into insumo( img, nombre,imgnombre ) values( 'https://wongfood.vteximg.com.br/arquivos/ids/507320-1000-1000/frontal-37.jpg?v=637762341645600000', 'Leche', '' );
insert into insumo( img, nombre,imgnombre ) values( 'https://wongfood.vteximg.com.br/arquivos/ids/492696-1000-1000/4724-01-111949.jpg?v=637716658013270000', 'Extracto de Vainilla', '' );
insert into insumo( img, nombre,imgnombre ) values( 'https://wongfood.vteximg.com.br/arquivos/ids/290634-1000-1000/3269-1.jpg?v=636921693341270000', 'Harina Blanca Flor', '' );
insert into insumo( img, nombre,imgnombre ) values( 'https://wongfood.vteximg.com.br/arquivos/ids/438979-1000-1000/Cacao-Org-nico-en-Polvo-Ecoandino-Doypack-200-g-1-135835807.jpg?v=637569872872030000', 'Cacao Orgánico en Polvo Ecoandino', '' );
insert into insumo( img, nombre,imgnombre ) values( 'https://wongfood.vteximg.com.br/arquivos/ids/472951-1000-1000/98702-01-86301.jpg?v=637677675129700000', 'Polvo para Hornear', '' );

insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '3 Unidades Huevo', 3, 1 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '250 Gramos Azúcar', 2, 1 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '1/2 Taza Aceite De Maíz U Oliva', 4, 1 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '158 Mililitros Leche', 5, 1 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '1 Cucharadita Extracto De Vainilla', 6, 1 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '180 Gramos harina', 7, 1 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '2 Cucharaditas Polvo Para Hornear', 8, 1 );


insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '3 Unidades Huevo', 3, 2 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '250 Gramos Azúcar', 2, 2 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '1/2 Taza Aceite De Maíz U Oliva', 4, 2 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '158 Mililitros Leche', 5, 2 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '1 Cucharadita Extracto De Vainilla', 6, 2 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '180 Gramos harina', 7, 2 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '2 Cucharaditas Polvo Para Hornear', 8, 2 );

insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '3 Unidades Huevo', 3, 3 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '250 Gramos Azúcar', 2, 3 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '1/2 Taza Aceite De Maíz U Oliva', 4, 3 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '158 Mililitros Leche', 5, 3 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '1 Cucharadita Extracto De Vainilla', 6, 3 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '180 Gramos harina', 7, 3 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '2 Cucharaditas Polvo Para Hornear', 8, 3 );

insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '3 Unidades Huevo', 3, 4 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '250 Gramos Azúcar', 2, 4 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '1/2 Taza Aceite De Maíz U Oliva', 4, 4 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '158 Mililitros Leche', 5, 4 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '1 Cucharadita Extracto De Vainilla', 6, 4 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '180 Gramos harina', 7, 4 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '2 Cucharaditas Polvo Para Hornear', 8, 4 );

insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '3 Unidades Huevo', 3, 5 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '250 Gramos Azúcar', 2, 5 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '1/2 Taza Aceite De Maíz U Oliva', 4, 5 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '158 Mililitros Leche', 5, 5 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '1 Cucharadita Extracto De Vainilla', 6, 5 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '180 Gramos harina', 7, 5 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '2 Cucharaditas Polvo Para Hornear', 8, 5 );

insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '3 Unidades Huevo', 3, 6 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '250 Gramos Azúcar', 2, 6 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '1/2 Taza Aceite De Maíz U Oliva', 4, 6 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '158 Mililitros Leche', 5, 6 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '1 Cucharadita Extracto De Vainilla', 6, 6 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '180 Gramos harina', 7, 6 );
insert into receta_insumo ( cantidad_uso, insumo_id, receta_id ) values( '2 Cucharaditas Polvo Para Hornear', 8, 6 );

insert into producto( descripcion, nombre, precio, urlimg, categoria_id, receta_id, visibilidad_id) values('Torta de 2 pisos', 'Rosa Elegante', 60.00, 'https://i.imgur.com/WxbKlo8.jpg', 2, 1, 1);
insert into producto( descripcion, nombre, precio, urlimg, categoria_id, receta_id, visibilidad_id) values('Torta de 1 piso', 'Conejito Rosa', 30.50, 'https://i.imgur.com/HsL5fvX.png', 2, 2, 1);
insert into producto( descripcion, nombre, precio, urlimg, categoria_id, receta_id, visibilidad_id) values('Cupcake de minios 12 Unidades', 'Minios Pra', 30.50, 'https://i.imgur.com/B2UQyYd.png', 3, 3, 1);
insert into producto( descripcion, nombre, precio, urlimg, categoria_id, receta_id, visibilidad_id) values('Cupcake de ositos', 'Love Osito', 30.50, 'https://i.imgur.com/VqZPvrk.png', 3, 4, 1);
insert into producto( descripcion, nombre, precio, urlimg, categoria_id, receta_id, visibilidad_id) values('Aloha kid', 'Ohanna', 13.50, 'https://i.imgur.com/72qTV9z.png', 4, 5, 1);
insert into producto( descripcion, nombre, precio, urlimg, categoria_id, receta_id, visibilidad_id) values('Osito papucho', 'Papu', 15.50, 'https://i.imgur.com/wCaz2vG.png', 4, 6, 1);
insert into producto( descripcion, nombre, precio, urlimg, categoria_id, receta_id, visibilidad_id) values('Moto', 'Motoroli', 16.50, 'https://i.imgur.com/wCaz2vG.png', 4, 6, 1);

insert into producto_cubierta(producto_id,cubierta_id) values(1,2);
insert into producto_sabor(producto_id,sabor_id) values(1,2);
insert into producto_sabor(producto_id,sabor_id) values(1,3);
insert into producto_diametro(producto_id,diametro_id) values(1,2);
insert into producto_diametro(producto_id,diametro_id) values(1,3);
insert into producto_relleno(producto_id,relleno_id) values(1,3);

insert into producto_cubierta(producto_id,cubierta_id) values(2,2);
insert into producto_sabor(producto_id,sabor_id) values(2,2);
insert into producto_sabor(producto_id,sabor_id) values(2,3);
insert into producto_diametro(producto_id,diametro_id) values(2,2);
insert into producto_diametro(producto_id,diametro_id) values(2,3);
insert into producto_relleno(producto_id,relleno_id) values(2,2);

insert into producto_cubierta(producto_id,cubierta_id) values(3,2);
insert into producto_sabor(producto_id,sabor_id) values(3,2);
insert into producto_relleno(producto_id,relleno_id) values(3,3)

insert into producto_cubierta(producto_id,cubierta_id) values(4,2);
insert into producto_sabor(producto_id,sabor_id) values(4,2);
insert into producto_relleno(producto_id,relleno_id) values(4,2)

insert into producto_sabor(producto_id,sabor_id) values(5,2);
insert into producto_relleno(producto_id,relleno_id) values(5,2);

insert into producto_cubierta(producto_id,cubierta_id) values(6,2);
insert into producto_altura(producto_id,altura_id) values(6,2);


insert into noticias( fecha_creacion, imgurl, nombre, observacion, visibilidad_id ) values( '2022-02-01', 'https://i.imgur.com/QQGGN0x.png', '14 de Febrero', '14 Febrero', 1 );
insert into noticias( fecha_creacion, imgurl, nombre, observacion, visibilidad_id ) values( '2022-02-01', 'https://i.imgur.com/5wwjDUW.png', 'Fantasia Chocolate', 'Fantasia chocolate', 1 );
insert into noticias( fecha_creacion, imgurl, nombre, observacion, visibilidad_id ) values( '2022-02-01', 'https://i.imgur.com/43NB2pl.png', 'Frase', 'Frase', 1 );

