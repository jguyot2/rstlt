-- liquibase formatted sql

-- changeset jg:songTable1
CREATE TABLE song (
    id bigserial,
    link varchar(1000),
    name varchar(255),
    submitted_by varchar(64),
    submission timestamp
)