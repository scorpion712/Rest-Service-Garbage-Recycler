--DROP TABLE IF EXISTS USER;
--DROP TABLE IF EXISTS USER_RECYCLING;
/*
CREATE TABLE USER (
	id BIGINT(19) NOT NULL,
	firstname VARCHAR(80) NOT NULL,
	lastname VARCHAR (80) NOT NULL,
	username VARCHAR (80) NOT NULL,
	address VARCHAR (80) NOT NULL,
	mail VARCHAR (80)  NOT NULL,
	CONSTRAINT PK_USER PRIMARY KEY (id)
);

CREATE TABLE USER_RECYCLING (
	id BIGINT(19) NOT NULL,
	fecha DATE NOT NULL,
	id_user LONG NOT NULL,
	bottles INTEGER(10) NOT NULL,
	tetrabriks INTEGER(10) NOT NULL,
	paperboard INTEGER(10) NOT NULL,
	glass INTEGER(10) NOT NULL,
	cans INTEGER(10) NOT NULL,
	CONSTRAINT PK_USER_RECYCLING PRIMARY KEY (id)
);

ALTER TABLE USER_RECYCLING
ADD CONSTRAINT FK_USER_USER_RECYCLING
FOREIGN KEY (id_user) REFERENCES USER(id);
*/
-- Note: data inserted is acording to SoapUI request used at SOAP-Service-Garbage-Recycling
-- Insert users data 
INSERT INTO USER (id, firstname, lastname, username, address, mail) 
VALUES (1, 'Homero', 'Simpson', 'homerojs', 'Av. Siempre Viva 742', 'elhombrepie@gmail.com');
INSERT INTO USER (id, firstname, lastname, username, address, mail) 
VALUES (2, 'Bart', 'Simpson', 'elbarto', 'Av. Siempre Viva 742', 'elbarto@gmail.com');
INSERT INTO USER  (id, firstname, lastname, username, address, mail) 
VALUES (3, 'Lisa', 'Simpson', 'lisams', 'Av. Siempre Viva 742', 'lisasax@gmail.com');

-- Insert the users' recycling data
INSERT INTO USER_RECYCLING (id, fecha, id_user, bottles, tetrabriks, paperboard, glass, cans) 
VALUES (1, TO_DATE('1/11/2018', 'DD/MM/YYYY'), 2, 200, 10, 6, 5, 100);
INSERT INTO USER_RECYCLING (id, fecha, id_user, bottles, tetrabriks, paperboard, glass, cans) 
VALUES (2, TO_DATE('1/11/2018', 'DD/MM/YYYY'), 1, 100, 80, 40, 45, 10);
INSERT INTO USER_RECYCLING (id, fecha, id_user, bottles, tetrabriks, paperboard, glass, cans) 
 VALUES (3, TO_DATE('2/11/2018', 'DD/MM/YYYY'), 3, 100, 80, 40, 45, 10);
INSERT INTO USER_RECYCLING (id, fecha, id_user, bottles, tetrabriks, paperboard, glass, cans) 
 VALUES (4, TO_DATE('3/11/2018', 'DD/MM/YYYY'), 3, 120, 100, 60, 75, 50);
INSERT INTO USER_RECYCLING (id, fecha, id_user, bottles, tetrabriks, paperboard, glass, cans) 
 VALUES (5, TO_DATE('4/11/2018', 'DD/MM/YYYY'), 1, 50, 20, 10, 60, 100);
INSERT INTO USER_RECYCLING (id, fecha, id_user, bottles, tetrabriks, paperboard, glass, cans) 
 VALUES (6, TO_DATE('7/11/2018', 'DD/MM/YYYY'), 3, 90, 40, 25, 70, 67);