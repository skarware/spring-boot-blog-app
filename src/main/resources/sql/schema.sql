DROP TABLE IF EXISTS TESTAS;
CREATE TABLE TESTAS (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(16) NOT NULL,
  numeris INT NOT NULL UNIQUE,
  info VARCHAR NOT NULL
);

create table posts (
       id bigint not null,
        body TEXT not null,
        creation_date timestamp not null,
        title varchar(255) not null,
        primary key (id)
    );

        create table comments (
       id bigint not null,
        body TEXT not null,
        creation_date timestamp not null,
        post_id bigint not null,
        primary key (id)
    );