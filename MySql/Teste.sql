drop database urnaeletronica;


drop database urnaeletronica;


use urnaeletronica;
select *from candidato;

insert into candidato values(1,'Philipe','33',1),(2,'João','333',2),(3,'Red','3333',2),(4,'Tatu','4444',1);

delete from candidato;
desc candidato;

select *from urna; 

select cannome from candidato where cannumero = '33';


select *from partido;
-- eleitor
update eleitor set elenome='a' ,elecpf='a' ,elecep ='a',
                 elebairro = 'a',elerua ='a',elenumero = 'a'
                 where eleid = 10;
-- candidato
insert into candidato values(1,'João',33,1),
							(2,'Pedro',333,1),
                            (3,'Fala',44,2),
                            (4,'Gina',55,2);
                            
                            
                            
       select *from candidato;                     
                            
                            
                            
                            
                            select *from partido; where parid = 1;
insert into usuario values(2,'e','123');

select *from partido;
-- partido
insert into partido values(1,'PT'),
						  (2,'PSD'),
                          (3,'PSC'),
                          (4,'PSOL');
                          
alter table candidato modify canid int auto_increment;  

                        
                          
 select *from candidato 
 inner join partido on parid = canparid
 where cannome like '%%';
                          

delete from partido;



select *from eleitor;

insert into candidato values(1,'João',33,1), 
							(2,'Pedro',33,1), 
                            (3,'Fala',33,3),
                            (4,'Gina',33,2);