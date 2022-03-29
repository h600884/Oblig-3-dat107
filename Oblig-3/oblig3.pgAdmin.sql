--OBLIG 3

--INTERASJON 1-2

drop schema if exists oblig3 cascade;
create schema oblig3;
set search_path TO oblig3;
create table ansatt (ansattid serial unique primary key, brukernavn varchar(4) unique , fornavn varchar, etternavn varchar, 
					 ansattdato date, stilling varchar, monedslonn varchar);


insert into oblig3.ansatt (brukernavn, fornavn, etternavn, ansattdato, stilling, monedslonn) values 
('Tom1', 'Tom', 'Haraldsen', '2003-02-12', 'konsulent', 50000);
insert into oblig3.ansatt (brukernavn, fornavn, etternavn, ansattdato, stilling, monedslonn) values 
('HH', 'Harald', 'Hansen', '2001-02-03', 'ingeniør', 60000);
insert into oblig3.ansatt (brukernavn, fornavn, etternavn, ansattdato, stilling, monedslonn) values 
('EP', 'Erik', 'Pille', '2012-04-12', 'Utvikler', 60000);





--ITERASJON 3-4
set search_path TO oblig3;
create table avdeling ( avdelingid serial unique primary key  , navn varchar);

insert into oblig3.avdeling (navn,sjef) values ('IT', '1')
insert into oblig3.avdeling (navn, sjef) values ('Administrasjon', 2)
insert into oblig3.avdeling (navn, sjef) values ('Sikkerhet', 3)


--la til avdeling i ansatt-tabellen i ettertid  inne på pgadmin som en foreign key til avdelingid i avdeling
--la til sjef i avdeling-tabellen  i ettertid inne på pgadmin som en foreign key til ansattid i ansatt.

--med andre ord la vi de to foreign keysene manuelt på pgadmin





--INTERASJON 5

SET search_path TO oblig3;

create table Prosjekt (projektid serial primary key, prosjektnavn varchar, beskrivelse varchar);

CREATE TABLE Prosjektdeltagelse
(
  Ansattid INTEGER,
  Prosjektid INTEGER,
  Timer     INTEGER,
  CONSTRAINT Prosjektdeltagelse_PK PRIMARY KEY (Ansatt_Id, Prosjekt_Id),
  CONSTRAINT Ansatt_FK FOREIGN KEY (Ansatt_Id) REFERENCES Ansatt(ansattid),
  CONSTRAINT Prosjekt_FK FOREIGN KEY (Prosjekt_Id) REFERENCES Prosjekt(projektid))