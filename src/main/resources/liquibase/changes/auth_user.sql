--liquibase formatted sql
--changeset SonVH25:create-table-auth_user
create table auth_user
(
    id           bigserial primary key,
    is_deleted   boolean,
    version      integer,
    created_at   timestamp(6) with time zone,
    updated_at   timestamp(6) with time zone,
    created_by   varchar(255),
    updated_by   varchar(255),

    display_name varchar(255),
    email        varchar(255) unique,
    gender       varchar(255) not null,
    password     varchar(255),
    role         varchar(255) not null
);

--changeset SonVH25:alter-table-auth_user-add-column-test
alter table auth_user
    add column test int unique not null default 0;

--changeset SonVH25:alter-table-auth_user-drop-column-test
alter table auth_user
    drop column test;