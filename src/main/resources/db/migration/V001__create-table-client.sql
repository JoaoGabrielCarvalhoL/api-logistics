CREATE TABLE CLIENT (
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(50) not null,
    telephone varchar(20) not null,
    primary key (id)
);