create database restaurantes

use restaurantes;

create table Restaurante(
idRestaurante int,
nombre varchar(30),
tipo varchar(20),
distrito varchar(15)
)

insert into Restaurante
values (1, 'Apettit','Criollo','La Molina')

insert into Restaurante
values (2, 'KFC','Comida Rapida','Surco')

insert into Restaurante
values (3, 'Jora','Campestre','Manchay')

insert into Restaurante
values (4, 'Molinero','Cevicheria','Miraflores')

insert into Restaurante
values (5, 'Villa Chicken','Polleria','La Molina')

insert into Restaurante
values (6, 'Tinajas','Polleria','La Molina')

insert into Restaurante
values (7, 'EcoFood','Vegano','Ate')

insert into Restaurante
values (8, 'Orejitas','Anticucheria','Ate')


alter table Restaurante  add primary key (idRestaurante);

select * from Restaurante



create procedure LlamarPorId(in id int)
	begin
		select * from Restaurante where idRestaurante = id;
	end

	call LlamarPorId(1);


create procedure LlamarTodos()
	begin
		select * from Restaurante;
	end

	call LlamarTodos()