CREATE TABLE DELIVERY (
    id bigint not null auto_increment,
    client_id bigint not null,
    rate decimal not null,
    delivery_status varchar(20) not null,
    order_date datetime not null,
    completion_date datetime,

    addressee_name varchar(60) not null,
    addressee_public_place varchar(255) not null,
    addressee_house_number varchar(30) not null,
    addressee_complement varchar(60) not null,
    addressee_district varchar(255) not null,

    primary key (id)
);

alter table DELIVERY add constraint fk_delivery_client foreign key (client_id) references CLIENT(id)