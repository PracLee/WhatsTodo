-- C	
create table Client(
	id varchar(50) primary key,
	pw varchar(100) not null,
	name varchar(150) not null,
	todoCnt int default 0,
	achieveCnt int default 0	
);
create table Todo(
	todonum int primary key,
	todo varchar(500) not null,
	cid varchar(50) not null,
	achieveTodo int default 0 constraint todo_achievetodo_CK check(achieveTodo = 0 or achieveTodo = 1),	
	toDate date default sysdate,
	deadLine date,
	CONSTRAINT fk_id foreign key (cid) references Client(id) on delete cascade
);
-- sample
insert into CLIENT(id, pw, name) values('admin@admin', '1234', '包府磊');
insert into todo(todonum, todo, cid) values(0, '老窍磊', 'admin@admin');
insert into Todo (todoNum, todo, cid, deadLine) values ((SELECT NVL(MAX(todoNum),0) + 1 FROM Todo),'构瘤','admin@admin','2021-10-27 09:47:51.0');

delete from todo where todonum = 0;

-- R
select * from CLIENT;
select * from Todo;

-- D
drop table Client;
drop table todo;
