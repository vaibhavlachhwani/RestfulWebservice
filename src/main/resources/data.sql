insert into USERS (ID, USERNAME, DATE_OF_BIRTH)
values (1001, 'jane', '2000-10-25');

INSERT INTO USERS (ID, USERNAME, DATE_OF_BIRTH)
VALUES (1002, 'jonah', '2004-10-30');

INSERT INTO USERS (ID, USERNAME, DATE_OF_BIRTH)
VALUES (1003, 'dina', '1998-12-25');

INSERT INTO USERS (ID, USERNAME, DATE_OF_BIRTH)
VALUES (1004, 'amy', '1999-01-25');

INSERT INTO USERS (ID, USERNAME, DATE_OF_BIRTH)
VALUES (1005, 'jake', '2004-04-28');

INSERT INTO POST (ID, CONTENT, USER_ID)
VALUES
    (2001, 'Exploring the beauty of backend development!', 1001),
    (2002, 'Does anyone know the best resources for learning AI/ML?', 1002),
    (2003, 'Feeling grateful for winning the Odoo x Amalthea hackathon!', 1001),
    (2004, 'What are some good ideas for my next Spring Boot project?', 1003),
    (2005, 'Just completed an amazing gym session. Feels great!', 1004),
    (2006, 'Planning to switch from H2 to PostgreSQL. Suggestions?', 1002),
    (2007, 'Frontend or backend? Backend all the way!', 1001),
    (2008, 'Who else loves old Hindi songs like me?', 1005);

