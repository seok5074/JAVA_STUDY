--�Ϸù�ȣ ������ü
create sequence seq_sungtb_no

--�������̺�
create table sungtb
(
	no int,							--�Ϸù�ȣ
	name varchar2(100) not null,	--�̸�
	kor  int,						--����
	eng  int,						--����
	mat  int 						--����
)

--�⺻Ű
alter table sungtb
  add constraint  pk_sungtb_no  primary key(no)
  
--üũ����(���� : 0~100)
alter table sungtb
  add constraint  ck_sungtb_kor check( kor between 0 and 100 )

alter table sungtb
  add constraint  ck_sungtb_eng check( eng between 0 and 100 )
  
alter table sungtb
  add constraint  ck_sungtb_mat check( mat between 0 and 100 )
  
  
--sample data
insert into sungtb values(seq_sungtb_no.nextVal, '�ϱ浿',77,88,99);
insert into sungtb values(seq_sungtb_no.nextVal, '�̱浿',100,100,100);
insert into sungtb values(seq_sungtb_no.nextVal, '��浿',90,88,99);

insert into sungtb values(seq_sungtb_no.nextVal, '��浿',90,88,99);

insert into sungtb values(seq_sungtb_no.nextVal, '���浿',90,98,99);


select * from sungtb
  
--����/��� �־ Query
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
  
--����
select * from sungtb_view	

-- commit : DML(insert,update,delete) ����Ǿ��� �����  DB�� ����
commit 
  
  
  

--�������
/*
update table�� set �ʵ��1=��1,�ʵ��2=��2
where ����
*/

update sungtb  set name='�浿1'
where no = 1

update sungtb set name='�浿2', kor=90,eng=90,mat=90
where no = 2

--�������
/*
delete [from] table��  where ����
delete         table�� where ����
*/
delete from sungtb where no = 3  

delete sungtb where no > 5


select * from sungtb  
  
  