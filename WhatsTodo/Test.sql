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
	toDate date default null,
	deadLine date,
	todoCnt int default 0,
	CONSTRAINT fk_id foreign key (cid) references Client(id) on delete cascade
);
-- sample
insert into CLIENT(id, pw, name) values('admin@admin', '1234', '관리자');
insert into todo(todonum, todo, cid) values(2, '일하자', 'admin@admin');
insert into Todo (todoNum, todo, cid, deadLine) values ((SELECT NVL(MAX(todoNum),0) + 1 FROM Todo),'뭐지','admin@admin','2021-10-27');
select todocnt from todo where todo = '일하자';

delete from todo where todonum = 0;
select * from Todo where cid = 'spsbsc@naver.com' and achieveTodo = 1 order by deadline;
update Todo set todoCnt = todoCnt+1 where todo='일하자';
update Todo set todoCnt = (SELECT MAX(todoCnt) FROM todo where todo = '일하자') + 1 where todo = '일하자';
update Todo set achieveTodo = 1, toDate = sysdate where todoNum = 1

-- R
select * from CLIENT;
select * from Todo;

-- D
drop table Client;
drop table todo;
delete from CLIENT where pw='googleUser';