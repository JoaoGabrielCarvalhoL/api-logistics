CREATE TABLE OCCURRENCE (
    id bigint not null auto_increment,
    delivery_id bigint not null,
    description text not null,
    registryDate datetime not null,
    primary key (id)
);

alter table OCCURRENCE add constraint fk_occurrence_delivery foreign key (delivery_id) references DELIVERY(id)