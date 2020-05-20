create table authorities
(
    id        bigint       not null,
    authority varchar(255) not null,
    primary key (id),
    constraint UK_q0u5f2cdlshec8tlh6818bhbk unique (authority)
);
create table users
(
    id       bigint       not null,
    password varchar(255) not null,
    username varchar(255) not null,
    enabled  boolean      not null,
    primary key (id),
    constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username)
);
create table posts
(
    id            bigint       not null,
    body          TEXT         not null,
    creation_date timestamp    not null,
    title         varchar(255) not null,
    user_id       bigint       not null,
    primary key (id),
    constraint FK5lidm6cqbc7u4xhqpxm898qme
        foreign key (user_id)
            references users
);
create table comments
(
    id            bigint    not null,
    body          TEXT      not null,
    creation_date timestamp not null,
    post_id       bigint    not null,
    user_id       bigint    not null,
    primary key (id),
    constraint FKh4c7lvsc298whoyd4w9ta25cr
        foreign key (post_id)
            references posts,
    constraint FK8omq0tc18jd43bu5tjh6jvraq
        foreign key (user_id)
            references users
);
create table users_authorities
(
    user_id      bigint not null,
    authority_id bigint not null,
    primary key (user_id, authority_id),
    constraint FKdsfxx5g8x8mnxne1fe0yxhjhq
        foreign key (authority_id)
        references authorities,
    constraint FKq3lq694rr66e6kpo2h84ad92q
        foreign key (user_id)
        references users
);