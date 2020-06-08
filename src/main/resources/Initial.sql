CREATE SEQUENCE SEQ_Author;

insert into Author (id,first_Name,last_Name) values
(NEXTVAL('SEQ_Author'), 'Yuval', 'Harari');


CREATE SEQUENCE SEQ_Book;

insert into Book (id,title,sub_title,author_id,contry,pages) values
(NEXTVAL('SEQ_Book'), ' Sapiens', 'Uma breve história da humanidade',(SELECT  id FROM Author),'USA',510);

CREATE SEQUENCE SEQ_BookUnit ;

insert into Book_unit  (id,status,book_id) values
(NEXTVAL('SEQ_BookUnit'), 'AVAILABLE', (SELECT  id FROM Book));

insert into Book_unit  (id,status,book_id) values
(NEXTVAL('SEQ_BookUnit'), 'BORROWED', (SELECT  id FROM Book));

insert into Book_unit  (id,status,book_id) values
(NEXTVAL('SEQ_BookUnit'), 'RESERVED', (SELECT  id FROM Book));



CREATE SEQUENCE SEQ_Client ;
insert into Client  (id,name) values
(NEXTVAL('SEQ_Client'), 'Joao');


CREATE SEQUENCE SEQ_Rental ;
insert into Rental  (id,book_Unit_id,client_id,rental_Date) values
(NEXTVAL('SEQ_Rental'),(SELECT  id FROM Book_unit where status = 'BORROWED'), (SELECT  id FROM Client),'2020-06-01');