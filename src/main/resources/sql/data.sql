insert into USERS (ID, PASSWORD, USERNAME, ENABLED)
VALUES (0, '', 'anonymous', true);
insert into USERS (ID, PASSWORD, USERNAME, ENABLED)
VALUES (1, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'admin', true);
insert into USERS (ID, PASSWORD, USERNAME, ENABLED)
VALUES (2, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'user', true);

insert into AUTHORITIES (ID, AUTHORITY)
VALUES (0, 'ROLE_ANONYMOUS');
insert into AUTHORITIES (ID, AUTHORITY)
VALUES (1, 'ROLE_ADMIN');
insert into AUTHORITIES (ID, AUTHORITY)
VALUES (2, 'ROLE_USER');

insert into USERS_AUTHORITIES (USER_ID, AUTHORITY_ID)
VALUES (1, 1);
insert into USERS_AUTHORITIES (USER_ID, AUTHORITY_ID)
VALUES (1, 2);
insert into USERS_AUTHORITIES (USER_ID, AUTHORITY_ID)
VALUES (2, 2);

insert into POSTS (ID, BODY, CREATION_DATE, TITLE, USER_ID)
VALUES (1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sit amet posuere ligula. Proin efficitur, turpis sed consequat maximus, turpis odio ullamcorper purus, ut malesuada justo dui sed dui. Nam eget placerat eros, eget interdum mi. Aliquam erat volutpat. Donec at magna euismod, aliquam diam sed, elementum quam. Sed sodales urna ac commodo imperdiet. Aliquam sodales nisl sed ornare consectetur. Praesent ultrices congue lacus sit amet malesuada. Nulla vitae vestibulum lorem, nec sodales arcu. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam non tempor erat, iaculis tempus eros.
Duis feugiat mauris mi, a commodo ligula blandit at. Proin a augue feugiat risus feugiat suscipit. Nullam eros orci, facilisis eget ligula eget, aliquet sodales neque. Sed ullamcorper dolor vel elit vulputate, vel molestie ante pellentesque. Morbi lectus tellus, vestibulum at quam id, mollis efficitur est. Duis viverra, dolor at sollicitudin finibus, quam odio aliquet magna, at vestibulum neque sapien ac libero. Curabitur sagittis dignissim mauris, at varius mi aliquam a. Phasellus aliquam, nisl eu dictum aliquet, justo lectus pharetra diam, ac hendrerit lacus ligula ut massa. Nulla mattis lacus quis eros vehicula pellentesque. Quisque id tortor vulputate tellus convallis vestibulum id sit amet purus. Nulla molestie, ipsum eu blandit sollicitudin, quam arcu ornare est, ut tincidunt est justo vitae ipsum. Quisque ligula lacus, tempor vel tempor tristique, semper a quam. Sed ac tellus et lacus condimentum auctor eget sit amet odio. Aenean lectus orci, placerat at quam non, viverra vestibulum libero. Suspendisse vel ipsum feugiat augue imperdiet porta. Etiam posuere mauris turpis, eu consectetur diam venenatis nec. ',
        '2020-01-10', 'Pirmas straipsnio pavadinimas', 2);
insert into POSTS (ID, BODY, CREATION_DATE, TITLE, USER_ID)
VALUES (2, 'Nulla maximus tortor libero, sed gravida ante eleifend vitae. Nulla faucibus nunc sed ex lacinia lobortis. Phasellus vitae bibendum diam. Vivamus non sem et justo vulputate tincidunt. Vivamus vehicula ullamcorper mi. Curabitur mattis a sapien non bibendum. Mauris malesuada rutrum arcu a imperdiet. Nunc nisi massa, venenatis eu ante sit amet, ultricies efficitur augue.
Nullam laoreet enim in mattis ultrices. Nam velit felis, semper eu mi a, sagittis fringilla augue. Maecenas bibendum tellus enim, vitae blandit sem fringilla nec. Quisque id cursus nisl. Vestibulum tincidunt, urna quis luctus ultrices, purus eros malesuada mi, a tempor mi diam id tellus. Fusce a urna faucibus, tincidunt lacus ac, suscipit est. Quisque sit amet suscipit est. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse viverra eu eros sit amet pharetra.
Fusce eu orci et tellus ultrices pulvinar. Etiam et nulla nec magna malesuada scelerisque ac eu est. Mauris accumsan ex non ligula facilisis, sit amet placerat lacus vestibulum. Aliquam egestas nec erat eget commodo. Mauris vehicula leo vel varius porttitor. Sed cursus sit amet massa sed gravida. Cras lectus nibh, aliquet non facilisis sed, iaculis at eros. Mauris efficitur ligula id viverra suscipit. Sed id consectetur felis, in luctus lorem. Ut pulvinar, nisi tincidunt consectetur tristique, turpis risus ultricies ipsum, sed consequat erat mi sit amet erat. Pellentesque id feugiat lectus, vel feugiat augue. ',
        '2020-02-20', 'Antras straipsnio pavadinimas', 1);
insert into POSTS (ID, BODY, CREATION_DATE, TITLE, USER_ID)
VALUES (3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sit amet posuere ligula. Proin efficitur, turpis sed consequat maximus, turpis odio ullamcorper purus, ut malesuada justo dui sed dui. Nam eget placerat eros, eget interdum mi. Aliquam erat volutpat. Donec at magna euismod, aliquam diam sed, elementum quam. Sed sodales urna ac commodo imperdiet. Aliquam sodales nisl sed ornare consectetur. Praesent ultrices congue lacus sit amet malesuada. Nulla vitae vestibulum lorem, nec sodales arcu. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam non tempor erat, iaculis tempus eros.
Duis feugiat mauris mi, a commodo ligula blandit at. Proin a augue feugiat risus feugiat suscipit. Nullam eros orci, facilisis eget ligula eget, aliquet sodales neque. Sed ullamcorper dolor vel elit vulputate, vel molestie ante pellentesque. Morbi lectus tellus, vestibulum at quam id, mollis efficitur est. Duis viverra, dolor at sollicitudin finibus, quam odio aliquet magna, at vestibulum neque sapien ac libero. Curabitur sagittis dignissim mauris, at varius mi aliquam a. Phasellus aliquam, nisl eu dictum aliquet, justo lectus pharetra diam, ac hendrerit lacus ligula ut massa. Nulla mattis lacus quis eros vehicula pellentesque. Quisque id tortor vulputate tellus convallis vestibulum id sit amet purus. Nulla molestie, ipsum eu blandit sollicitudin, quam arcu ornare est, ut tincidunt est justo vitae ipsum. Quisque ligula lacus, tempor vel tempor tristique, semper a quam. Sed ac tellus et lacus condimentum auctor eget sit amet odio. Aenean lectus orci, placerat at quam non, viverra vestibulum libero. Suspendisse vel ipsum feugiat augue imperdiet porta. Etiam posuere mauris turpis, eu consectetur diam venenatis nec.
Nulla maximus tortor libero, sed gravida ante eleifend vitae. Nulla faucibus nunc sed ex lacinia lobortis. Phasellus vitae bibendum diam. Vivamus non sem et justo vulputate tincidunt. Vivamus vehicula ullamcorper mi. Curabitur mattis a sapien non bibendum. Mauris malesuada rutrum arcu a imperdiet. Nunc nisi massa, venenatis eu ante sit amet, ultricies efficitur augue.
Nullam laoreet enim in mattis ultrices. Nam velit felis, semper eu mi a, sagittis fringilla augue. Maecenas bibendum tellus enim, vitae blandit sem fringilla nec. Quisque id cursus nisl. Vestibulum tincidunt, urna quis luctus ultrices, purus eros malesuada mi, a tempor mi diam id tellus. Fusce a urna faucibus, tincidunt lacus ac, suscipit est. Quisque sit amet suscipit est. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse viverra eu eros sit amet pharetra.
Fusce eu orci et tellus ultrices pulvinar. Etiam et nulla nec magna malesuada scelerisque ac eu est. Mauris accumsan ex non ligula facilisis, sit amet placerat lacus vestibulum. Aliquam egestas nec erat eget commodo. Mauris vehicula leo vel varius porttitor. Sed cursus sit amet massa sed gravida. Cras lectus nibh, aliquet non facilisis sed, iaculis at eros. Mauris efficitur ligula id viverra suscipit. Sed id consectetur felis, in luctus lorem. Ut pulvinar, nisi tincidunt consectetur tristique, turpis risus ultricies ipsum, sed consequat erat mi sit amet erat. Pellentesque id feugiat lectus, vel feugiat augue. ',
        '2020-03-30', 'Trečias straipsnio pavadinimas', 2);

insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (1, 'comentras a', current_timestamp(), 1, 0);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (2, 'comentras a', current_timestamp(), 1, 2);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (3, 'comentras a', current_timestamp(), 1, 0);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (4, 'comentras a', current_timestamp(), 2, 0);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (5, 'comentras a', current_timestamp(), 2, 1);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (6, 'comentras a', current_timestamp(), 1, 0);


