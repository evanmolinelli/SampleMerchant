drop table OFFER;

CREATE TABLE OFFER 
(
    OFFER_ID NUMBER IDENTITY PRIMARY KEY,
	SERVICE VARCHAR2(50) NOT NULL,
	DESCRIPTION VARCHAR2(150) NOT NULL,
	PRICE NUMBER NOT NULL
);


insert into OFFER
values(1, 'beer', 'best ipas', 10);

insert into OFFER
values(2, 'hockey twigs', 'sauciest twigs in chel', 150);

insert into OFFER
values(3, 'BIZ', 'used car salesman', 2);

