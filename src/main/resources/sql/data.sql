INSERT INTO TESTAS (NAME, NUMERIS, INFO) VALUES ( 'Labas', 16, 'kas darosi sienadien?' );

insert into posts (ID, BODY, CREATION_DATE, TITLE) VALUES ( 1, 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-01-10', 'test title vienas' );
insert into posts (ID, BODY, CREATION_DATE, TITLE) VALUES ( 2, 'bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb', '2020-02-20', 'test titile du' );
insert into posts (ID, BODY, CREATION_DATE, TITLE) VALUES ( 3, 'ccccccccccccccccccccccccccccccccccccccc', '2020-03-30', 'test titile trys' );

insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID) VALUES ( 1, 'comentras a', current_timestamp(), 1 );
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID) VALUES ( 2, 'comentras a', current_timestamp(), 1 );
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID) VALUES ( 3, 'comentras a', current_timestamp(), 1 );
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID) VALUES ( 4, 'comentras a', current_timestamp(), 2 );
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID) VALUES ( 5, 'comentras a', current_timestamp(), 2 );
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID) VALUES ( 6, 'comentras a', current_timestamp(), 1 );