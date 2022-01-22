insert into rol(tiporol) values('CLIENTE');
insert into rol(tiporol) values('ADMIN');

insert into cliente(nombre,apellido,telefono)values('Mayra','Ortega','953625235');
insert into admin(nombre,apellido,dni)values('Alex','Pilco','71220965');

insert into usuario(cliente_id,admin_id,rol_id,usuario,contrasenia)values(1,null,1,'mayra','$2a$08$Vs4wxjUYSNDlw6dKC/VeD.CeI5t2lcrZmMuXGJms.wiCBddfTtGhS');
insert into usuario(cliente_id,admin_id,rol_id,usuario,contrasenia)values(null,1,2,'alex','$2a$08$c.21KDwm.jAhWf9Ud9pAJuzuXwGweOE.xL9mtYU0ktEU0qsMLFUO6');

insert into estado ( nombre ) value('EN ESPERA');
insert into estado ( nombre ) value('PENDIENTE');
insert into estado ( nombre ) value('ENVIADO');
insert into estado ( nombre ) value('CANCELADO');

insert into visibilidad( visible ) values(true);
insert into visibilidad( visible ) values(false)

insert into distrito ( nombre,precio ) value('SJM','15');
insert into distrito ( nombre,precio ) value('SJL','20');
insert into distrito ( nombre,precio ) value('SURCO','20');

insert into altura(descripcion,precio)value('vacio',0);
insert into relleno(descripcion)value('vacio');
insert into cubierta(nombre)value('vacio');
insert into diametro(descripcion,precio)value('vacio',0);
insert into sabor(nombre,color)value('vacio',null);

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

insert into sabor(nombre,color) values('Vainilla',null);
insert into sabor(nombre,color) values('Chocolate',null);
insert into sabor(nombre,color) values('Naranja',null);
insert into sabor(nombre,color) values('Vainilla + Chispas de chocolate',null);
insert into sabor(nombre,color) values('Vainilla + Frutas secas',null);
insert into sabor(nombre,color) values('Higo',null);
insert into sabor(nombre,color) values('Ingles (Higo+Pecanas/Almendras+Pasas trbias/morenas)',null);

insert into categoria( nombre, urlimg, visibilidad_id ) values('Todo', 'https://i.imgur.com/fIu6we7.png', 1);
insert into categoria( nombre, urlimg, visibilidad_id ) values('Tortas', 'https://i.imgur.com/J25jrWV.png', 1);
insert into categoria( nombre, urlimg, visibilidad_id ) values('Cupcake', 'https://i.imgur.com/7nbJbS2.png', 1);
insert into categoria( nombre, urlimg, visibilidad_id ) values('Galletas', 'https://i.imgur.com/2eAMYPR.png', 1);
insert into categoria( nombre, urlimg, visibilidad_id ) values('Muñecos', 'https://i.imgur.com/tRJfCJb.png', 1);

insert into producto( descripcion, nombre, precio, urlimg, categoria_id, receta_id, visibilidad_id)values('descripcion00', 'nombre00', 20.50, 'https://scontent-lim1-1.xx.fbcdn.net/v/t39.30808-6/241212651_4323374971093615_3815958070425376942_n.png?_nc_cat=106&ccb=1-5&_nc_sid=730e14&_nc_ohc=ysoHkaph64sAX_s5ryG&_nc_ht=scontent-lim1-1.xx&oh=8b1f4849adf739823675827e3413ed2a&oe=61A167E8', 2, null, 1);
insert into producto( descripcion, nombre, precio, urlimg, categoria_id, receta_id, visibilidad_id)values('descripcion01', 'nombre01', 30.50, 'https://scontent-lim1-1.xx.fbcdn.net/v/t39.30808-6/241197756_4323381051093007_7450476239712494794_n.png?_nc_cat=103&ccb=1-5&_nc_sid=730e14&_nc_ohc=WV9BRL9O1pMAX_U3-Xr&tn=PbpgrqPRu8qcQDa8&_nc_ht=scontent-lim1-1.xx&oh=e46812d3d03fdd1587a90a50203789cf&oe=61A1BD1F', 2, null, 1);
insert into producto( descripcion, nombre, precio, urlimg, categoria_id, receta_id, visibilidad_id)values('descripcion001', 'nombre001', 30.50, 'https://scontent-lim1-1.xx.fbcdn.net/v/t1.6435-9/169307856_3747636572000794_3121185060354953223_n.png?_nc_cat=106&ccb=1-5&_nc_sid=730e14&_nc_aid=0&_nc_ohc=6NwwhWH6hnsAX9bgEHh&_nc_ht=scontent-lim1-1.xx&oh=4eb3c74484fcddfd39c9070911d68105&oe=61C0851A', 3, null, 1);
insert into producto( descripcion, nombre, precio, urlimg, categoria_id, receta_id, visibilidad_id)values('descripcion002', 'nombre002', 30.50, 'https://scontent-lim1-1.xx.fbcdn.net/v/t1.6435-9/167632032_3729238430507275_3532525859115988022_n.png?_nc_cat=107&ccb=1-5&_nc_sid=730e14&_nc_ohc=GzaGna1sQyMAX-buQzQ&_nc_ht=scontent-lim1-1.xx&oh=ec7900801f86f4ed510ac7c5ae8f8066&oe=61C05D00', 3, null, 1);
insert into producto( descripcion, nombre, precio, urlimg, categoria_id, receta_id, visibilidad_id)values('descripcion0001', 'nombre0001', 13.50, 'https://scontent-lim1-1.xx.fbcdn.net/v/t1.6435-9/129056461_3423546331076488_5076847378937020948_n.jpg?_nc_cat=111&ccb=1-5&_nc_sid=730e14&_nc_ohc=kypZJM56wN8AX_4n1Wk&tn=PbpgrqPRu8qcQDa8&_nc_ht=scontent-lim1-1.xx&oh=cf2c95e8c56867e58e9d800bb80b50ed&oe=61C14C93', 4, null, 1);
insert into producto( descripcion, nombre, precio, urlimg, categoria_id, receta_id, visibilidad_id)values('descripcion0002', 'nombre0002', 15.50, 'https://scontent-lim1-1.xx.fbcdn.net/v/t1.6435-9/95219515_2829925823771878_1912250088789377024_n.jpg?_nc_cat=103&ccb=1-5&_nc_sid=730e14&_nc_ohc=3K5fN3rUZ_4AX_30DF5&tn=PbpgrqPRu8qcQDa8&_nc_ht=scontent-lim1-1.xx&oh=2f6f9e9adb6435d440df53922bd54093&oe=61C34872', 4, null, 1);

insert into producto_altura(producto_id,altura_id) values(2,2);
insert into producto_cubierta(producto_id,cubierta_id) values(3,2);
insert into producto_sabor(producto_id,sabor_id) values(3,2);
insert into producto_sabor(producto_id,sabor_id) values(3,3);
insert into producto_diametro(producto_id,diametro_id) values(3,2);
insert into producto_diametro(producto_id,diametro_id) values(3,3);
insert into producto_relleno(producto_id,relleno_id) values(3,2);
insert into producto_relleno(producto_id,relleno_id) values(3,3);


