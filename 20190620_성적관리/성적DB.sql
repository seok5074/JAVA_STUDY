--일련번호 관리객체
create sequence seq_sungtb_no

--성적테이블
create table sungtb
(
	no int,							--일련번호
	name varchar2(100) not null,	--이름
	kor  int,						--국어
	eng  int,						--영어
	mat  int 						--수학
)

--기본키
alter table sungtb
  add constraint  pk_sungtb_no  primary key(no)
  
--체크제약(점수 : 0~100)
alter table sungtb
  add constraint  ck_sungtb_kor check( kor between 0 and 100 )

alter table sungtb
  add constraint  ck_sungtb_eng check( eng between 0 and 100 )
  
alter table sungtb
  add constraint  ck_sungtb_mat check( mat between 0 and 100 )
  
  
--sample data
insert into sungtb values(seq_sungtb_no.nextVal, '일길동',77,88,99);
insert into sungtb values(seq_sungtb_no.nextVal, '이길동',100,100,100);
insert into sungtb values(seq_sungtb_no.nextVal, '삼길동',90,88,99);

insert into sungtb values(seq_sungtb_no.nextVal, '사길동',90,88,99);

insert into sungtb values(seq_sungtb_no.nextVal, '오길동',90,98,99);


select * from sungtb
  
--총점/평균 넣어서 Query
create or replace view sungtb_view
as
	select 
	  s.*,
	  rank() over(order by tot desc) as rank
	from
	(
		select
		   no,name,kor,eng,mat,
		   (kor+eng+mat) as tot,
		   round((kor+eng+mat)/3,1) as avg
		from sungtb
	) s
	order by no asc  
  
--뷰사용
select * from sungtb_view	

-- commit : DML(insert,update,delete) 수행되었던 명령을  DB에 적용
commit 
  
  
  

--수정명령
/*
update table명 set 필드명1=값1,필드명2=값2
where 조건
*/

update sungtb  set name='길동1'
where no = 1

update sungtb set name='길동2', kor=90,eng=90,mat=90
where no = 2

--삭제명령
/*
delete [from] table명  where 조건
delete         table명 where 조건
*/
delete from sungtb where no = 3  

delete sungtb where no > 5


select * from sungtb  
  
  