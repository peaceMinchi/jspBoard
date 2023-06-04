-- member(회원) table
create table member(
   num int primary key auto_increment,
   id varchar(20) not null,
   pass varchar(20) not null,
   name varchar(30) not null,
   age int not null,
   email varchar(30) not null,
   phone varchar(30) not null,
   unique key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
--SQL(CRUD), JDBC

--select(검색)
select * from member;

--insert(저장)
insert into member(id, pass, name, age, email, phone)
values('admin','1234', '관리자','40','bit@naver.com','010-1111-1111');

--update(수정)
update member set age=45, phone="010-1111-0000" where id='admin';

--delete(삭제)
delete from member where id='admin';

drop table member;

-- board(게시판) table
create table board(
	board_num int primary key auto_increment,
	title varchar(100) not null,
	content text null,
	id varchar(100),
	date timestamp default now(),
	view_cnt int default 0
);

select * from board;

update board set view_cnt = 2002
where board_num = 14;

insert into board(title, content, id) values('안녕하세요', 'hello', '인트텐');
insert into board(title, content, id) values('안녕하세요', 'hello', '인트일레븐');
insert into board(title, content, id) values('안녕하세요', 'hello', '인트투엘브');
insert into board(title, content, id) values('안녕하세요', 'hello', '인트설틴');
insert into board(title, content, id) values('안녕하세요', 'hello', '인트폴틴');

alter table board convert to charset utf8;

delete from board where board_num = 11;

select *, @rownum := @rownum + 1 As rownum from board, (select @rownum := 0) r order by board_num DESC;


set @rownum := 0;
select @rownum := @rownum +1 from board;


select id, title, content, row_number() over(order by board_num asc) as a from board;

