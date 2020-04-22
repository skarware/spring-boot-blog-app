-- DROP TABLE IF EXISTS TESTAS;
-- CREATE TABLE TESTAS
-- (
--     id      BIGINT AUTO_INCREMENT PRIMARY KEY,
--     name    VARCHAR(16) NOT NULL,
--     numeris INT         NOT NULL UNIQUE,
--     info    VARCHAR     NOT NULL
-- );

create table authorities
(
    id        bigint       not null,
    authority varchar(255) not null,
    primary key (id)
);
create table comments
(
    id            bigint    not null,
    body          TEXT      not null,
    creation_date timestamp not null,
    post_id       bigint    not null,
    user_id       bigint    not null,
    primary key (id)
);
create table posts
(
    id            bigint       not null,
    body          TEXT         not null,
    creation_date timestamp    not null,
    title         varchar(255) not null,
    user_id       bigint       not null,
    primary key (id)
);
create table users
(
    id       bigint       not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
);
create table users_authorities
(
    user_id      bigint not null,
    authority_id bigint not null
);
alter table authorities
    add constraint UK_q0u5f2cdlshec8tlh6818bhbk unique (authority);
alter table users
    add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);
alter table comments
    add constraint FKh4c7lvsc298whoyd4w9ta25cr
        foreign key (post_id)
            references posts;
alter table comments
    add constraint FK8omq0tc18jd43bu5tjh6jvraq
        foreign key (user_id)
            references users;
alter table posts
    add constraint FK5lidm6cqbc7u4xhqpxm898qme
        foreign key (user_id)
            references users;
alter table users_authorities
    add constraint FKdsfxx5g8x8mnxne1fe0yxhjhq
        foreign key (authority_id)
            references authorities;
alter table users_authorities
    add constraint FKq3lq694rr66e6kpo2h84ad92q
        foreign key (user_id)
            references users;