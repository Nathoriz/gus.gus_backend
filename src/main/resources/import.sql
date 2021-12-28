insert into rol(tiporol) values('CLIENTE');
insert into rol(tiporol) values('ADMIN');

insert into estado ( nombre ) value('Disponible');
insert into estado ( nombre ) value('No Disponible');

insert into visibilidad( visible ) values(true);
insert into visibilidad( visible ) values(false);

insert into altura(descripcion)value('vacio');
insert into relleno(descripcion)value('vacio');
insert into cubierta(nombre)value('vacio');
insert into diametro(descripcion)value('vacio');
insert into sabor(nombre,color)value('vacio',null);

insert into relleno(descripcion) values('Manjar Blanco');
insert into relleno(descripcion) values('Fodge');

insert into cubierta(nombre)values('fondam');
insert into cubierta(nombre)values('chantilly');

insert into altura(descripcion) values('12cm');
insert into altura(descripcion) values('15cm');
insert into altura(descripcion) values('17cm');
insert into altura(descripcion) values('20cm');

insert into diametro(descripcion) values('16cm');
insert into diametro(descripcion) values('18cm');
insert into diametro(descripcion) values('20cm');
insert into diametro(descripcion) values('22cm');
insert into diametro(descripcion) values('24cm');
insert into diametro(descripcion) values('26cm');

insert into sabor(nombre,color) values('Vainilla',null);
insert into sabor(nombre,color) values('Chocolate',null);
insert into sabor(nombre,color) values('Naranja',null);
insert into sabor(nombre,color) values('Vainilla + Chispas de chocolate',null);
insert into sabor(nombre,color) values('Vainilla + Frutas secas',null);
insert into sabor(nombre,color) values('Higo',null);
insert into sabor(nombre,color) values('Ingles (Higo+Pecanas/Almendras+Pasas trbias/morenas)',null);

insert into categoria( nombre, urlimg, visibilidad_id ) values('Todo', 'https://image.freepik.com/vector-gratis/conjunto-objetos-dulces-alimentos-dulces-dibujos-animados_11460-10504.jpg', 1);
insert into categoria( nombre, urlimg, visibilidad_id ) values('Tortas', 'https://previews.123rf.com/images/cherstva/cherstva1711/cherstva171100020/89790662-icono-de-la-torta-s%C3%ADmbolo-de-postre-plano-aislado-ilustraci%C3%B3n-dulce-de-la-muestra-del-vector-en-blan.jpg', 1);
insert into categoria( nombre, urlimg, visibilidad_id ) values('Galletas', 'https://previews.123rf.com/images/decobrush/decobrush1711/decobrush171100010/90847144-icono-de-cupcake-s%C3%ADmbolo-de-vacaciones-y-amor-d%C3%ADa-de-san-valent%C3%ADn-l%C3%ADnea-delgada-cumplea%C3%B1os-colorido-.jpg', 1);
insert into categoria( nombre, urlimg, visibilidad_id ) values('Muñecos', 'https://cdn0.matrimonio.com.pe/usr/5/6/0/5/cfb_144831.jpg', 1);


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


